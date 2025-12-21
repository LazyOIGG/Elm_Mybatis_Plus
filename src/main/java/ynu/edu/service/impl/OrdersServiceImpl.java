package ynu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ynu.edu.dao.IBusinessDao;
import ynu.edu.dao.ICartDao;
import ynu.edu.dao.IOrderDetailetDao;
import ynu.edu.dao.IOrdersDao;
import ynu.edu.entity.Business;
import ynu.edu.entity.Cart;
import ynu.edu.entity.OrderDetailet;
import ynu.edu.entity.Orders;
import ynu.edu.service.IOrdersService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements IOrdersService {

    private final ICartDao cartDao;
    private final IOrdersDao ordersDao;
    private final IOrderDetailetDao orderDetailetDao;
    private final IBusinessDao businessDao; // 新增

    @Override
    @Transactional
    public int createOrders(Orders orders) {
        // 1. 查询当前用户购物车中当前商家的所有食品
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        List<Cart> cartList = cartDao.listCart(cart);

        if (cartList.isEmpty()) {
            throw new RuntimeException("购物车为空");
        }

        // 2. 创建订单（设置订单日期）
        orders.setOrderDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        orders.setOrderState(0); // 设置初始状态为未支付
        ordersDao.insert(orders);
        int orderId = orders.getOrderId();

        // 3. 批量添加订单明细
        List<OrderDetailet> list = new ArrayList<>();
        for (Cart c : cartList) {
            OrderDetailet od = new OrderDetailet();
            od.setOrderId(orderId);
            od.setFoodId(c.getFoodId());
            od.setQuantity(c.getQuantity());
            list.add(od);
        }
        orderDetailetDao.saveOrderDetailetBatch(list);

        // 4. 从购物车表中删除相关食品信息
        cartDao.removeCart(cart);

        log.info("用户{}创建订单{}成功", orders.getUserId(), orderId);
        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersDao.selectById(orderId);
    }

    @Override
    public Orders getOrdersWithDetails(Integer orderId) {
        // 直接使用 DAO 层方法查询完整订单信息
        List<Orders> ordersList = ordersDao.findOrdersByIdWithDetails(orderId);
        if (ordersList == null || ordersList.isEmpty()) {
            return null;
        }

        // 返回第一个订单（因为一个 orderId 只会对应一个订单）
        Orders order = ordersList.get(0);

        // 如果没有查询到明细，尝试单独查询
        if (order.getList() == null || order.getList().isEmpty()) {
            List<OrderDetailet> detailList = orderDetailetDao.getOrderDetailetByOrderId(orderId);
            order.setList(detailList);
        }

        return order;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return ordersDao.findOrdersByUserId(userId);
    }

    @Override
    public List<Orders> findOrdersByUserAndState(String userId, Integer orderState) {
        return ordersDao.findOrdersByUserAndState(userId, orderState);
    }

    @Override
    public List<Orders> findOrderHistory(String userId) {
        return ordersDao.findOrderHistory(userId);
    }

    @Override
    public boolean payOrders(Integer orderId) {
        // 更新订单状态为已支付
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setOrderState(1); // 1 表示已支付
        int result = ordersDao.updateById(order);
        return result > 0;
    }
}
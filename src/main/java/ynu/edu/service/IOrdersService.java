package ynu.edu.service;

import ynu.edu.entity.Orders;
import java.util.List;

public interface IOrdersService {
    /**
     * 创建订单
     */
    int createOrders(Orders orders);

    /**
     * 根据订单ID获取订单详情
     */
    Orders getOrdersById(Integer orderId);

    /**
     * 获取用户订单列表
     */
    List<Orders> listOrdersByUserId(String userId);
}
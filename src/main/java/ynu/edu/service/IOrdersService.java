package ynu.edu.service;

import ynu.edu.entity.Orders;
import java.util.List;

public interface IOrdersService {
    /**
     * 创建订单
     */
    int createOrders(Orders orders);

    /**
     * 根据订单ID获取订单详情（包含明细）
     */
    Orders getOrdersById(Integer orderId);

    /**
     * 获取用户订单列表（包含明细）
     */
    List<Orders> listOrdersByUserId(String userId);

    /**
     * 根据用户ID和订单状态查询（新增）
     */
    List<Orders> findOrdersByUserAndState(String userId, Integer orderState);

    /**
     * 获取用户的历史订单（新增）
     */
    List<Orders> findOrderHistory(String userId);

    /**
     * 根据订单ID获取完整订单信息（包含明细、商家信息等）
     */
    Orders getOrdersWithDetails(Integer orderId);

    /**
     * 支付订单
     */
    boolean payOrders(Integer orderId);
}
package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.Orders;
import ynu.edu.service.IOrdersService;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
@Tag(name = "订单管理", description = "订单相关操作")
@RequiredArgsConstructor
public class OrdersController {

    private final IOrdersService ordersService;

    @PostMapping("/createOrders")
    @Operation(summary = "创建订单", description = "创建订单并返回订单编号")
    public ResponseEntity<Integer> createOrders(
            @Parameter(description = "订单实体，需包含userId、businessId、orderTotal、daId", required = true)
            @RequestBody Orders orders) throws Exception {
        int orderId = ordersService.createOrders(orders);
        return ResponseEntity.ok(orderId);
    }

    @PostMapping("/getOrdersById")
    @Operation(summary = "查询订单详情", description = "根据订单编号查询订单信息")
    public ResponseEntity<Orders> getOrdersById(
            @Parameter(description = "订单实体，需包含orderId", required = true)
            @RequestBody Orders orders) throws Exception {
        Orders result = ordersService.getOrdersWithDetails(orders.getOrderId());
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/getOrdersByIdSimple")
    @Operation(summary = "查询订单基本信息", description = "根据订单编号查询订单基本信息")
    public ResponseEntity<Orders> getOrdersByIdSimple(
            @Parameter(description = "订单ID", required = true) @RequestParam Integer orderId) {
        Orders result = ordersService.getOrdersById(orderId);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/listOrdersByUserId")
    @Operation(summary = "查询用户订单列表", description = "根据用户编号查询此用户的所有订单信息")
    public ResponseEntity<List<Orders>> listOrdersByUserId(
            @Parameter(description = "订单实体，需包含userId", required = true)
            @RequestBody Orders orders) throws Exception {
        List<Orders> ordersList = ordersService.listOrdersByUserId(orders.getUserId());
        return ResponseEntity.ok(ordersList);
    }

    @PostMapping("/findOrdersByUserAndState")
    @Operation(summary = "根据状态查询订单", description = "根据用户ID和订单状态查询订单")
    public ResponseEntity<List<Orders>> findOrdersByUserAndState(
            @Parameter(description = "用户ID", required = true) @RequestParam String userId,
            @Parameter(description = "订单状态", required = true) @RequestParam Integer orderState) {
        List<Orders> ordersList = ordersService.findOrdersByUserAndState(userId, orderState);
        return ResponseEntity.ok(ordersList);
    }

    @PostMapping("/findOrderHistory")
    @Operation(summary = "查询历史订单", description = "查询用户的所有历史订单")
    public ResponseEntity<List<Orders>> findOrderHistory(
            @Parameter(description = "用户ID", required = true) @RequestParam String userId) {
        List<Orders> ordersList = ordersService.findOrderHistory(userId);
        return ResponseEntity.ok(ordersList);
    }

    @PostMapping("/payOrders")
    @Operation(summary = "支付订单", description = "根据订单编号进行支付")
    public ResponseEntity<Integer> payOrders(
            @Parameter(description = "订单ID", required = true) @RequestParam Integer orderId) {
        try {
            boolean success = ordersService.payOrders(orderId);
            return ResponseEntity.ok(success ? 1 : 0);
        } catch (Exception e) {
            return ResponseEntity.ok(0);
        }
    }
}
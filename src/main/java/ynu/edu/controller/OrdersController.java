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
        Orders result = ordersService.getOrdersById(orders.getOrderId());
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
}
package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.Cart;
import ynu.edu.service.ICartService;

import java.util.List;

@RestController
@RequestMapping("/CartController")
@Tag(name = "购物车管理", description = "购物车相关操作")
@RequiredArgsConstructor
public class CartController {

    private final ICartService cartService;

    @PostMapping("/listCart")
    @Operation(summary = "查询购物车", description = "根据用户编号和商家编号查询购物车信息")
    public ResponseEntity<List<Cart>> listCart(
            @Parameter(description = "购物车实体，需包含userId和businessId（可选）", required = true)
            @RequestBody Cart cart) throws Exception {
        List<Cart> cartList = cartService.listCart(cart);
        return ResponseEntity.ok(cartList);
    }

    @PostMapping("/saveCart")
    @Operation(summary = "添加购物车项", description = "向购物车表中添加一条记录")
    public ResponseEntity<Integer> saveCart(
            @Parameter(description = "购物车实体，需包含userId、businessId、foodId", required = true)
            @RequestBody Cart cart) throws Exception {
        int result = cartService.saveCart(cart);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateCart")
    @Operation(summary = "更新购物车数量", description = "根据用户编号、商家编号、食品编号更新数量")
    public ResponseEntity<Integer> updateCart(
            @Parameter(description = "购物车实体，需包含userId、businessId、foodId、quantity", required = true)
            @RequestBody Cart cart) throws Exception {
        int result = cartService.updateCart(cart);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/removeCart")
    @Operation(summary = "删除购物车项", description = "根据用户编号、商家编号、食品编号删除购物车项")
    public ResponseEntity<Integer> removeCart(
            @Parameter(description = "购物车实体，需包含userId、businessId、foodId（可选）", required = true)
            @RequestBody Cart cart) throws Exception {
        int result = cartService.removeCart(cart);
        return ResponseEntity.ok(result);
    }
}
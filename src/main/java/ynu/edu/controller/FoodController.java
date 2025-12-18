package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.Food;
import ynu.edu.service.IFoodService;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
@Tag(name = "食品管理", description = "食品信息查询")
@RequiredArgsConstructor
public class FoodController {

    private final IFoodService foodService;

    @PostMapping("/listFoodByBusinessId")
    @Operation(summary = "查询商家食品列表", description = "根据商家编号查询所属食品信息")
    public ResponseEntity<List<Food>> listFoodByBusinessId(
            @Parameter(description = "食品实体，需包含businessId", required = true)
            @RequestBody Food food) throws Exception {
        List<Food> foodList = foodService.listFoodByBusinessId(food.getBusinessId());
        return ResponseEntity.ok(foodList);
    }
}
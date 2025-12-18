package ynu.edu.service;

import ynu.edu.entity.Food;
import java.util.List;

public interface IFoodService {
    /**
     * 根据商家ID查询食品列表
     */
    List<Food> listFoodByBusinessId(Integer businessId);
}
package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.Food;

import java.util.List;

@Mapper
public interface IFoodDao extends BaseMapper<Food> {
    // 根据商家ID查询食品列表
    List<Food> listFoodByBusinessId(@Param("businessId") Integer businessId);

    // 根据食品ID查询食品信息
    Food getFoodById(@Param("foodId") Integer foodId);
}
package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.Business;

import java.util.List;

@Mapper
public interface IBusinessDao extends BaseMapper<Business> {
    // 1. 根据点餐分类查询商家
    List<Business> listBusinessByOrderTypeId(@Param("orderTypeId") Integer orderTypeId);

    // 2. 根据商家ID查询商家信息
    Business getBusinessById(@Param("businessId") Integer businessId);
}
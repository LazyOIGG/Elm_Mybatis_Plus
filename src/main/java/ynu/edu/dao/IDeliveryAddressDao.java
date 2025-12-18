package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.DeliveryAddress;

import java.util.List;

@Mapper
public interface IDeliveryAddressDao extends BaseMapper<DeliveryAddress> {
    // 根据用户ID查询配送地址
    List<DeliveryAddress> listDeliveryAddressByUserId(@Param("userId") String userId);

    // 根据地址ID查询配送地址
    DeliveryAddress getDeliveryAddressById(@Param("daId") Integer daId);

    // 保存配送地址
    int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    // 更新配送地址
    int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    // 删除配送地址
    int removeDeliveryAddress(@Param("daId") Integer daId);
}
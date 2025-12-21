package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.OrderDetailet;

import java.util.List;

@Mapper
public interface IOrderDetailetDao extends BaseMapper<OrderDetailet> {
    // 根据订单ID查询订单明细
    List<OrderDetailet> getOrderDetailetByOrderId(@Param("orderId") Integer orderId);

    // 批量保存订单明细（原来的方法保留）
    int saveOrderDetailetBatch(@Param("list") List<OrderDetailet> list);
}
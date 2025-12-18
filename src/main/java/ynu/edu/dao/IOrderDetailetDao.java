package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.OrderDetailet;

import java.util.List;

@Mapper
public interface IOrderDetailetDao extends BaseMapper<OrderDetailet> {
    // 批量保存订单明细
    int saveOrderDetailetBatch(@Param("list") List<OrderDetailet> list);

    // 根据订单ID查询订单明细
    List<OrderDetailet> listOrderDetailetByOrderId(@Param("orderId") Integer orderId);
}
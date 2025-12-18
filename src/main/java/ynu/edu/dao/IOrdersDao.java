package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.Orders;

import java.util.List;

@Mapper
public interface IOrdersDao extends BaseMapper<Orders> {
    // 根据用户ID查询订单（包含订单明细）
    List<Orders> findOrdersByUserId(@Param("userId") String userId);

    // 根据用户ID和订单状态查询
    List<Orders> findOrdersByUserAndState(
            @Param("userId") String userId,
            @Param("orderState") Integer orderState
    );

    // 获取用户的历史订单（已支付和未支付）
    List<Orders> findOrderHistory(@Param("userId") String userId);
}
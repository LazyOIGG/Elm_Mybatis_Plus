package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.Cart;

import java.util.List;

@Mapper
public interface ICartDao extends BaseMapper<Cart> {
    // 查询购物车（可根据条件查询）
    List<Cart> listCart(Cart cart);

    // 保存购物车项
    int saveCart(Cart cart);

    // 更新购物车项数量
    int updateCart(Cart cart);

    // 移除购物车项
    int removeCart(Cart cart);
}
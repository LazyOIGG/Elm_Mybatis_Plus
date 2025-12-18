package ynu.edu.service;

import ynu.edu.entity.Cart;
import java.util.List;

public interface ICartService {
    /**
     * 查询购物车
     */
    List<Cart> listCart(Cart cart);

    /**
     * 保存购物车项
     */
    int saveCart(Cart cart);

    /**
     * 更新购物车项数量
     */
    int updateCart(Cart cart);

    /**
     * 移除购物车项
     */
    int removeCart(Cart cart);
}
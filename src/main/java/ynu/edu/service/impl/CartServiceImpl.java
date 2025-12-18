package ynu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ynu.edu.dao.ICartDao;
import ynu.edu.entity.Cart;
import ynu.edu.service.ICartService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final ICartDao cartDao;

    @Override
    public List<Cart> listCart(Cart cart) {
        return cartDao.listCart(cart);
    }

    @Override
    public int saveCart(Cart cart) {
        return cartDao.saveCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartDao.removeCart(cart);
    }
}
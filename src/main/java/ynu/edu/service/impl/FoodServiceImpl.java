package ynu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ynu.edu.dao.IFoodDao;
import ynu.edu.entity.Food;
import ynu.edu.service.IFoodService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {

    private final IFoodDao foodDao;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodDao.listFoodByBusinessId(businessId);
    }
}
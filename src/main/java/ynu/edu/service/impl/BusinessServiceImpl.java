package ynu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ynu.edu.dao.IBusinessDao;
import ynu.edu.entity.Business;
import ynu.edu.service.IBusinessService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements IBusinessService {

    private final IBusinessDao businessDao;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessDao.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessDao.getBusinessById(businessId);
    }
}
package ynu.edu.service;

import ynu.edu.entity.Business;
import java.util.List;

public interface IBusinessService {
    /**
     * 根据点餐分类查询商家
     */
    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    /**
     * 根据商家ID查询商家信息
     */
    Business getBusinessById(Integer businessId);
}
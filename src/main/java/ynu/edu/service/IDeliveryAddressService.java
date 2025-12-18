package ynu.edu.service;

import ynu.edu.entity.DeliveryAddress;
import java.util.List;

public interface IDeliveryAddressService {
    /**
     * 根据用户ID查询配送地址
     */
    List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    /**
     * 根据地址ID查询配送地址
     */
    DeliveryAddress getDeliveryAddressById(Integer daId);

    /**
     * 保存配送地址
     */
    int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    /**
     * 更新配送地址
     */
    int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    /**
     * 删除配送地址
     */
    int removeDeliveryAddress(Integer daId);
}
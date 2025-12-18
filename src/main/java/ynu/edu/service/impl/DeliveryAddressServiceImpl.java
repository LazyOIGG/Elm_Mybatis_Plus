package ynu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ynu.edu.dao.IDeliveryAddressDao;
import ynu.edu.entity.DeliveryAddress;
import ynu.edu.service.IDeliveryAddressService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements IDeliveryAddressService {

    private final IDeliveryAddressDao addressDao;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return addressDao.listDeliveryAddressByUserId(userId);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return addressDao.getDeliveryAddressById(daId);
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return addressDao.saveDeliveryAddress(deliveryAddress);
    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return addressDao.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        return addressDao.removeDeliveryAddress(daId);
    }
}
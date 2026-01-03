package ynu.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ynu.edu.entity.Business;
import ynu.edu.entity.DeliveryAddress;
import ynu.edu.entity.Food;
import ynu.edu.entity.User;
import ynu.edu.service.IBusinessService;
import ynu.edu.service.IDeliveryAddressService;
import ynu.edu.service.IFoodService;
import ynu.edu.service.IUserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SpringBoot版项目 JUnit 单元测试
 * 覆盖核心业务：用户登录、商家查询、食品查询、收货地址查询
 */
@SpringBootTest
public class ElmServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBusinessService businessService;

    @Autowired
    private IFoodService foodService;

    @Autowired
    private IDeliveryAddressService deliveryAddressService;

    /**
     * 测试1：用户登录（查询用户）
     */
    @Test
    public void testUserLogin() {
        User userParam = new User();
        userParam.setUserId("11111111111");
        userParam.setPassword("123456");

        User user = userService.getUserByIdByPass(userParam);

        assertNotNull(user, "登录失败：返回用户为空，请检查 user 表数据或 SQL");
        assertEquals("11111111111", user.getUserId());

        System.out.println("【testUserLogin】登录成功，userName=" + user.getUserName());
    }


    /**
     * 测试2：按分类查询商家列表
     */
    @Test
    public void testListBusinessByOrderTypeId() {
        int orderTypeId = 1;

        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);

        assertNotNull(list, "商家列表返回 null，请检查数据库连接或 SQL");
        assertTrue(list.size() > 0, "商家列表为空，请检查 business 表是否存在 orderTypeId=1 的数据");

        System.out.println("【testListBusinessByOrderTypeId】商家数量=" + list.size());
        System.out.println("【testListBusinessByOrderTypeId】第一个商家=" + list.get(0).getBusinessName());
    }

    /**
     * 测试3：根据商家查询食品列表
     */
    @Test
    public void testListFoodByBusinessId() {
        int businessId = 10001;

        List<Food> list = foodService.listFoodByBusinessId(businessId);

        assertNotNull(list, "食品列表返回 null，请检查数据库连接或 SQL");
        assertTrue(list.size() > 0, "食品列表为空，请检查 food 表是否存在 businessId=10001 的数据");

        System.out.println("【testListFoodByBusinessId】食品数量=" + list.size());
        System.out.println("【testListFoodByBusinessId】第一个食品=" + list.get(0).getFoodName());
    }

    /**
     * 测试4：查询收货地址列表
     */
    @Test
    public void testListDeliveryAddressByUserId() {
        String userId = "11111111111";

        List<DeliveryAddress> list = deliveryAddressService.listDeliveryAddressByUserId(userId);

        assertNotNull(list, "收货地址列表返回 null，请检查数据库连接或 SQL");
        assertTrue(list.size() > 0, "收货地址列表为空，请检查 deliveryaddress 表是否存在该用户地址数据");

        System.out.println("【testListDeliveryAddressByUserId】地址数量=" + list.size());
        System.out.println("【testListDeliveryAddressByUserId】第一个地址=" + list.get(0).getAddress());
    }
}

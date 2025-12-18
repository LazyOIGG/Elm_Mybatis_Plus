package ynu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"business", "list"}) // 排除关联对象避免循环引用
public class Orders {
    @TableId(value = "orderId", type = IdType.AUTO)
    private Integer orderId;
    private String userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;

    // 多对一关联
    private Business business;
    // 一对多关联
    private List<OrderDetailet> list;
}
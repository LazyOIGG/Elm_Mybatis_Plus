package ynu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "foodList") // 排除foodList避免循环引用
public class Business {
    @TableId(value = "businessId", type = IdType.AUTO)
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private Double starPrice;
    private Double deliveryPrice;
    private String remarks;


    private List<Food> foodList = new ArrayList<>();
}
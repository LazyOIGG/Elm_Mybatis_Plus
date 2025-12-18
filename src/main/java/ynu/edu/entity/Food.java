package ynu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "business")
public class Food {
    @TableId(value = "foodId", type = IdType.AUTO)
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private Double foodPrice;
    private String remarks;
    private Integer businessId;
    private Business business;
}
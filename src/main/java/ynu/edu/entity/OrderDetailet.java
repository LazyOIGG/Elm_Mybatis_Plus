package ynu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "food") // 排除food避免循环引用
public class OrderDetailet {
    @TableId(value = "odId", type = IdType.AUTO)
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;

    private Food food;
}
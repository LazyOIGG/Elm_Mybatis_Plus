package ynu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(value = "userId", type = IdType.AUTO)
    private String userId;
    private String password;
    private String userName;
    private Integer userSex;
    private String userImg;
    private Integer delTag;
}
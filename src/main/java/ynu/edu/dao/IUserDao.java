package ynu.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ynu.edu.entity.User;

@Mapper
public interface IUserDao extends BaseMapper<User> {
    // 根据用户ID和密码查询用户
    User getUserByIdByPass(@Param("userId") String userId, @Param("password") String password);

    // 根据用户ID查询用户数量（用于判断用户是否存在）
    int getUserById(@Param("userId") String userId);

    // 保存用户（注册）
    int saveUser(User user);
}
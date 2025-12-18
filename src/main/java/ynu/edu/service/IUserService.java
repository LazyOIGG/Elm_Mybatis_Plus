package ynu.edu.service;

import ynu.edu.entity.User;

public interface IUserService {
    /**
     * 根据用户ID和密码查询用户
     */
    User getUserByIdByPass(User user);

    /**
     * 根据用户ID查询用户数量
     */
    int getUserById(String userId);

    /**
     * 保存用户（注册）
     */
    int saveUser(User user);
}
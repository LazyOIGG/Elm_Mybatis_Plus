package ynu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ynu.edu.dao.IUserDao;
import ynu.edu.entity.User;
import ynu.edu.service.IUserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    @Override
    public User getUserByIdByPass(User user) {
        return userDao.getUserByIdByPass(user.getUserId(), user.getPassword());
    }

    @Override
    public int getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
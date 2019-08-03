package com.gold.service.impl;

import com.gold.dao.UserDao;
import com.gold.entity.User;
import com.gold.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SSM-Learn
 * com.gold.service.impl
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Boolean addUser(User user) {
        if (userDao.select(user.getU_id()) == null) {
            userDao.insert(user);
            return true;
        }
        System.out.println("User already exist");
        return false;
    }

    @Override
    public User userInfo(String u_id) {
        return userDao.select(u_id);
    }

    @Override
    public User check(String u_id, String password) {
        return userDao.login(u_id, password);
    }

    @Override
    public void changInfo(User user) {
        userDao.update(user);
    }

}

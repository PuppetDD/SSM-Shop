package com.gold.service;

import com.gold.entity.User;

/**
 * SSM-Shop
 * com.gold.service
 *
 * @author GOLD
 * @date 2019/8/2
 */

public interface UserService {

    User userInfo(String u_id);

    Boolean addUser(User user);

    User check(String u_id, String password);

    void changInfo(User user);

}

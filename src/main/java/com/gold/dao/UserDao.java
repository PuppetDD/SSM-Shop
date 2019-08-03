package com.gold.dao;

import com.gold.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * SSM-Learn
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */
public interface UserDao {

    void insert(User user);

    User select(String u_id);

    User login(@Param("u_id") String u_id, @Param("password")String password);

    void update(User user);

}

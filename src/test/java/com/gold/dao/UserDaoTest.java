package com.gold.dao;

import com.gold.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SSM-Learn
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        User user = new User();
        user.setU_id("4444");
        user.setU_name("PP");
        user.setU_password("123456");
        user.setU_number("16769876767");
        user.setU_mail("1098989898@qq.com");
        user.setU_sex("m");
        user.setU_address("华南农业大学");
        //userDao.insert(user);
    }

    @Test
    public void testLogin() {
        User user = userDao.login("1222", "123456");
        System.out.println(user.getU_name());
    }

}

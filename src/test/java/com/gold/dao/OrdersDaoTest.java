package com.gold.dao;

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
public class OrdersDaoTest {

    @Autowired
    private OrdersDao ordersDao;

    @Test
    public void testSelectByUserId() {

    }

    @Test
    public void testInsert() {

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testUpdate() {

    }

}

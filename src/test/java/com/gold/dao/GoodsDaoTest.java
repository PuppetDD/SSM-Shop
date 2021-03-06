package com.gold.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SSM-Shop
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void testSelectById() {

    }

    @Test
    public void testShowGoodsList() {

    }

    @Test
    public void testShowGoodsListByType() {

    }

    @Test
    public void testShowGoodsListBySearch() {
        System.out.println(goodsDao.showGoodsListBySearch("洗发水"));
    }

}

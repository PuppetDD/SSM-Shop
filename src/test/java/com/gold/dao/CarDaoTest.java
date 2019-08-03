package com.gold.dao;

import com.gold.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * SSM-Shop
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class CarDaoTest {

    @Autowired
    private CarDao carDao;

    @Test
    public void testFindById() {
        System.out.println(carDao.findById("1222", "765332"));
        if (carDao.findById("1222", "123456") == null) {
            System.out.println("it is null");
        }
    }

    @Test
    public void testSelectById() {
        List<Car> cars = carDao.selectById("1222");
        for (Car car : cars) {
            System.out.println(car.getC_id());
        }
    }

    @Test
    public void testInsert() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDeleteById() {

    }

}

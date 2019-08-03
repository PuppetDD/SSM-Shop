package com.gold.service.impl;

import com.gold.dao.CarDao;
import com.gold.entity.Car;
import com.gold.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SSM-Learn
 * com.gold.service.impl
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarDao carDao;

    @Override
    public void GoodsHandler(Car car) {
        int n;
        if (carDao.findById(car.getU_id(), car.getG_id()) == null) {
            n = 0;
        } else {
            n = carDao.findById(car.getU_id(), car.getG_id());
        }
        if (n > 0) {
            carDao.update(car.getC_id(), car.getC_amount() + n, car.getU_id(), car.getG_id());
        } else {
            carDao.insert(car);
        }
    }

    @Override
    public List<Car> showUserCar(String u_id) {
        return carDao.selectById(u_id);
    }

    @Override
    public void deleteUserCar(String c_id) {
        carDao.deleteById(c_id);
    }

}

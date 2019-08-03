package com.gold.service;

import com.gold.entity.Car;

import java.util.List;

/**
 * SSM-Shop
 * com.gold.service
 *
 * @author GOLD
 * @date 2019/8/2
 */

public interface CarService {

    void GoodsHandler(Car car);

    List<Car> showUserCar(String u_id);

    void deleteUserCar(String c_id);

}

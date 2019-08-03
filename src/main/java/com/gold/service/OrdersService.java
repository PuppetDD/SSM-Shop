package com.gold.service;

import com.gold.entity.Car;
import com.gold.entity.Orders;

import java.util.List;

/**
 * SSM-Learn
 * com.gold.service
 *
 * @author GOLD
 * @date 2019/8/2
 */
public interface OrdersService {

    void addOrders(List<Car> c_list, String method, String Status);

    List<Orders> showUserOrders(String u_id);

    void deleteOrder(String o_id);

    void updateOrder(String method, String status, String o_id);

}

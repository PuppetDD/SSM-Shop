package com.gold.service.impl;

import com.gold.dao.CarDao;
import com.gold.dao.OrdersDao;
import com.gold.entity.Car;
import com.gold.entity.Orders;
import com.gold.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * SSM-Shop
 * com.gold.service.impl
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersDao ordersDao;

    @Resource
    private CarDao carDao;

    @Override
    public void addOrders(List<Car> c_list, String method, String status) {
        for (Car c : c_list) {
            //添加订单
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            c.setO_id(time.format(new Date()) + c.getG_id());
            System.out.println("order_id:" + c.getO_id());
            Orders orders = new Orders();
            orders.setO_id(c.getO_id());
            orders.setU_id(c.getU_id());
            orders.setB_id(c.getB_id());
            orders.setG_id(c.getG_id());
            orders.setO_amount(c.getC_amount());
            orders.setO_price(c.getPrice());
            orders.setMethod(method);
            orders.setStatus(status);
            ordersDao.insert(orders);
            if (c.getC_id() != null) {
                carDao.deleteById(c.getC_id());
            }
        }
    }

    @Override
    public List<Orders> showUserOrders(String u_id) {
        return ordersDao.selectByUserId(u_id);
    }

    @Override
    public void deleteOrder(String o_id) {
        ordersDao.delete(o_id);
    }

    @Override
    public void updateOrder(String method, String status, String o_id) {
        ordersDao.update(method, status, o_id);
    }

}

package com.gold.controller;

import com.gold.entity.Car;
import com.gold.entity.User;
import com.gold.service.CarService;
import com.gold.service.OrdersService;
import com.gold.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * SSM-Shop
 * com.gold.controller
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Controller
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @Resource
    private CarService carService;

    @Resource
    private UserService userService;

    @RequestMapping("/addOrder.do")
    public String addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Object object = request.getSession().getAttribute("car_list");
        ArrayList<Car> c_list = (ArrayList<Car>) object;
        ArrayList<User> users = new ArrayList<>();
        String u_id = (String) request.getSession().getAttribute("User_id");
        String m = request.getParameter("method");
        String method = m == null ? " " : m;
        String status = request.getParameter("status") == null ? "未完成" : "已完成";

        users.add(userService.userInfo(u_id));
        //添加订单
        ordersService.addOrders(c_list,method,status);
        request.setAttribute("car_list", c_list);
        request.setAttribute("user_address", users);
        return "order";
    }

    @RequestMapping("/userOrders.do")
    public String userOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String u_id = (String) request.getSession().getAttribute("User_id");
        System.out.println("Orders u_id:" + u_id);
        request.setAttribute("orders", ordersService.showUserOrders(u_id));
        return "orders";
    }

    @RequestMapping("/deleteOrder.do")
    public String deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String o_id = request.getParameter("OrdersDelete");
        System.out.println("OrdersDelete:" + o_id);
        ordersService.deleteOrder(o_id);
        return "redirect:/userOrders.do";
    }

    @RequestMapping("/submitOrder.do")
    public String submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String m = request.getParameter("method");
        System.out.println("method:" + m);
        String method = m == null ? " " : m;
        String status = "已完成";
        Object object = request.getSession().getAttribute("updateOrders");
        ArrayList<Car> orders = (ArrayList<Car>) object;
        for (Car o : orders) {
            ordersService.updateOrder(method, status, o.getO_id());
        }
        return "redirect:/index.do";
    }

}

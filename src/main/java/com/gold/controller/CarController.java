package com.gold.controller;

import com.gold.entity.Car;
import com.gold.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * SSM-Shop
 * com.gold.controller
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Controller
public class CarController {

    @Resource
    private CarService carService;

    @RequestMapping("/addCar.do")
    public String addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddCar");
        request.setCharacterEncoding("UTF-8");
        ArrayList<Car> cars = new ArrayList<>();
        int c_amount = Integer.parseInt(request.getParameter("c_amount"));
        Car car = (Car) request.getSession().getAttribute("addCar");
        car.setC_amount(c_amount);
        cars.add(car);
        String path;
        if (request.getParameter("flag").equals("1")) {
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            car.setC_id(time.format(new Date()) + car.getU_id());
            carService.GoodsHandler(car);
            path = "redirect:/details.do?g_id=" + car.getG_id() + "&insert=1";
        } else {
            //立即购买，请求转发到ServletOrder
            request.getSession().setAttribute("car_list", cars);
            request.setAttribute("User_id", car.getU_id());
            path = "redirect:/addOrder.do";
        }
        return path;
    }

    @RequestMapping("/userCar.do")
    public String userCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String u_id = (String) request.getSession().getAttribute("User_id");
        request.setAttribute("cars", carService.showUserCar(u_id));
        return "car";
    }

    @RequestMapping("/deleteCar.do")
    public String deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String c_id = request.getParameter("Delete");
        System.out.println("DeleteCar:" + c_id);
        carService.deleteUserCar(c_id);
        return "redirect:/userCar.do";
    }

}
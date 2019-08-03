package com.gold.controller;

import com.gold.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SSM-Shop
 * com.gold.controller
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Controller
public class IndexController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/index.do")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String style = request.getParameter("style");
        String key = request.getParameter("key");
        System.out.println("key:" + key);
        return goodsService.showGoods(request, key, style);
    }

    @RequestMapping("/indexRegister.do")
    public String indexRegister(HttpServletRequest request, HttpServletResponse response) {
        //页面间的跳转需要借助controller，return "register";表示转发到页面
        //return "redirect：register";表示重定向到方法
        //return "forward：register";表示请求转发到方法
        return "register";
    }

    @RequestMapping("/indexLogin.do")
    public String indexLogin(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

}

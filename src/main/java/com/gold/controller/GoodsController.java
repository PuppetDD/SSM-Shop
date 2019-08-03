package com.gold.controller;

import com.gold.entity.Goods;
import com.gold.service.GoodsService;
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
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/details.do")
    protected String details(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Details 详细信息");
        request.setCharacterEncoding("UTF-8");
        //获取传进来的参数
        String g_id = request.getParameter("g_id");
        System.out.println(g_id);
        ArrayList<Goods> g_list = new ArrayList<>();
        g_list.add(goodsService.showDetails(g_id));
        request.setAttribute("Details", g_list);
        return "details";
    }

}

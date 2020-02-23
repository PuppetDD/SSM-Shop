package com.gold.controller;

import com.gold.entity.User;
import com.gold.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
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
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/userLogin.do")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String exist = request.getParameter("exist");
        String id = request.getParameter("User_id");
        String password = request.getParameter("User_password");
        System.out.println("User_id:" + id);
        System.out.println("User_password:" + password);
        User user = userService.check(id, password);

        String path;
        if (user != null) {
            request.getSession().setAttribute("User", user.getU_name());
            request.getSession().setAttribute("User_id", user.getU_id());
            path = "redirect:/index.do";
        } else {
            System.out.println("error");
            path = "redirect:/index.do?error=yes";
        }
        if (exist != null) {
            path = "redirect:/index.do?exist=yes";
        }
        return path;
    }

    @RequestMapping("/userLogout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("User", null);
        request.getSession().setAttribute("User_id", null);
        return "redirect:/index.do";
    }

    @RequestMapping("/userInfo.do")
    public String self(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String u_id = (String) request.getSession().getAttribute("User_id");
        request.setAttribute("self", userService.userInfo(u_id));
        return "self";
    }

    @RequestMapping("/userChange.do")
    public String change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String u_id = request.getParameter("User_id");
        String u_number = request.getParameter("User_number");
        String u_name = request.getParameter("User_name");
        String u_mail = request.getParameter("User_mail");
        String u_address = request.getParameter("User_address");

        String path = null;
        User user = userService.userInfo(u_id);
        if (user != null) {
            user.setU_name(u_name);
            user.setU_number(u_number);
            user.setU_mail(u_mail);
            user.setU_address(u_address);
            userService.changInfo(user);
            System.out.println("id:" + user.getU_id() + " password:" + user.getU_password());
            path = "redirect:/userLogin.do?User_id=" + user.getU_id() + "&User_password=" + user.getU_password();
        }
        return path;
    }

    @RequestMapping("/userRegister.do")
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String u_id = request.getParameter("User_id");
        String u_name = request.getParameter("User_name");
        String u_password = request.getParameter("User_password");
        String u_number = request.getParameter("User_number");
        String u_mail = request.getParameter("User_mail");
        String u_sex = request.getParameter("User_sex");
        String u_address = request.getParameter("User_address");
        User user = new User();
        user.setU_id(u_id);
        user.setU_name(u_name);
        user.setU_password(u_password);
        user.setU_number(u_number);
        user.setU_mail(u_mail);
        user.setU_sex(u_sex);
        user.setU_address(u_address);
        String path;
        if (userService.addUser(user)) {
            path = "redirect:/userLogin.do?User_id=" + user.getU_id() + "&User_password=" + user.getU_password();
        } else {
            path = "redirect:/userLogin.do?exist=yes";
        }
        return path;
    }

}

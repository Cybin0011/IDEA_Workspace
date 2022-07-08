package com.Cybin.Web; /**
 * @description TODO
 * @author Chen Yuanbin
 * @create 2022-07-08 9:49
 */

import com.Cybin.Mapper.UserMapper;
import com.Cybin.Pojo.User;
import com.Cybin.Service.UserService;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
//   cookie 读取值
//  测试复选框 System.out.println("remember ："+remember);
        User user = userService.select(username, password);
        if (user == null) {
//            登录失败
            request.setAttribute("msg_err","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {
//            登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user",user);//使得数据在整个会话期间都不会被销毁
            if ("1".equals(remember)) {
//            设置cookie
                Cookie c_username=new Cookie("username",username);
                Cookie c_password = new Cookie("password", password);
                c_password.setMaxAge(3600*24*7);
//            发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            response.sendRedirect("/JSP-Demo/SelectAllServlet");//知识跳转页面而已，数据分享再上一步已经完成了
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

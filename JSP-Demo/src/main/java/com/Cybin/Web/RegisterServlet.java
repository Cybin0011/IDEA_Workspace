package com.Cybin.Web; /**
 * @description TODO
 * @author Chen Yuanbin
 * @create 2022-07-10 10:13
 */

import com.Cybin.Pojo.User;
import com.Cybin.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        用户输入的验证码
        String checkCodeByuser = request.getParameter("checkCode");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        HttpSession session = request.getSession();
//        自动生产的验证码
        String checkCode = (String) session.getAttribute("checkCode");
        boolean flag_checkCode = checkCode.equalsIgnoreCase(checkCodeByuser) ;
        if(flag_checkCode){
//            验证码匹配成功
            boolean flag_user = userService.register(user);
            if(flag_user){
//                注册成功
                request.setAttribute("msg_register","该恭喜你注册成功！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
            else{
//                注册失败，该用户名已存在
                request.setAttribute("msg_register","该用户名已存在");
            }
        }else{
//            验证码不匹配
            request.setAttribute("msg_register","验证码错误");
        }
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

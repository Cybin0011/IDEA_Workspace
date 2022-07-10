package com.Cybin.Web; /**
 * @description TODO
 * @author Chen Yuanbin
 * @create 2022-07-10 8:57
 */

import com.Cybin.Service.CheckCodeUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码的图片位置,生成到response输出流
        OutputStream fos = response.getOutputStream();
        //checkCode为最终验证码的数据
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, fos, 4);
        HttpSession session_checkCode = request.getSession();
        session_checkCode.setAttribute("checkCode",checkCode);
        System.out.println("图片生成");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

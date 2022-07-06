package com.Cybin.Web; /**
 * @description TODO
 * @author Chen Yuanbin
 * @create 2022-07-06 21:23
 */

import com.Cybin.Pojo.Brand;
import com.Cybin.Service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        brandService.deleteById(Integer.parseInt(id));
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.learning.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ServletAjax", urlPatterns = {"/ajax"})
public class ServletAjax extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if("ajaxListar".equals(acao)){
            listarAlgo(request, response);
        }
    }
   
    protected void listarAlgo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}

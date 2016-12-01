package com.learning.uf;

import com.learning.common.ServletUtil;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ServletUf", urlPatterns = {"/uf"})
public class ServletUf extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if("ajax_listar".equals(acao)){
            ajaxListarUf(request, response);
        }
    }
    
    private void ajaxListarUf(HttpServletRequest request, HttpServletResponse response){
        UfDAO model = new UfDAO();
        JSONObject result = new JSONObject();
        Exception ex = null;
        try {
            JSONArray array = model.ajaxAsArray();
            result.put("array", array);
        } catch (SQLException e) {
            e.printStackTrace();
            ex = e;
        }
        
        try {
            ServletUtil.renderAjax(result, response, ex);
        } catch (Exception e) {
            Logger.getLogger(ServletUf.class).log(Level.SEVERE, null, e);
        }
    }
}

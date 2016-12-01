package com.learning.municipio;

import com.learning.common.ServletUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletMunicipio", urlPatterns = {"/municipio"})
public class ServletMunicipio extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if("ajax_listar".equals(acao)){
            ajaxListarMunicipio(request, response);
        }
    }
    
    private void ajaxListarMunicipio(HttpServletRequest request, HttpServletResponse response){
        MunicipioDAO model = new MunicipioDAO();
        JSONObject result = new JSONObject();
        Exception ex = null;
        Integer uf = Integer.valueOf((request.getParameter("id_uf") != null && !request.getParameter("id_uf").isEmpty()) ? request.getParameter("id_uf") : "0");
        try {
            JSONArray array = model.ajaxMunicipios(uf);
            JSONArray list = model.ajaxMunicipios();
            result.put("array", array);
            result.put("list", list);
        } catch (SQLException e) {
            ex = e;
            Logger.getLogger(ServletMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ServletUtil.renderAjax(result, response, ex);
        } catch (Exception e) {
        }
    }
}
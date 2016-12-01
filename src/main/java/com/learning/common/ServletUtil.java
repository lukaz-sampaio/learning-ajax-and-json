package com.learning.common;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lucas
 */
public class ServletUtil {

    private ServletUtil() {
    }

    public static void render(String path, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (!response.isCommitted()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(path);
                dispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
            System.out.println("ServletException ERROR: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException ERROR: " + e.getMessage());
        }
    }

    public static void renderAjax(JSONObject object, HttpServletResponse response, Exception ex) {
        try {
            response.setContentType("application/json;charset=iso-8859-1");
            response.setHeader("Cache-Control", "no-store");
            PrintWriter writer = response.getWriter();
            if (ex != null) {
                object.put("error", ex);
            }
            writer.print(object);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException ERROR: " + e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("JSONException ERROR: " + e.getMessage());
        }
    }

    public static void ajaxListar(JSONArray array, HttpServletResponse response, Exception ex) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            JSONObject object = new JSONObject();
            object.put("array", array);
            object.put("size", array.length());
            if (ex != null) {
                object.put("error", ex);
            }
            writer.print(object);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException ERROR: " + e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("JSONException ERROR: " + e.getMessage());
        }
    }
}

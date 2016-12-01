package com.learning.municipio;

import com.learning.connection.Conecta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;

/**
 *
 * @author lucas
 */
public class MunicipioDAO {

    public JSONArray ajaxMunicipios(int uf) throws SQLException {
        JSONArray array = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = Conecta.getInstance().prepareStatement("SELECT array_to_json(array_agg(t)) AS json FROM (SELECT id, municipio FROM tb_municipio WHERE id_uf = ?) t");
            statement.setInt(1, uf);
            rs = statement.executeQuery();
            if (rs.next()) {
                array = new JSONArray(rs.getString("json"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return array;
    }
    
    public JSONArray ajaxMunicipios() throws SQLException {
        JSONArray array = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = Conecta.getInstance().prepareStatement("SELECT array_to_json(array_agg(t)) AS json FROM (SELECT id, municipio FROM tb_municipio ORDER BY municipio ASC) t");
            rs = statement.executeQuery();
            while (rs.next()) {
                array = new JSONArray(rs.getString("json"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return array;
    }
}
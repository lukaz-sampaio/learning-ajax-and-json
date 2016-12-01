package com.learning.uf;

import com.learning.connection.Conecta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author lucas
 */
public class UfDAO {

    public JSONArray ajaxAsArray() throws SQLException {
        JSONArray array = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = Conecta.getInstance().prepareStatement("SELECT array_to_json(array_agg(t)) AS json FROM ( SELECT id, sigla AS text FROM tb_uf ORDER BY sigla ) t");
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

    public JSONObject ajaxAsObject() throws SQLException {
        JSONObject result = new JSONObject();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = Conecta.getInstance().prepareStatement("SELECT id, sigla FROM tb_uf");
            rs = statement.executeQuery();
            while (rs.next()) {
                result.put("id", rs.getInt("id"));
                result.put("descricao", rs.getString("sigla"));
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
        return result;
    }
}


/**

INSERT INTO tb_uf VALUES (11, 'RO');
INSERT INTO tb_uf VALUES (12, 'AC');
INSERT INTO tb_uf VALUES (13, 'AM');
INSERT INTO tb_uf VALUES (14, 'RR');
INSERT INTO tb_uf VALUES (15, 'PA');
INSERT INTO tb_uf VALUES (16, 'AP');
INSERT INTO tb_uf VALUES (17, 'TO');
INSERT INTO tb_uf VALUES (21, 'MA');
INSERT INTO tb_uf VALUES (22, 'PI');
INSERT INTO tb_uf VALUES (23, 'CE');
INSERT INTO tb_uf VALUES (24, 'RN');
INSERT INTO tb_uf VALUES (25, 'PB');
INSERT INTO tb_uf VALUES (26, 'PE');
INSERT INTO tb_uf VALUES (27, 'AL');
INSERT INTO tb_uf VALUES (28, 'SE');
INSERT INTO tb_uf VALUES (29, 'BA');
INSERT INTO tb_uf VALUES (31, 'MG');
INSERT INTO tb_uf VALUES (32, 'ES');
INSERT INTO tb_uf VALUES (33, 'RJ');
INSERT INTO tb_uf VALUES (35, 'SP');
INSERT INTO tb_uf VALUES (41, 'PR');
INSERT INTO tb_uf VALUES (42, 'SC');
INSERT INTO tb_uf VALUES (43, 'RS');
INSERT INTO tb_uf VALUES (50, 'MS');
INSERT INTO tb_uf VALUES (51, 'MT');
INSERT INTO tb_uf VALUES (52, 'GO');
INSERT INTO tb_uf VALUES (53, 'DF');

*/

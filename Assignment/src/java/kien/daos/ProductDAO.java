/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kien.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kien.dtos.ProductDTO;
import kien.utils.DBUtils;

/**
 *
 * @author HP
 */
public class ProductDAO {
    public List<ProductDTO> getListUser(String search) throws SQLException {
        List<ProductDTO> listTea = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT ProductID, Name, Quantity, Price "
                        + " FROM tblProducts "
                        + " WHERE name like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ProductID");
                    String name = rs.getString("Name");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    if (listTea == null) {
                        listTea = new ArrayList<>();
                    }
                    listTea.add(new ProductDTO(id, name, quantity, price));
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listTea;
    }
}

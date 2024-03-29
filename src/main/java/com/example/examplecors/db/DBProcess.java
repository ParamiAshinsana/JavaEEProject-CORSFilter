package com.example.examplecors.db;

import com.example.examplecors.dto.ItemDTO;
import lombok.var;

import java.sql.Connection;
import java.sql.SQLException;

public class DBProcess {
    private static final String SAVE_ITEM_DATA = "INSERT INTO ITEMS (itcode, itname, itprice, itqty) VALUES (?,?,?,?)";

    public void saveItemOne(ItemDTO items, Connection connection){
        try {
            var ps = connection.prepareStatement(SAVE_ITEM_DATA);
            ps.setString(1, items.getCode());
            ps.setString(2, items.getDescription());
            ps.setDouble(3, items.getUnitPrice());
            ps.setInt(4, items.getQty());

            if (ps.executeUpdate() != 0) {
                System.out.println("Data saved");
            } else {
                System.out.println("Failed to save");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.examplecors.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DBProcess {
    private static final String SAVE_ITEM_DATA = "INSERT INTO ITEMS (CODE,DESCRIPTION,QTY,PRICE) VALUES (?,?,?,?)";

    public void saveItemOne(ItemDTO items, Connection connection){
        try {
            var ps = connection.prepareStatement(SAVE_ITEM_DATA);
            ps.setString(1, customItemId);
            ps.setString(2, items.getDescription());
            ps.setInt(3, items.getQty());
            ps.setDouble(4, items.getUnitPrice());

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

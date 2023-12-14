package com.pluralsight.data;

import com.pluralsight.model.Shipper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public List<Shipper> allShippers() {
        List<Shipper> shippers = new ArrayList<>();

        String query = ("""
                SELECT *
                FROM Shippers""");

        try (Connection connection = DataConnect.getConnection();
             PreparedStatement prepared = connection.prepareStatement(query);
             ResultSet resultSet = prepared.executeQuery();) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ShipperID");
                String name= resultSet.getString("ShipperName");
                String phone = resultSet.getString("Phone");

                Shipper ship = new Shipper(id, name, phone);
                shippers.add(ship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shippers;
    }

}

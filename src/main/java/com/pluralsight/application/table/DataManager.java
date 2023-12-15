package com.pluralsight.application.table;

import com.pluralsight.application.table.connect.DataConnect;
import com.pluralsight.application.model.Shipper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    // Query All Shippers
    public List<Shipper> AllShippers() {
        List<Shipper> shippers = new ArrayList<>();

        String query = ("""
                SELECT *
                FROM shippers""");

        try (Connection connection = DataConnect.getConnection();
             PreparedStatement prepared = connection.prepareStatement(query);
             ResultSet resultSet = prepared.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ShipperID");
                String name = resultSet.getString("CompanyName");
                String phone = resultSet.getString("Phone");

                Shipper ship = new Shipper(id, name, phone);
                shippers.add(ship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shippers;
    }

    public void shipperInsert(String name, String phone) {
        String query = ("""
                INSERT INTO shippers
                    (CompanyName, Phone)
                VALUES
                    (?, ?)""");

        try (Connection connection = DataConnect.getConnection();
             PreparedStatement prepared = connection.prepareStatement(query)) {

            prepared.setString(1, name);
            prepared.setString(2, phone);
            int insert = prepared.executeUpdate();

            if (insert > 0) {
                System.out.println("\t\t\t---Shipper Successfully Added---\n");
                System.out.println("\nRedirecting...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePhoneNumber(int shipperID, String insertPhone) {
        String query = ("""
                UPDATE shippers
                    SET
                        Phone = ?
                WHERE
                    ShipperID = ?""");

        try (Connection connection = DataConnect.getConnection();
             PreparedStatement prepared = connection.prepareStatement(query)) {

            prepared.setString(1, insertPhone);
            prepared.setInt(2, shipperID);
            int insert = prepared.executeUpdate();

            if (insert > 0) {
                System.out.println("\t\t\t---Shipper's Phone Number Successfully Updated---\n");
                System.out.println("\nRedirecting...");
            } else {
                System.out.println("\t\t\t[~Error Searching By ID~]\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void shipperDelete(int shipperID) {
        String query = ("""
                DELETE
                FROM shippers
                WHERE
                    ShipperID = ?""");

        try (Connection connection = DataConnect.getConnection();
             PreparedStatement prepared = connection.prepareStatement(query)) {

            prepared.setInt(1, shipperID);
            int insert = prepared.executeUpdate();

            if (insert > 0) {
                System.out.println("\t\t\t---Shipper Successfully Removed---\n");
                System.out.println("\nRedirecting...");
            } else {
                System.out.println("\t\t\t[~Error Searching By ID~]\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

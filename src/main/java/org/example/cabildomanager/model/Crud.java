package org.example.cabildomanager.model;

import java.sql.*;

public class Crud {

  public static void main(String[] args) {
    DatabaseConnection dbConnection = new DatabaseConnection();
    try (Connection connection = DriverManager.getConnection(dbConnection.getURL(),
            dbConnection.getUSER(), dbConnection.getDbPassword())) {
      selectData(connection);


    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void selectData(Connection connection) throws SQLException {
    String sql = "SELECT * FROM Users";
    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {
      while (resultSet.next()) {
        System.out.println(resultSet.getString("first_name")
                + ": "+ resultSet.getString("last_name") );
      }
    }
  }


  private void addUser(){

  }
}

package org.example.cabildomanager.model;

import java.sql.*;

public class Crud {

  public static void main(String[] args) {
    System.out.println(DatabaseConfig.getDbUser());

    try (Connection conn = DatabaseConnection.getConnection()) {
      if (conn != null) {
        System.out.println("✅ Conexión exitosa a la base de datos!");
      }
    } catch (SQLException e) {
      System.err.println("❌ Error de conexión: " + e.getMessage());
    }
  }

}

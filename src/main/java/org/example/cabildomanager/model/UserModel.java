package org.example.cabildomanager.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author AlexSerpa
 */
public class UserModel {

  public boolean validateUser(String username, String password) {
    String sql =
        "SELECT * " +
        "FROM users " +
        "WHERE username = ? " +
        "AND password_hash = crypt(?, password_hash)";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

      statement.setString(1, username);
      statement.setString(2, password);

      ResultSet resultSet = statement.executeQuery();
      return resultSet.next();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}

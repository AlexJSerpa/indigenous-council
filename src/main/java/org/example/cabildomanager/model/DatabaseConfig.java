package org.example.cabildomanager.model;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConfig {
  private static final Dotenv dotenv = Dotenv.load();

  public static String getDbUrl() {
    return dotenv.get("DB_URL");
  }

  public static String getDbUser() {
    return dotenv.get("DB_USER");
  }

  public static String getDbPassword() {
    return dotenv.get("DB_PASSWORD");
  }
}

package org.example.cabildomanager.model;

public class DatabaseConnection {

    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Cabildo;" +
            "trustServerCertificate=true;";
    private final String USER = "sa";
    String dbPassword = System.getenv("DB_PASSWORD");
    private final String PASSWORD = dbPassword;

    public String getURL() {
        return URL;
    }

    public String getDbPassword() {
        return PASSWORD;
    }

    public String getUSER() {
        return USER;
    }
}

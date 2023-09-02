package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection conn = null;

    // make static
    public void connect() {
        try {
            String url = "jdbc:sqlite:C:/sqlite/DarkHeresyCharacterSheet/DarkHeresyCharacterSheet.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connected successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnect() {
            try {
                if (this.conn != null) {
                    this.conn.close();
                    System.out.println("Connection successfully closed");
                } else {
                    System.out.println("No connection to close");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

    }

}
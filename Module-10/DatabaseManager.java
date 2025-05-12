// Author: Amit Rizal
// Date: 05/11/2025
// Assignment: Module 10 - Fan Database Manager
// Purpose: This class handles database connections and operations.

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    public Fan getFanById(int id) {
        String query = "SELECT * FROM fans WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Fan(
                    rs.getInt("ID"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("favoriteteam")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateFan(Fan fan) {
        String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, fan.getFirstName());
            stmt.setString(2, fan.getLastName());
            stmt.setString(3, fan.getFavoriteTeam());
            stmt.setInt(4, fan.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

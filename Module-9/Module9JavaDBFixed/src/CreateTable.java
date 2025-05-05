import java.sql.*;

public class CreateTable {
    public CreateTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/databasedb?";
            Connection con = DriverManager.getConnection(url + "user=student1&password=pass");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("DROP TABLE IF EXISTS address33");
            stmt.executeUpdate("CREATE TABLE address33(ID int PRIMARY KEY, LASTNAME varchar(40), FIRSTNAME varchar(40), STREET varchar(40), CITY varchar(40), STATE varchar(40), ZIP varchar(40))");
            System.out.println("✅ Table created successfully");

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CreateTable();
    }
}

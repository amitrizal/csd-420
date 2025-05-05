import java.sql.*;

public class InsertData {
    public InsertData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/databasedb?";
            Connection con = DriverManager.getConnection(url + "user=student1&password=pass");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO address33 VALUES(1,'Fine','Ruth','1111 Redwing Circle','Bellevue','NE','68123')");
            stmt.executeUpdate("INSERT INTO address33 VALUES(2,'Howard','Curly','1000 Galvin Road South','Bellevue','NE','68005')");
            stmt.executeUpdate("INSERT INTO address33 VALUES(3,'Howard','Will','2919 Redwing Circle','Bellevue','NE','68123')");
            stmt.executeUpdate("INSERT INTO address33 VALUES(4,'Wilson','Larry','1121 Redwing Circle','Bellevue','NE','68124')");
            stmt.executeUpdate("INSERT INTO address33 VALUES(5,'Johnson','George','1300 Galvin Road South','Bellevue','NE','68006')");

            System.out.println("✅ Data inserted successfully");

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new InsertData();
    }
}

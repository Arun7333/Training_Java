package Day12;

import java.sql.*;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        //create object for JDBC class for doing operations
        JDBC jdbc = new JDBC("jdbc:mysql://localhost:3306/testing", "root", "Arun@7339");
        jdbc.connect();


        //Insert values into the student table
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            String name = scanner.next();
            String subject = scanner.next();
            int mark = scanner.nextInt();

            String insertQuery = "INSERT INTO students (name, subject, marks) VALUES ('" + name + "', '" + subject + "', " + mark + ");";

            if(jdbc.executeUpdate(insertQuery) > 0){
                System.out.println("inserted : " + i + 1);
            }
        }


        //Get values from the table using select
        String getQuery = "SELECT * from students";
        ResultSet resultSet = jdbc.executeQuery(getQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String subject = resultSet.getString("subject");
            int marks = resultSet.getInt("marks");

            System.out.printf("ID: %d, Name: %s, Subject: %s, Marks: %d%n", id, name, subject, marks);
        }
    }
}

class JDBC{
    private String url;
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;

    JDBC(String url, String username, String password){
        this.url = url;
        this.password = password;
        this.username = username;
        loadDriver();
    }

    private void loadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e){ e.printStackTrace(); }
    }

    public void connect(){
        if(connection == null){
            try {
                this.connection = DriverManager.getConnection(url, username, password);
                System.out.println("connected");
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public int executeUpdate(String sqlStatement) {
        int count = 0;
        try {
            Statement statement = connection.createStatement();
            count = statement.executeUpdate(sqlStatement);
            System.out.println("executed");
        }
        catch (Exception e) { e.printStackTrace(); }

        return count;
    }

    public ResultSet executeQuery(String sqlStatement){
        ResultSet set = null;
        try {
            Statement statement = connection.createStatement();
            set = statement.executeQuery(sqlStatement);
            System.out.println("executed");
        }
        catch (Exception e) { e.printStackTrace(); }

        return set;
    }


}

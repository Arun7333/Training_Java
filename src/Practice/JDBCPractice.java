package Practice;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JDBCPractice {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "Arun@7339";
        Server server = new Server(url, username, password);

        server.connectDB("testing");
        server.setConnection("testing");


        String query = "SELECT * from students";
        ResultSet set = server.executeQuery(query);

        server.closeAll();
    }
}

class Server{
    private String url;
    private String username;
    private String password;
    private Map<String, Connection> databases;
    private Connection currConn;
    private Pattern selectPattern = Pattern.compile("(?i)^\\s*select\\b");

    public Server(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
        databases = new HashMap<>();
    }

    public void connectDB(String dbName){
        if(!databases.containsKey(dbName)){
            try{
                Connection newConnection = DriverManager.getConnection(url + "/" + dbName, username, password);
                databases.put(dbName, newConnection);
                System.out.println(dbName + " is connected.");
            }
            catch (Exception e){ e.printStackTrace(); }
        }
    }

    public void setConnection(String dbName){
        if(databases.containsKey(dbName)){
            this.currConn = databases.get(dbName);
            System.out.println("current connection is set to " + dbName);
        }
        else{
            System.out.println("There is no DB called " + dbName + " is available!");
            System.out.println("First create the connection using connectDB and then set.");
        }
    }

    public void closeConnection(String dbName){
        if(databases.containsKey(dbName)){
            try {
                databases.get(dbName).close();
                databases.remove(dbName);
                System.out.println(dbName + " is closed.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int executeUpdate(String query){
        int count = 0;

        if(selectPattern.matcher(query).matches()){
            System.out.println("Error: use executeQuery for this query.");
        }
        else{
            try(Statement statement = currConn.createStatement()){
                count = statement.executeUpdate(query);

            }
            catch (Exception e){ e.printStackTrace(); }
        }

        return count;
    }

    public ResultSet executeQuery(String query){
        ResultSet resultSet = null;
        if(selectPattern.matcher(query).matches()){
            System.out.println("Error: use executeUpdate for this query.");
        }
        else{
            try(Statement statement = currConn.createStatement()){
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    System.out.println(id);
                }
            }
            catch (Exception e){ e.printStackTrace(); }
        }

        return resultSet;
    }

    public void closeAll(){
        try{
            Iterator<Map.Entry<String, Connection>> iterator = databases.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, Connection> entry = iterator.next();

                entry.getValue().close();
                iterator.remove();
            }

            System.out.println("All connections are closed.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

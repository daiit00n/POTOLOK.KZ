package Singleton;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private static Database instance;
    public static Database getInstance() {
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    String url = "jdbc:postgresql://localhost:5432/sdp";
    String user = "postgres";
    String password = "16112004";
    Statement s;
    public Connection c;
    public void connect(){

        try{
            c = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }
}

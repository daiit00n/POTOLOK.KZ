package Strategy.filter;

import Decorator.house.DefaultHouse;
import Decorator.house.DoghouseDecorator;
import Decorator.house.HouseMainInterface;
import Singleton.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HouseFilter implements IDatabaseFilter{
    @Override
    public void dbFilter(String query) {
        Database database = Database.getInstance();
        Connection c = database.c;
        Statement stmt;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM house where " + query);
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String address = rs.getString("address");
                boolean garden = rs.getBoolean("garden");
                boolean wifi = rs.getBoolean("wifi");
                boolean doghouse = rs.getBoolean("doghouse");
                boolean pool = rs.getBoolean("pool");
                float price = rs.getFloat("price");

                System.out.println("-----------------------------");
                System.out.print(id + ". ");
                System.out.println( "House at " + address );
                System.out.println("It has: ");
                if (garden){
                    System.out.println("garden");
                }if(wifi){
                    System.out.println("wifi");
                }if(doghouse){
                    System.out.println("doghouse");
                }if (pool) {
                    System.out.println("pool");
                }

                System.out.println("Price: " + price + "$");
                System.out.println("-----------------------------");
            }
            rs.close();
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}

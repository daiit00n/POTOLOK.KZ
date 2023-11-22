package Strategy.dbDisplay;

import Singleton.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ApartmentIDatabaseDisplay implements IDatabaseDisplay {
    @Override
    public void dbDisplay() {
        Database database = Database.getInstance();
        Connection c = database.c;
        Statement stmt;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM apartments;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String address = rs.getString("address");
                boolean wifi = rs.getBoolean("wifi");
                boolean furniture = rs.getBoolean("furniture");
                boolean parking = rs.getBoolean("parking");
                float price = rs.getFloat("price");

                System.out.println("-----------------------------");
                System.out.print(id + ". ");
                System.out.println( "Apartment at " + address );
                System.out.println("It has: ");
                if(wifi){
                    System.out.println("wifi");
                }if(furniture){
                    System.out.println("furniture");}
                if (parking){
                    System.out.println("parking");
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

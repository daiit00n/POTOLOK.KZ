package Strategy.rent;

import Decorator.apartment.*;
import Singleton.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DayRenting implements RentingPeriodInterface{
    @Override
    public void renting(int howMany, int idApartment) {
        ApartmentMainInterface apartmentMainInterface = new DefaultApartment();
        Database database = Database.getInstance();
        Connection c = database.c;
        Statement stmt;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM apartments where id = " + idApartment);
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String address = rs.getString("address");
                boolean wifi = rs.getBoolean("wifi");
                boolean furniture = rs.getBoolean("furniture");
                boolean parking = rs.getBoolean("parking");

                System.out.println(howMany + " days");
                System.out.print(id + ". ");
                System.out.println( "Apartment at " + address );
                System.out.print("It is ");
                if(wifi){
                    apartmentMainInterface = new ApartmentWifiDecorator(apartmentMainInterface);
                }if(furniture){
                    apartmentMainInterface = new FurnitureDecorator(apartmentMainInterface);
                }
                if (parking){
                    apartmentMainInterface = new ParkingDecorator(apartmentMainInterface);
                }
                System.out.println(apartmentMainInterface.getDescription());
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

package Strategy.buy;

import Decorator.house.*;
import Singleton.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HouseBuy implements BuildingBuyInterface{
    @Override
    public void buy(int idHouse) {
        HouseMainInterface houseMainInterface = new DefaultHouse();
        Database database = Database.getInstance();
        Connection c = database.c;
        Statement stmt;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM house where id = " + idHouse);
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String address = rs.getString("address");
                boolean garden = rs.getBoolean("garden");
                boolean wifi = rs.getBoolean("wifi");
                boolean doghouse = rs.getBoolean("doghouse");
                boolean pool = rs.getBoolean("pool");

                System.out.println("-----------------------------");
                System.out.print(id + ". ");
                System.out.println( "House at " + address );
                System.out.print("It is ");
                if (garden){
                    houseMainInterface = new GardenDecorator(houseMainInterface);
                }if(wifi){
                    houseMainInterface = new HouseWifiDecorator(houseMainInterface);
                }if(doghouse){
                    houseMainInterface = new DoghouseDecorator(houseMainInterface);
                }if (pool) {
                    houseMainInterface = new PoolDecorator(houseMainInterface);
                }
                System.out.println(houseMainInterface.getDescription());

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

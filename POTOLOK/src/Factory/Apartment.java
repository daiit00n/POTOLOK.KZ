package Factory;

import Singleton.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Apartment implements Building{
    int id;
    String address;
    boolean wifi;
    boolean furniture;
    boolean parking;
    float price;

    public Apartment(int id, String address, boolean wifi, boolean furniture, boolean parking, float price){
        this.id = id;
        this.address = address;
        this.wifi = wifi;
        this.furniture = furniture;
        this.parking = parking;
        this.price = price;
    }

    @Override
    public void addDecorator() {
        Database database = Database.getInstance();
        Connection c = database.c;
            try {
                PreparedStatement pr = c.prepareStatement( "insert into apartments(id, address, wifi, furniture, parking, price) values (?, ?, ?, ?, ?, ?)");
                pr.setInt(1, id);
                pr.setString(2, address);
                pr.setBoolean(3, wifi);
                pr.setBoolean(4, furniture);
                pr.setBoolean(5, parking);
                pr.setFloat(6, price);
                pr.executeUpdate();
                System.out.println("New apartment has added successfully!");
                pr.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
        }
    }

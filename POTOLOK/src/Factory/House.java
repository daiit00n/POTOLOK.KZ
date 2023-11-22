package Factory;

import Decorator.house.*;
import Singleton.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class House implements Building{
    int id;
    String address;
    boolean garden;
    boolean wifi;
    boolean doghouse;
    boolean pool;
    float price;

    public House(int id, String address, boolean garden, boolean wifi, boolean doghouse, boolean pool, float price){
        this.id = id;
        this.address = address;
        this.garden = garden;
        this.wifi = wifi;
        this.doghouse = doghouse;
        this.pool = pool;
        this.price = price;
    }

    @Override
    public void addDecorator() {
        Database database = Database.getInstance();
        Connection c = database.c;

        try {
            PreparedStatement pr = c.prepareStatement( "insert into house(id, address, garden, wifi, doghouse, pool, price) values (?, ?, ?, ?, ?, ?, ?)");
            pr.setInt(1, id);
            pr.setString(2, address);
            pr.setBoolean(3, garden);
            pr.setBoolean(4, wifi);
            pr.setBoolean(5, doghouse);
            pr.setBoolean(6, pool);
            pr.setFloat(7, price);
            pr.executeUpdate();
            System.out.println("New house has added successfully!");
            pr.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}

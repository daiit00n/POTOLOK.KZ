package Factory;

public class HouseFactory implements BuildingFactory {
    int id;
    String address;
    boolean garden;
    boolean wifi;
    boolean doghouse;
    boolean pool;
    float price;

    public HouseFactory(int id, String address, boolean garden, boolean wifi, boolean doghouse, boolean pool, float price){
        this.id = id;
        this.address = address;
        this.garden = garden;
        this.wifi = wifi;
        this.doghouse = doghouse;
        this.pool = pool;
        this.price = price;
    }
    @Override
    public Building addBuilding() {
        return new House(id, address, garden, wifi, doghouse, pool, price);
    }
}

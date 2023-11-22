package Factory;

public class ApartmentFactory implements BuildingFactory {
    int id;
    String address;
    boolean wifi;
    boolean furniture;
    boolean parking;
    float price;

    public ApartmentFactory(int id, String address, boolean wifi, boolean furniture, boolean parking, float price){
        this.id = id;
        this.address = address;
        this.wifi = wifi;
        this.furniture = furniture;
        this.parking = parking;
        this.price = price;
    }
    @Override
    public Building addBuilding() {
        return new Apartment(id, address, wifi, furniture, parking, price);
    }
}

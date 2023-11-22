package Strategy.rent;

public class RentingPeriod {
    RentingPeriodInterface rentingPeriodInterface;
    int howMany;
    int id;
    public void setRentingPeriodInterface(RentingPeriodInterface rentingPeriodInterface, int howMany, int id) {
        this.rentingPeriodInterface = rentingPeriodInterface;
        this.howMany = howMany;
        this.id = id;
    }

    public void executeRenting(){
        rentingPeriodInterface.renting(howMany, id);
    }
}

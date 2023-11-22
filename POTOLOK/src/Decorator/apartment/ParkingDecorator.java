package Decorator.apartment;

import Decorator.house.HouseDecorator;
import Decorator.house.HouseMainInterface;

public class ParkingDecorator extends ApartmentDecorator {
    public ParkingDecorator(ApartmentMainInterface apartmentMainInterface) {
        super(apartmentMainInterface);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with parking";
    }

    @Override
    public String getFilterQuery() {
        if(super.getFilterQuery().equals("")){
            return super.getFilterQuery() + "parking = true";
        }
        else {
            return super.getFilterQuery() + " and parking = true";
        }
    }
}

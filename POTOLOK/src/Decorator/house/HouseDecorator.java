package Decorator.house;

public class HouseDecorator implements HouseMainInterface{
    HouseMainInterface houseMainInterface;

    public HouseDecorator(HouseMainInterface houseMainInterface){
        this.houseMainInterface = houseMainInterface;
    }
    @Override
    public String getDescription() {
        return houseMainInterface.getDescription();
    }

    @Override
    public String getFilterQuery() {
        return houseMainInterface.getFilterQuery();
    }

}

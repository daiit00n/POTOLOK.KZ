package Decorator.house;

public class GardenDecorator extends HouseDecorator{
    public GardenDecorator(HouseMainInterface houseMainInterface) {
        super(houseMainInterface);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with garden";
    }

    @Override
    public String getFilterQuery() {
        if(super.getFilterQuery().equals("")){
            return super.getFilterQuery() + "garden = true";
        }
        else {
            return super.getFilterQuery() + " and garden = true";
        }
    }
}

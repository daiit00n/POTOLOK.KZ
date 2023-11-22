package Decorator.house;

public class HouseWifiDecorator extends HouseDecorator{
    public HouseWifiDecorator(HouseMainInterface houseMainInterface) {
        super(houseMainInterface);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with wi-fi";
    }

    @Override
    public String getFilterQuery() {
        if(super.getFilterQuery().equals("")){
            return super.getFilterQuery() + "wifi = true";
        }
        else {
            return super.getFilterQuery() + " and wifi = true";
        }
    }
}

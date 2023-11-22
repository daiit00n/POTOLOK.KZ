package Decorator.house;

public class DoghouseDecorator extends HouseDecorator{

    public DoghouseDecorator(HouseMainInterface houseMainInterface) {
        super(houseMainInterface);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with doghouse";
    }

    @Override
    public String getFilterQuery() {
        if(super.getFilterQuery().equals("")){
            return super.getFilterQuery() + "doghouse = true";
        }
        else {
            return super.getFilterQuery() + " and doghouse = true";
        }
    }
}

package Decorator.house;

public class PoolDecorator extends HouseDecorator{
    public PoolDecorator(HouseMainInterface houseMainInterface) {
        super(houseMainInterface);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with pool";
    }

    @Override
    public String getFilterQuery() {
        if(super.getFilterQuery().equals("")){
            return super.getFilterQuery() + "pool = true";
        }
        else {
            return super.getFilterQuery() + " and pool = true";
        }
    }
}

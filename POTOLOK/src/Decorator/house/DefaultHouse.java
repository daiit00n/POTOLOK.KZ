package Decorator.house;

public class DefaultHouse implements HouseMainInterface {
    @Override
    public String getDescription() {
        return "house";
    }

    @Override
    public String getFilterQuery() {
        return "";
    }
}

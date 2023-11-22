package Decorator.apartment;

public class DefaultApartment implements ApartmentMainInterface{

    @Override
    public String getDescription() {
        return "apartment";
    }

    @Override
    public String getFilterQuery() {
        return "";
    }
}

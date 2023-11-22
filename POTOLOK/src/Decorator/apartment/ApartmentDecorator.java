package Decorator.apartment;

public class ApartmentDecorator implements ApartmentMainInterface{
    ApartmentMainInterface apartmentMainInterface;

    public ApartmentDecorator(ApartmentMainInterface apartmentMainInterface){
        this.apartmentMainInterface = apartmentMainInterface;
    }
    @Override
    public String getDescription() {
        return apartmentMainInterface.getDescription();
    }

    @Override
    public String getFilterQuery() {
        return apartmentMainInterface.getFilterQuery();
    }
}

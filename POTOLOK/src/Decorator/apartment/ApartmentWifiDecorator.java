package Decorator.apartment;

public class ApartmentWifiDecorator extends ApartmentDecorator {
    public ApartmentWifiDecorator(ApartmentMainInterface apartmentMainInterface) {
        super(apartmentMainInterface);
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

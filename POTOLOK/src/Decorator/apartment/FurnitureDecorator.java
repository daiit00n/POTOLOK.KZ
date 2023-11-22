package Decorator.apartment;

public class FurnitureDecorator extends ApartmentDecorator {
    public FurnitureDecorator(ApartmentMainInterface apartmentMainInterface) {
        super(apartmentMainInterface);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with furniture";
    }

    @Override
    public String getFilterQuery() {
        if(super.getFilterQuery().equals("")){
            return super.getFilterQuery() + "furniture = true";
        }
        else {
            return super.getFilterQuery() + " and furniture = true";
        }
    }
}

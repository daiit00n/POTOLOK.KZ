package Adapter;

import Strategy.dbDisplay.IDatabaseDisplay;

public class AdapterDollarToTenge implements IDatabaseDisplay {
    DisplayHouseInTenge displayHouseInTenge;
    DisplayApartmentInTenge displayApartmentInTenge;

    public AdapterDollarToTenge(DisplayHouseInTenge displayHouseInTenge){
        this.displayHouseInTenge = displayHouseInTenge;
    }

    public AdapterDollarToTenge(DisplayApartmentInTenge displayApartmentInTenge){
        this.displayApartmentInTenge = displayApartmentInTenge;
    }

    @Override
    public void dbDisplay() {
        if(displayHouseInTenge == null){
            displayApartmentInTenge.dbDisplayinTenge();
        }else {
            displayHouseInTenge.dbDisplayInTenge();
        }
    }
}

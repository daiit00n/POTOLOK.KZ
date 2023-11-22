package Strategy.filter;

import Decorator.apartment.ApartmentMainInterface;
import Decorator.house.HouseMainInterface;

public class DatabaseFilter {
    IDatabaseFilter iDatabaseFilter;
    String query;

    public void setiDatabaseFilter(IDatabaseFilter iDatabaseFilter, String query) {
        this.iDatabaseFilter = iDatabaseFilter;
        this.query = query;
    }


    public void executeFilter(){
        iDatabaseFilter.dbFilter(query);
    }
}

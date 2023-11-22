package Strategy.dbDisplay;

public class DisplayDatabase {
    IDatabaseDisplay databaseDisplay;

    public void setDatabaseDisplay(IDatabaseDisplay databaseDisplay) {
        this.databaseDisplay = databaseDisplay;
    }

    public void executeDisplay(){
        databaseDisplay.dbDisplay();
    }

}

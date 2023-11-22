package Strategy.buy;

public class BuildingBuy {
    BuildingBuyInterface buildingBuyInterface;
    int id;

    public void setBuildingBuyInterface(BuildingBuyInterface buildingBuyInterface, int id) {
        this.buildingBuyInterface = buildingBuyInterface;
        this.id = id;
    }

    public void executeBuy(){buildingBuyInterface.buy(id);}
}


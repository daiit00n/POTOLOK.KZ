package Singleton;

import Adapter.AdapterDollarToTenge;
import Adapter.DisplayApartmentInTenge;
import Adapter.DisplayHouseInTenge;
import Decorator.apartment.*;
import Decorator.house.*;
import Factory.ApartmentFactory;
import Factory.Building;
import Factory.BuildingFactory;
import Factory.HouseFactory;
import Strategy.buy.ApartmentBuy;
import Strategy.buy.BuildingBuy;
import Strategy.buy.HouseBuy;
import Strategy.dbDisplay.ApartmentIDatabaseDisplay;
import Strategy.dbDisplay.DisplayDatabase;
import Strategy.dbDisplay.HouseIDatabaseDisplay;
import Strategy.filter.ApartmentFilter;
import Strategy.filter.DatabaseFilter;
import Strategy.filter.HouseFilter;
import Strategy.rent.DayRenting;
import Strategy.rent.HourRenting;
import Strategy.rent.MonthRenting;
import Strategy.rent.RentingPeriod;

import java.util.Scanner;

public class Menu {
    private static Menu instance;

    public static Menu getInstance() {
        if (instance == null){
            instance = new Menu();
        }
        return instance;
    }

    Database database = Database.getInstance();
    Scanner s = new Scanner(System.in);
    private int command;
    public void start(){
        database.connect();
        System.out.println("Welcome to POTOLOK.KZ!");
        System.out.println("-----------------------------");
        System.out.println("1. Client account. 2. Admin account. 3.Exit.");
        System.out.print("Select account: ");
        command = s.nextInt();
        if(command == 1){
            menu();
        }else if(command == 2){
            menuDeveloper();
        } else if (command == 3) {
            return;
        } else {
            System.out.println("Wrong command, try again."); start();
        }

    }
    private void menu(){
        System.out.println("-----------------------------");
        System.out.println("Select command:");
        System.out.println("1. Display all buildings. 2. Filter. 3. Buy. 4. Rent. 5.Back to the start.");
        System.out.print("Write your command: ");
        command = s.nextInt();

        switch (command){
            case 1: display(); break;
            case 2: filter(); break;
            case 3: buy(); break;
            case 4: rent(); break;
            case 5: start(); break;
            default:
                System.out.println("Wrong command, try again."); start(); break;
        }
    }

    private void menuDeveloper(){
        int id;
        String address;
        boolean garden, wifi, doghouse, pool;
        boolean furniture, parking;
        float price;

        System.out.println("Welcome boss! \nWhich type of building are you want to add?\n" +
                "1. House | 2. Apartment | 3. Back to the start");
        System.out.println("Choose the option: ");
        command = s.nextInt();

        switch (command){
            case 1:
                System.out.print("Write house's id: ");
                id = s.nextInt();
                System.out.println("Write address: ");
                s.nextLine();
                address = s.nextLine();
                System.out.print("Is it has garden?: ");
                garden = s.nextBoolean();
                System.out.print("Is it has wifi?: ");
                wifi = s.nextBoolean();
                System.out.print("Is it has doghouse?: ");
                doghouse = s.nextBoolean();
                System.out.print("Is it has pool?: ");
                pool = s.nextBoolean();
                System.out.print("Write price: ");
                price = s.nextFloat();
                System.out.println(address);
                BuildingFactory buildingFactory = new HouseFactory(id, address, garden, wifi, doghouse, pool, price);
                Building building = buildingFactory.addBuilding();
                building.addDecorator();
                menuDeveloper();
                break;
            case 2:
                System.out.print("Write apartment's id: ");
                id = s.nextInt();
                System.out.println("Write address: ");
                s.nextLine();
                address = s.nextLine();
                System.out.print("Is it has wifi?: ");
                wifi = s.nextBoolean();
                System.out.print("Is it has furniture?: ");
                furniture = s.nextBoolean();
                System.out.print("Is it has parking?: ");
                parking = s.nextBoolean();
                System.out.print("Write price: ");
                price = s.nextFloat();

                buildingFactory = new ApartmentFactory(id, address, wifi, furniture, parking, price);
                building = buildingFactory.addBuilding();
                building.addDecorator();
                menuDeveloper();
                break;
            case 3: start(); break;
            default: System.out.println("Wrong command, try again."); menuDeveloper(); break;
        }
    }

    private int buildingType(int type){
        System.out.println("-----------------------------");

        if (type == 1){
            System.out.println("What kind of building do you want?");
        }else if(type == 2){
            System.out.println("What kind of building do you want to filter?");
        } else if (type == 3) {
            System.out.println("What kind of building do you want to buy?");
        }

        System.out.println("1. House. 2. Apartments.");
        System.out.print("Choose building type: ");
        command = s.nextInt();

        if(command != 1 && command != 2){
            System.out.println("Wrong command, try again."); buildingType(type);
        }

        return command;
    }

    private void display(){
        DisplayDatabase displayDatabase = new DisplayDatabase();
        int building = buildingType(1);
        switch (building){
            case 1: displayDatabase.setDatabaseDisplay(new HouseIDatabaseDisplay()); displayDatabase.executeDisplay(); break;
            case 2: displayDatabase.setDatabaseDisplay(new ApartmentIDatabaseDisplay()); displayDatabase.executeDisplay(); break;
            default:
                System.out.println("Wrong command, try again."); display(); break;
        }

        System.out.println("Display in tenge?");
        System.out.print("1. Yes. 2. No. Select: ");
        command = s.nextInt();
        if(command == 1){
            AdapterDollarToTenge adapterDollarToTenge;
            adapterDollarToTenge = adapter(building);
            adapterDollarToTenge.dbDisplay();
            menu();
        }else {
            menu();
        }
    }

    private AdapterDollarToTenge adapter(int command){
        switch (command){
            case 1: return new AdapterDollarToTenge(new DisplayHouseInTenge());
            case 2: return new AdapterDollarToTenge(new DisplayApartmentInTenge());
            default: return null;
        }
    }

    HouseMainInterface houseMainInterface = new DefaultHouse();
    ApartmentMainInterface apartmentMainInterface = new DefaultApartment();
    private void filter(){
        DatabaseFilter databaseFilter = new DatabaseFilter();

        switch (buildingType(2)){
            case 1:
                decorator(1);
                databaseFilter.setiDatabaseFilter(new HouseFilter(), houseMainInterface.getFilterQuery());
                databaseFilter.executeFilter();
                menu();
                break;
            case 2:
                decorator(2);
                databaseFilter.setiDatabaseFilter(new ApartmentFilter(), apartmentMainInterface.getFilterQuery());
                databaseFilter.executeFilter();
                menu();
                break;
            default:
                System.out.println("Wrong command, try again."); filter(); break;
        }
    }

    private void decorator(int type){

        System.out.println("-----------------------------");
        System.out.println("There are filter settings that you can add below: ");

        if(type == 1){
            System.out.println("1. Garden. 2. Wifi. 3. Doghouse. 4. Pool. 5. Nothing to add more.");
            System.out.print("Add filter: ");
            command = s.nextInt();
            switch (command){
                case 1: houseMainInterface = new GardenDecorator(houseMainInterface); decorator(1); break;
                case 2: houseMainInterface = new HouseWifiDecorator(houseMainInterface); decorator(1); break;
                case 3: houseMainInterface = new DoghouseDecorator(houseMainInterface); decorator(1); break;
                case 4: houseMainInterface = new PoolDecorator(houseMainInterface); decorator(1); break;
                case 5: break;
                default: System.out.println("Wrong command, try again."); decorator(1); break;
            }
        } else if (type == 2) {
            System.out.println("1. Wi-Fi. 2. Furniture. 3. Parking. 4. Nothing to add more.");
            System.out.print("Add filter: ");
            command = s.nextInt();
            switch (command){
                case 1: apartmentMainInterface = new ApartmentWifiDecorator(apartmentMainInterface); decorator(2); break;
                case 2: apartmentMainInterface = new FurnitureDecorator(apartmentMainInterface); decorator(2); break;
                case 3: apartmentMainInterface = new ParkingDecorator(apartmentMainInterface); decorator(2); break;
                case 4: break;
                default: System.out.println("Wrong command, try again."); decorator(2); break;
            }
        }
    }

    int id;
    private void buy(){
        BuildingBuy buildingBuy = new BuildingBuy();


        switch (buildingType(3)){
            case 1:
                System.out.println("-----------------------------");
                System.out.print("Write house's id that you want to buy: ");
                id = s.nextInt();
                System.out.println("Congratulations! You bought: ");
                buildingBuy.setBuildingBuyInterface(new HouseBuy(), id);
                buildingBuy.executeBuy();
                break;
            case 2:
                System.out.println("-----------------------------");
                System.out.print("Write apartments's id that you want to buy: ");
                id = s.nextInt();
                System.out.println("Congratulations! You bought: ");
                buildingBuy.setBuildingBuyInterface(new ApartmentBuy(), id);
                buildingBuy.executeBuy();
                break;
            default: System.out.println("Wrong command, try again."); buy(); break;
        }
    }

    private void rent(){
        RentingPeriod rentingPeriod = new RentingPeriod();

        System.out.println("-----------------------------");
        System.out.println("You can rent only apartments!");
        System.out.print("Write apartment's id: ");
        id = s.nextInt();
        System.out.println("For what period?");
        System.out.print("1. Hours. 2. Days. 3.Months. Choose: ");
        command = s.nextInt();
        System.out.print("How many time of it?: ");
        int howMany = s.nextInt();

        System.out.println("\n-----------------------------");
        System.out.print("You rented apartment for ");
        switch (command){
            case 1: rentingPeriod.setRentingPeriodInterface(new HourRenting(), howMany, id); rentingPeriod.executeRenting(); break;
            case 2: rentingPeriod.setRentingPeriodInterface(new DayRenting(), howMany, id); rentingPeriod.executeRenting(); break;
            case 3: rentingPeriod.setRentingPeriodInterface(new MonthRenting(), howMany, id); rentingPeriod.executeRenting(); break;
            default: System.out.println("Wrong command, try again."); rent(); break;
        }
    }
}

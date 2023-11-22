# POTOLOK.KZ
 
Project Overview:

    About project: The project facilitates the sale and rental of houses and apartments through a Java application connected to a PostgreSQL database using pgAdmin4.

Developer: This section allows the creation of buildings that are stored in two distinct tables within the database—houses and apartments. Each table contains specific attributes tailored to the type of property. For houses, attributes include price, ID, garden, wifi, pool, and doghouse. Meanwhile, apartments comprise price, ID, wifi, parking, and furniture attributes.

Customer: This section presents options to buy or rent houses/apartments for hours, days and months. And filter the available properties based on various attributes to find the most suitable ones.

Design Patterns Used:

    Factory Pattern:
        Implemented Building and BuildingFactory interfaces.
        Created House and Apartment classes implementing the Building interface.
        Developed HouseFactory and ApartmentFactory to create respective building instances.

    Strategy Pattern:
        Utilized for different purchase and filtering strategies (BuyHouse, BuyApartment, RentHouse, RentApartment, FilterByAttributes and DisplayDataBase).

    Adapter Pattern:
        Applied for currency conversion (USD to KZT) using the Dollar, Tenge, Adapter classes and PriceDisplay interface.

    Decorator Pattern:
        Used to furnish house or apartment with decors like for house is : pool, garden, doghouse, wifi and for apartment is : wifi, furniture, parking.

    Singleton Pattern:
        Implemented a Singleton pattern for the database connection to ensure a single instance and manage connections effectively.
        Potentially used for the menu class to maintain a single instance throughout the application's lifecycle.

Components and Classes:

Developer Side:
    Menu Class: Provides options for developers and customers.
    House and Apartment Classes: Represent properties with specific attributes and functionalities.
    BuildingFactory: Generates instances of houses or apartments based on user input.
    Database Connection (Singleton): Handles connection with the PostgreSQL database (pgAdmin4).
    Currency Adapter: Converts USD prices to KZT.

Customer Side:
    Menu Class: Displays options for customers (buy, rent, filter).
    Buy/Rent Strategies: Strategies for buying or renting houses/apartments.
    Filter Strategy: Allows customers to search for suitable properties based on attributes.

Project Objectives and Purpose:
   The primary goal is to create a robust housing system enabling developers to add properties to the database and customers to interactively browse and choose houses/apartments based on various criteria.
   Enhance user experience by providing functionalities such as currency conversion, dynamic property augmentation, and efficient database connectivity.

Project Outcomes and Challenges:
   Successfully implemented multiple design patterns to create a modular and scalable system.
   Challenges may have included database integration complexities, ensuring seamless user interactions, and maintaining code modularity.

Future Improvements:
   Implement user notifications using the Observer pattern for real-time updates or notifications.
   Enhance search/filter functionalities for more precise property selection. 
   Expand the range of supported currencies for price conversion.
   Improve the user interface for a more intuitive experience.

Overall, the project aims to offer a comprehensive housing solution with flexible functionalities and a strong emphasis on design patterns to ensure modularity, extensibility, and maintainability.

# README.md

**Project Title:** Hotel-Booking-Occupancy-Manager

**Team No:** KLH/PSPJAVA/S14/T18

**Team Member Names with ID Numbers:**

1. 2620030689 - A.Srijan
2. 2620090081 - P.Venkata Sudheer

**Supervisor's Name:** Dr. Madhavi Karumudi

**Abstract:** The Hotel Booking Occupancy Manager is a console-based Java application that automates the process of booking a hotel room and generating the customer's bill. The system collects guest details such as name, Aadhar number and the number of days they wish to stay, and validates each input before proceeding. Guests can then choose from four room categories - Basic, Luxury, Delux and Platinum - each with a fixed per-day tariff stored in arrays. Rooms are modelled using classes and objects: a `Room` parent class holds the room type and price, while a `LuxuryRoom` child class inherits from it and overrides the billing method to apply an automatic 10% discount. The program calculates the total bill based on the chosen room type and duration of stay and prints a complete booking summary. Invalid or non-numeric input is handled gracefully using exception handling. This project was built using core Java concepts - data types, operators, Scanner input, conditional statements, loops, methods, method overloading, arrays, classes, constructors, inheritance, method overriding, Strings and exception handling - without relying on any external libraries.

**Project Structure:**
```
Hotel-Booking-Occupancy-Manager (under this folder)
|— README.md
|— src
    └── HotelBookingManagerSystem.java
|— docs
|— data
|— results
|— reports
```

**Execution Instructions:**
```
> javac HotelBookingManagerSystem.java
> java HotelBookingManagerSystem
```

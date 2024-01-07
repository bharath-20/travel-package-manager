package com.travelplanner.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildData {

    public List<TravelPackage> buildDummyData(){
        List<TravelPackage> travelPackageList = new ArrayList<>();
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 4);
        Activity activity2 = new Activity("Scuba Diving", "Underwater adventure", 120.0, 8);
        Activity activity3 = new Activity("Kayaking", "Water boating", 60.0, 8);
        Activity activity4 = new Activity("Surfing", "Surfing", 50.0, 10);
        Activity activity5 = new Activity("Safari", "Boat Safari", 60.0, 8);

        // Creating destinations and adding activities
        Destination destination1 = new Destination("Mountain Retreat");
        destination1.addActivity(activity1);

        Destination destination2 = new Destination("Beach Resort");
        destination2.addActivity(activity2);
        destination2.addActivity(activity3);

        Destination destination3= new Destination("Goa Beach");
        destination3.addActivity(activity4);
        destination3.addActivity(activity5);


        // Creating a travel package with destinations with preexisting itinerary
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination1);
        itinerary.add(destination2);

        TravelPackage travelPackage1 = new TravelPackage("Nature Escape", 20, itinerary);
        travelPackageList.add(travelPackage1);

        // Creating a travel package with destinations with preexisting itinerary
        TravelPackage travelPackage2 = new TravelPackage("Live behind city",100,null);
        travelPackageList.add(travelPackage2);

        travelPackage2.addDestinationToItinerary(destination3);
        travelPackage2.addDestinationToItinerary(destination2);


        // Creating passengers
        Passenger passenger1 = new Passenger("Raj","9000000001", "standard", 1000.0);
        Passenger passenger2 = new Passenger("Virat", "9000000002", "gold", 300.0);
        Passenger passenger3 = new Passenger("Rohit", "9000000003", "premium", 200.0);
        Passenger passenger4 = new Passenger("Sachin", "9000000004", "gold", 350.0);
        Passenger passenger5 = new Passenger("Smriti", "9000000005", "standard", 200.0);
        Passenger passenger6 = new Passenger("Harman", "9000000006", "premium", 300.0);
        Passenger passenger7 = new Passenger("Lara", "9000000007", "standard", 140.0);
        Passenger passenger8 = new Passenger("Ricky", "9000000008", "gold", 300.0);
        Passenger passenger9 = new Passenger("Bharath", "9000000009", "gold", 1560.0);
        Passenger passenger10 = new Passenger("Vicky", "9000000010", "premium", 700.0);

        // Signing up passengers for activities
        //Passenger1 Signed to all activites


        passenger1.signUpForActivity(activity1,travelPackage1);
        passenger1.signUpForActivity(activity2,travelPackage1);
        passenger1.signUpForActivity(activity3,travelPackage1);
        passenger1.signUpForActivity(activity4,travelPackage2);
        passenger1.signUpForActivity(activity5,travelPackage2);
        passenger2.signUpForActivity(activity1,travelPackage1);
        passenger3.signUpForActivity(activity1,travelPackage1);
        passenger4.signUpForActivity(activity2,travelPackage1);
        passenger5.signUpForActivity(activity4,travelPackage2);
        passenger6.signUpForActivity(activity3,travelPackage1);
        passenger7.signUpForActivity(activity3,travelPackage2);
        passenger8.signUpForActivity(activity5,travelPackage2);
        passenger9.signUpForActivity(activity1,travelPackage1);
        passenger10.signUpForActivity(activity3,travelPackage2);


        return travelPackageList;
    }

    public Activity buildActivity(Destination destination){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Activity details below.");
        System.out.println("Activity name : ");
        String name = scanner.next();
        System.out.println("Activity Description : ");
        String description = scanner.next();
        System.out.println("Cost of Activity : ");
        double cost = scanner.nextDouble();
        System.out.println("Capacity of Activity : ");
        int capacity = scanner.nextInt();
        System.out.println();

        Activity acitivity = new Activity(name, description, cost, capacity);
        destination.addActivity(acitivity);
        return acitivity;
    }
    public Destination buildDestination(TravelPackage travelPackage){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Destination Name: ");
        String name = scanner.next();
        Destination destination = new Destination(name);
        travelPackage.addDestinationToItinerary(destination);
        return destination;
    }

    public void buildPassenger(Activity activity, TravelPackage travelPackage ){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Passenger details below.");
        System.out.println("Passenger name : ");
        String name = scanner.next();
        System.out.println("Passenger Phone Number : ");
        String passangerNumber = scanner.next();
        System.out.println("Passenger Type(Choose 1.Standard\t 2.Gold\t 3.Premium) : ");
        int val = scanner.nextInt();
        String passengerType = null;
        if(val == 1)passengerType="standard";
        else if (val == 2) {passengerType="gold";}
        else if (val == 3) {passengerType="premium";}
        else System.out.println("\nEnter Valid Type: ");
        System.out.println("Passenger Balance : ");
        double balance = scanner.nextDouble();
        System.out.println();

        Passenger passenger = new Passenger(name, passangerNumber, passengerType, balance);
        passenger.signUpForActivity(activity,travelPackage);
        System.out.println("Passenger Signed Up successfully.");
    }

    public TravelPackage buildTravelPackage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Travel Package Name: ");
        String name = scanner.next();
        System.out.println("Enter Travel Package Capacity: ");
        int capacity = scanner.nextInt();
        return new TravelPackage(name,capacity,null);
    }
    public void printChoices(){
        System.out.println("Enter your choice:");
        System.out.println("0 - Exit");
        System.out.println("1 - Print Available Activities");
        System.out.println("2 - Print DestinationItinerary");
        System.out.println("3 - Print Passenger List and Activities Enrolled");
        System.out.println("4 - Print Passenger Details");
        System.out.println("5 - Print Passenger List of Travel Package");
        System.out.println("6 - Test for a New Passenger(Travel Package-> Destination-> Activity-> Passenger->SignUp Activity)\n");

    }
}

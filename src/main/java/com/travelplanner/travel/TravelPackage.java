package com.travelplanner.travel;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private final List<Destination> itinerary;
    private final List<Passenger> passengerList;

    public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = Objects.requireNonNullElseGet(itinerary, ArrayList::new);
        this.passengerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }
    public void addDestinationToItinerary(Destination destination){
        itinerary.add(destination);
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }
    public void addPassenger(Passenger passenger) {
        if(!passengerList.contains(passenger)){
            passengerList.add(passenger);
        }
    }


    public void printItinerary() {
        // Implement logic to print itinerary including destinations and activities
        // Use loops and activity details printing methods

        System.out.println("Travel Package: " + name);
        System.out.println("Travel Passenger Capacity: " + passengerCapacity);
        if(itinerary.isEmpty()){
            System.out.println("No destination added to the itinenary.");
            return;
        }
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getAvailableActivities();
            for (Activity activity : activities) {
                System.out.println("\tActivity: " + activity.getName());
                System.out.println("\t\tDescription: " + activity.getDescription());
                System.out.println("\t\tCost: " + activity.getCost());
                System.out.println("\t\tCapacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        // Implement logic to print passenger list including package name, capacity,
        // number of enrolled passengers, and details of each passenger
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengerList.size() +"\n");
        for (Passenger passenger : passengerList) {
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            System.out.println("Passenger Type: " + passenger.getPassengerType());
            System.out.println("Passenger Balance: " + passenger.getBalance());
            List<Activity> signedUpActivities = passenger.getSignedUpActivities();
            if (!signedUpActivities.isEmpty()) {
                System.out.println("Activities Signed Up For:");
                for (Activity activity : signedUpActivities) {
                    System.out.println("\tActivity: " + activity.getName());
                    // You can include more details of the signed-up activities if needed
                }
            } else {
                System.out.println("No Activities Signed Up For.");
            }
            System.out.println(); // Empty line for readability
        }
    }

    public void printPassengerDetails() {
        // Implement logic to print passenger list including package name, capacity,
        // number of enrolled passengers, and details of each passenger
        if(passengerList.isEmpty()){
            System.out.println("Passenger List is empty.");
            return;
        }
        System.out.println();
        for (Passenger passenger : passengerList) {
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            System.out.println("Passenger Type: " + passenger.getPassengerType());
            System.out.println("Passenger Balance: " + passenger.getBalance());
            List<Activity> signedUpActivities = passenger.getSignedUpActivities();
            if (!signedUpActivities.isEmpty()) {
                System.out.println("Activities Signed Up For:");
                for (Activity activity : signedUpActivities) {
                    System.out.println("\tActivity: " + activity.getName());
                    System.out.println("\tDestination: " + activity.getDestination().getName());
                    System.out.println("\tPrice Paid: " + passenger.getPricePaid(activity));
                    System.out.println();
                }
            } else {
                System.out.println("No Activities Signed Up For.");
            }
            System.out.println(); // Empty line for readability
        }
    }

    public void printPassengerListOfTravelPackage() {
        // Implement logic to print passenger list including package name, capacity,
        // number of enrolled passengers, and details of each passenger
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengerList.size());
        System.out.println();
        for (Passenger passenger : passengerList) {
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            System.out.println(); // Empty line for readability
        }
    }

    public void printAvailableActivities() {
        int count = 0;
        System.out.println("Available Activities for Travel Package: " + name);
        for (Destination destination : itinerary) {
            List<Activity> activities = destination.getAvailableActivities();
            for (Activity activity : activities) {
                if (activity.getCapacity() > 0) {
                    count++;
                    System.out.println("Destination: " + destination.getName());
                    System.out.println("\tActivity: " + activity.getName());
                    System.out.println("\t\tDescription: " + activity.getDescription());
                    System.out.println("\t\tCost: " + activity.getCost());
                    System.out.println("\t\tAvailable Spaces: " + activity.getCapacity());
                }
            }
        }
        if(count == 0){
            System.out.println("No Available Activity Slots");
        }
    }
}

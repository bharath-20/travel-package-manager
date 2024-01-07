package com.travelplanner.travel;

import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;
public class PassengerTest {
    @Test
    public void testPassengerCreation() {
        Passenger passenger = new Passenger("Virat", "9000012345", "standard", 200.0);

        assertEquals("Virat", passenger.getName());
        assertEquals("9000012345", passenger.getPassengerNumber());
        assertEquals("standard", passenger.getPassengerType());
        assertEquals(200.0, passenger.getBalance());
        assertTrue(passenger.getSignedUpActivities().isEmpty());
    }

    @Test
    public void testPassengerSignUpForActivityAtMaximumCapacity() {
        Passenger passenger1 = new Passenger("Sachin", "9000012345", "standard", 100.0);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 0);
        TravelPackage travelPackage = new TravelPackage("Live behind city",100,null);
        Destination destination = new Destination("Switzer Land");
        travelPackage.addDestinationToItinerary(destination);
        destination.addActivity(activity);

        assertFalse(passenger1.signUpForActivity(activity,travelPackage));
    }
    @Test
    public void testPassengerSignUpForActivityWhenDestinationIsNull(){
        Passenger passenger = new Passenger("Sachin", "9000012345", "standard", 100.0);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",0,null);
        Destination destination = new Destination("Switzer Land");
        Destination destination2 = new Destination("La la Land");
        destination.addActivity(activity);
        travelPackage.addDestinationToItinerary(destination2);

        assertFalse(passenger.signUpForActivity(activity,travelPackage));
    }
    @Test
    public void testPassengerSignUpForActivityWhenPackageCapacityZero(){
        Passenger passenger = new Passenger("Sachin", "9000012345", "standard", 100.0);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",0,null);
        Destination destination = new Destination("Switzer Land");
        destination.addActivity(activity);
        travelPackage.addDestinationToItinerary(destination);

        assertFalse(passenger.signUpForActivity(activity,travelPackage));
    }
    @Test
    public void testPassengerSignUpForActivityTypeStandard() {
        Passenger passenger = new Passenger("Sachin", "9000012345", "standard", 100.0);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",100,null);
        Destination destination = new Destination("Switzer Land");
        destination.addActivity(activity);
        travelPackage.addDestinationToItinerary(destination);

        assertTrue(passenger.signUpForActivity(activity,travelPackage));
        assertEquals(50.0, passenger.getBalance());
        assertEquals(1, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testPassengerSignUpForActivityTypeGold() {
        Passenger passenger = new Passenger("Elon", "9000012345", "gold", 200.0);
        Activity activity = new Activity("Scuba Diving", "Underwater adventure", 100.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",100,null);
        Destination destination = new Destination("Switzer Land");
        travelPackage.addDestinationToItinerary(destination);
        destination.addActivity(activity);

        assertTrue(passenger.signUpForActivity(activity,travelPackage));
        assertEquals(110.0, passenger.getBalance());
        assertEquals(1, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testPassengerSignUpForActivityTypePremium() {
        Passenger passenger = new Passenger("Charlie", "9000012345", "premium", 100.0);
        Activity activity = new Activity("Museum Tour", "Historical exploration", 30.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",100,null);
        Destination destination = new Destination("Switzer Land");
        travelPackage.addDestinationToItinerary(destination);
        destination.addActivity(activity);

        assertTrue(passenger.signUpForActivity(activity,travelPackage));
        assertEquals(100.0, passenger.getBalance());
        assertEquals(1, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testPassengerSignUpForInvalidActivityType() {
        Passenger passenger = new Passenger("Sachin", "9000012345", "delux", 100.0);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",100,null);
        Destination destination = new Destination("Switzer Land");
        travelPackage.addDestinationToItinerary(destination);
        destination.addActivity(activity);

        assertFalse(passenger.signUpForActivity(activity,travelPackage));
        assertEquals(100.0, passenger.getBalance());
        assertEquals(0, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testPassengerSignUpForActivityInsufficientBalance() {
        Passenger passenger1 = new Passenger("Raj", "9000012345", "standard", 30.0);
        Passenger passenger2 = new Passenger("Elon", "9000012345", "gold", 20.0);
        Activity activity = new Activity("Skiing", "Snow adventure", 80.0, 10);
        TravelPackage travelPackage = new TravelPackage("Live behind city",100,null);
        Destination destination = new Destination("Switzer Land");
        travelPackage.addDestinationToItinerary(destination);
        destination.addActivity(activity);

        assertFalse(passenger1.signUpForActivity(activity,travelPackage));
        assertEquals(30.0, passenger1.getBalance());
        assertEquals(0, passenger1.getSignedUpActivities().size());

        assertFalse(passenger2.signUpForActivity(activity,travelPackage));
        assertEquals(20.0, passenger2.getBalance());
        assertEquals(0, passenger2.getSignedUpActivities().size());
    }

    @Test
    public void testPassengerDetails() {
        Passenger passenger = new Passenger("Messy", "9000012345", "gold", 300.0);
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        Activity activity2 = new Activity("Scuba Diving", "Underwater adventure", 120.0, 10);
        TravelPackage travelPackage1 = new TravelPackage("Live behind city",100,null);
        Destination destination1 = new Destination("Switzer Land");
        destination1.addActivity(activity1);
        travelPackage1.addDestinationToItinerary(destination1);
        TravelPackage travelPackage2 = new TravelPackage("Sky Travels",100,null);
        Destination destination2 = new Destination("Munnar");
        travelPackage1.addDestinationToItinerary(destination2);
        destination2.addActivity(activity2);

        String expectedDetailsBeforeEnrolling = "Passenger Name: Messy\n" +
                "Passenger Number: 9000012345\n" +
                "Passenger Type: gold\n" +
                "Passenger Balance: 300.0\n" +
                "No Activities Signed Up For.";

        assertEquals(expectedDetailsBeforeEnrolling.trim(), passenger.getPassengerDetails().trim());

        passenger.signUpForActivity(activity1,travelPackage1);
        passenger.signUpForActivity(activity2,travelPackage2);

        String expectedDetails = "Passenger Name: Messy\n" +
                "Passenger Number: 9000012345\n" +
                "Passenger Type: gold\n" +
                "Passenger Balance: 255.0\n" +
                "Activities Signed Up For:\n" +
                "\tActivity: Hiking\n" +
                "\t\tCost Paid: 50.0\n" ;

        assertEquals(expectedDetails.trim(), passenger.getPassengerDetails().trim());
    }

    @Test
    public void testGetPricePaid_StandardPassenger() {
        Passenger standardPassenger = new Passenger("Virat", "9000012345", "standard", 200.0);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        assertEquals(50.0, standardPassenger.getPricePaid(activity));
    }

    @Test
    public void testGetPricePaid_GoldPassenger() {
        Passenger goldPassenger = new Passenger("Sachin", "P002", "gold", 200.0);
        Activity activity = new Activity("Scuba Diving", "Underwater adventure", 120.0, 10);

        assertEquals(108.0, goldPassenger.getPricePaid(activity));
    }

    @Test
    public void testGetPricePaid_PremiumPassenger() {
        Passenger premiumPassenger = new Passenger("Mike", "P003", "premium", 200.0);
        Activity activity = new Activity("Skiing", "Snow adventure", 80.0, 10);

        assertEquals(0.0, premiumPassenger.getPricePaid(activity));
    }

    @Test
    public void testGetPricePaid_InvalidPassengerType() {
        Passenger invalidPassenger = new Passenger("Jane", "P004", "invalid", 150.0);
        Activity activity = new Activity("Trekking", "Mountain expedition", 70.0, 8);

        assertEquals(0.0, invalidPassenger.getPricePaid(activity));
    }

}
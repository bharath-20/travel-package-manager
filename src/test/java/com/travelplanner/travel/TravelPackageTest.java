package com.travelplanner.travel;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TravelPackageTest {
    @Test
    public void testTravelPackageCreation() {
        Destination destination1 = new Destination("Mountain Retreat");
        Destination destination2 = new Destination("Beach Resort");
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        Activity activity2 = new Activity("Scuba Diving", "Underwater adventure", 120.0, 10);

        destination1.addActivity(activity1);
        destination2.addActivity(activity2);

        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination1);
        itinerary.add(destination2);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20, itinerary);

        assertEquals("Adventure Package", travelPackage.getName());
        assertEquals(20, travelPackage.getPassengerCapacity());
        assertEquals(itinerary, travelPackage.getItinerary());
        assertNotNull(travelPackage.getPassengerList());
        assertTrue(travelPackage.getPassengerList().isEmpty());
    }

    @Test
    public void testPrintItinerary() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Destination destination1 = new Destination("Mountain Retreat");
        Destination destination2 = new Destination("Beach Resort");
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        Activity activity2 = new Activity("Scuba Diving", "Underwater adventure", 120.0, 10);

        destination1.addActivity(activity1);
        destination2.addActivity(activity2);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20,null);

        travelPackage.addDestinationToItinerary(destination1);
        travelPackage.addDestinationToItinerary(destination2);


        PrintStream originalOut = System.out;
        System.setOut(printStream);

        travelPackage.printItinerary();
        System.out.flush();
        System.setOut(originalOut);

        String expectedOutput = "Travel Package: Adventure Package\n" +
                "Travel Passenger Capacity: 20\n" +
                "Destination: Mountain Retreat\n" +
                "\tActivity: Hiking\n" +
                "\t\tDescription: Exploring the mountains\n" +
                "\t\tCost: 50.0\n" +
                "\t\tCapacity: 10\n" +
                "Destination: Beach Resort\n" +
                "\tActivity: Scuba Diving\n" +
                "\t\tDescription: Underwater adventure\n" +
                "\t\tCost: 120.0\n" +
                "\t\tCapacity: 10\n";

        expectedOutput = expectedOutput.replaceAll("\n", "").replaceAll("\r", "");
        assertNotNull(outputStream.toString());
        String outputString = outputStream.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expectedOutput, outputString);
    }

    @Test
    public void testPrintPassengerListOfTravelPackage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Destination destination = new Destination("Mountain Retreat");
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        destination.addActivity(activity1);

        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20, itinerary);
        Passenger passenger1 = new Passenger("Virat", "101", "standard", 200.0);
        Passenger passenger2 = new Passenger("Raj", "102", "gold", 100.0);

        passenger1.signUpForActivity(activity1,travelPackage);
        passenger2.signUpForActivity(activity1,travelPackage);

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        travelPackage.printPassengerListOfTravelPackage();
        System.out.flush();
        System.setOut(originalOut);

        String expectedOutput = "Passenger List for Travel Package: Adventure Package\n" +
                "Passenger Capacity: 20\n" +
                "Number of Passengers Enrolled: 2\n" +
                "\n" +
                "Passenger Name: Virat\n" +
                "Passenger Number: 101\n" +
                "\n" +
                "Passenger Name: Raj\n" +
                "Passenger Number: 102";

        expectedOutput = expectedOutput.replaceAll("\n", "").replaceAll("\r", "");
        assertNotNull(outputStream.toString());
        String outputString = outputStream.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expectedOutput, outputString);
    }

    @Test
    public void testPrintPassengerList() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Destination destination = new Destination("Mountain Retreat");
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20, itinerary);
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        destination.addActivity(activity);

        Passenger passenger1 = new Passenger("Virat", "9000012345", "standard", 200.0);
        Passenger passenger2 = new Passenger("Raj", "9000012345", "gold", 100.0);

        passenger1.signUpForActivity(activity,travelPackage);
        travelPackage.getPassengerList().add(passenger2);

        travelPackage.printPassengerList();

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        travelPackage.printPassengerList();
        System.out.flush();
        System.setOut(originalOut);

        String expectedOutput ="Passenger List for Travel Package: Adventure Package\n" +
                "Passenger Capacity: 20\n" +
                "Number of Passengers Enrolled: 2\n" +
                "\n" +
                "Passenger Name: Virat\n" +
                "Passenger Number: 9000012345\n" +
                "Passenger Type: standard\n" +
                "Passenger Balance: 150.0\n" +
                "Activities Signed Up For:\n" +
                "\tActivity: Hiking\n" +
                "\n" +
                "Passenger Name: Raj\n" +
                "Passenger Number: 9000012345\n" +
                "Passenger Type: gold\n" +
                "Passenger Balance: 100.0\n" +
                "No Activities Signed Up For.";

        expectedOutput = expectedOutput.replaceAll("\n", "").replaceAll("\r", "");
        assertNotNull(outputStream.toString());
        String outputString = outputStream.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expectedOutput, outputString);
    }
    @Test
    public void testPrintPassengerListWhenActivitiesEnrolled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Scuba Diving", "Underwater adventure", 100.0, 10);

        destination.addActivity(activity);
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20, itinerary);

        Passenger passenger1 = new Passenger("Virat", "9000012345", "standard", 200.0);
        Passenger passenger2 = new Passenger("Raj", "9000012345", "gold", 100.0);

        passenger1.signUpForActivity(activity,travelPackage);
        passenger2.signUpForActivity(activity,travelPackage);

        travelPackage.getPassengerList().add(passenger1);
        travelPackage.getPassengerList().add(passenger2);

        travelPackage.printPassengerList();

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        travelPackage.printItinerary();
        System.out.flush();
        System.setOut(originalOut);

        assertFalse(passenger1.getSignedUpActivities().isEmpty());
        assertFalse(passenger2.getSignedUpActivities().isEmpty());
        assertNotNull(outputStream.toString());
    }

    @Test
    public void testPrintAvailableActivities() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Destination destination = new Destination("Mountain Retreat");
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        Activity activity2 = new Activity("Skiing", "Snow adventure", 80.0, 5);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20, itinerary);

        travelPackage.printAvailableActivities();

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        travelPackage.printAvailableActivities();
        System.out.flush();
        System.setOut(originalOut);

        String expectedOutput = "Available Activities for Travel Package: Adventure Package\n" +
                "Destination: Mountain Retreat\n" +
                "\tActivity: Hiking\n" +
                "\t\tDescription: Exploring the mountains\n" +
                "\t\tCost: 50.0\n" +
                "\t\tAvailable Spaces: 10\n" +
                "Destination: Mountain Retreat\n" +
                "\tActivity: Skiing\n" +
                "\t\tDescription: Snow adventure\n" +
                "\t\tCost: 80.0\n" +
                "\t\tAvailable Spaces: 5";
        expectedOutput = expectedOutput.replaceAll("\n", "").replaceAll("\r", "");
        assertNotNull(outputStream.toString());
        String outputString = outputStream.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expectedOutput, outputString);
    }
    @Test
    public void testPrintPassengerDetails() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Destination destination = new Destination("Mountain Retreat");
        Activity activity1 = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        Activity activity2 = new Activity("Skiing", "Snow adventure", 80.0, 5);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);

        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20, itinerary);
        Passenger passenger1 = new Passenger("Raj","9000000001", "standard", 1000.0);
        Passenger passenger2 = new Passenger("Virat", "9000000002", "gold", 300.0);

        assertTrue(travelPackage.getPassengerList().isEmpty());
        passenger1.signUpForActivity(activity1,travelPackage);
        passenger1.signUpForActivity(activity1,travelPackage);
        passenger2.signUpForActivity(activity1,travelPackage);


        travelPackage.printPassengerDetails();

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        travelPackage.printPassengerDetails();
        System.out.flush();
        System.setOut(originalOut);

        String expectedOutput = "Passenger Name: Raj\n" +
                "Passenger Number: 9000000001\n" +
                "Passenger Type: standard\n" +
                "Passenger Balance: 900.0\n" +
                "Activities Signed Up For:\n" +
                "\tActivity: Hiking\n" +
                "\tDestination: Mountain Retreat\n" +
                "\tPrice Paid: 50.0\n" +
                "\n" +
                "\tActivity: Hiking\n" +
                "\tDestination: Mountain Retreat\n" +
                "\tPrice Paid: 50.0\n" +
                "\n" +
                "\n" +
                "Passenger Name: Virat\n" +
                "Passenger Number: 9000000002\n" +
                "Passenger Type: gold\n" +
                "Passenger Balance: 255.0\n" +
                "Activities Signed Up For:\n" +
                "\tActivity: Hiking\n" +
                "\tDestination: Mountain Retreat\n" +
                "\tPrice Paid: 45.0";
        expectedOutput = expectedOutput.replaceAll("\n", "").replaceAll("\r", "");
        assertNotNull(outputStream.toString());
        String outputString = outputStream.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expectedOutput, outputString);
    }

}
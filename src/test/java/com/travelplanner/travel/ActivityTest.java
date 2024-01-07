package com.travelplanner.travel;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
public class ActivityTest {
    @Test
    public void testActivityCreation() {
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        assertEquals("Hiking", activity.getName());
        assertEquals("Exploring the mountains", activity.getDescription());
        assertEquals(50.0, activity.getCost());
        assertEquals(10, activity.getCapacity());
        assertNull(activity.getDestination());
    }

    @Test
    public void testActivityUpdateDestination() {
        Destination destination1 = new Destination("Mountain Retreat");
        Destination destination2 = new Destination("Beach Resort");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        assertNull(activity.getDestination());
        activity.setDestination(destination1);
        assertEquals(destination1, activity.getDestination());
        activity.setDestination(destination2);
        assertEquals(destination2, activity.getDestination());
    }


    @Test
    public void testActivityCapacityWhenCapacityGreaterThanZero() {
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 3);

        assertEquals(3, activity.getCapacity());
        activity.reduceCapacity();
        assertEquals(2, activity.getCapacity());
    }

    @Test
    public void testActivityCapacityWhenCapacityIsNotGreaterThanZero() {
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 0);
        String expectedString = "Cannot reduce capacity. Activity already at minimum.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertEquals(0, activity.getCapacity());
        activity.reduceCapacity();
        assertEquals(0, activity.getCapacity());
        assertEquals(expectedString.trim(), outContent.toString().trim());
    }

    @Test
    public void testActivityDestinationChange() {
        Destination destination1 = new Destination("Mountain Retreat");
        Destination destination2 = new Destination("Beach Resort");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        activity.setDestination(destination1);
        assertEquals(destination1, activity.getDestination());
        activity.setDestination(destination2);
        assertEquals(destination2, activity.getDestination());
    }

    @Test
    public void testActivityDetails() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        String expectedDetails = "Name: Hiking, Description: Exploring the mountains, Cost: 50.00, Capacity: 10";
        assertEquals(expectedDetails, activity.getActivityDetails());
    }

    @Test
    public void testGetActivityDetails() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 5);

        String expectedDetails = "Name: Hiking, Description: Exploring the mountains, Cost: 50.00, Capacity: 5";
        assertEquals(expectedDetails, activity.getActivityDetails());
    }

}
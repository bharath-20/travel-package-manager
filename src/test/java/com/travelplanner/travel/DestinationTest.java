package com.travelplanner.travel;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DestinationTest {

    @Test
    public void testDestinationCreation() {
        Destination destination = new Destination("Mountain Retreat");
        assertEquals("Mountain Retreat", destination.getName());
        assertNotNull(destination.getAvailableActivities());
        assertEquals(0, destination.getAvailableActivities().size());
    }
    @Test
    public void testAddActivityToDestination() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        destination.addActivity(activity);
        assertTrue(destination.getAvailableActivities().contains(activity));
        assertEquals(destination, activity.getDestination());
    }
    @Test
    public void testAvailableActivitesListForMultipleActivitesEnrollment() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity1 = new Activity("Hiking1", "Exploring the mountains", 50.0, 10);
        Activity activity2 = new Activity("Hiking2", "Exploring the mountains", 50.0, 10);

        assertEquals(0, destination.getAvailableActivities().size());
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        assertTrue(destination.getAvailableActivities().contains(activity1));
        assertTrue(destination.getAvailableActivities().contains(activity2));
        assertEquals(2, destination.getAvailableActivities().size());
    }

    @Test
    public void testAddingExistingActivityToAnotherDestination() {
        Destination destination1 = new Destination("Mountain Retreat");
        Destination destination2 = new Destination("Beach Resort");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        destination1.addActivity(activity);
        destination2.addActivity(activity);
        assertEquals(destination1, activity.getDestination());
        assertFalse(destination2.getAvailableActivities().contains(activity));
    }
    @Test
    public void testAddActivityWhenDestinationIsNotNull() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        destination.addActivity(activity);
        assertEquals(1, destination.getAvailableActivities().size());

        destination.addActivity(activity);
        assertEquals(1, destination.getAvailableActivities().size());
    }
    @Test
    public void testAddActivityWhenDestinationBeenSetBeforeAddingActivityToDestination() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);
        activity.setDestination(destination);

        destination.addActivity(activity);
        assertEquals(destination, activity.getDestination());
        assertFalse(destination.getAvailableActivities().contains(activity));
    }


    @Test
    public void testRemoveActivityFromDestination() {
        Destination destination = new Destination("Mountain Retreat");
        Activity activity = new Activity("Hiking", "Exploring the mountains", 50.0, 10);

        destination.addActivity(activity);
        System.out.println(destination.getAvailableActivities());
        assertTrue(destination.getAvailableActivities().contains(activity));

        destination.removeActivity(activity);
        assertFalse(destination.getAvailableActivities().contains(activity));
    }

}
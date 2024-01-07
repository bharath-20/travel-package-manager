package com.travelplanner.travel;

public class Activity {
    private final String name;
    private final String description;
    private final double cost;
    private int capacity;
    private Destination destination;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }
    public Destination getDestination() {
        return destination;
    }

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = null;
    }

    public void reduceCapacity(){
        if (capacity > 0) {
            capacity--;
        } else {
            System.out.println("Cannot reduce capacity. Activity already at minimum.");
        }
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getActivityDetails() {
        return String.format("Name: %s, Description: %s, Cost: %.2f, Capacity: %d",
                name, description, cost, capacity);
    }

}

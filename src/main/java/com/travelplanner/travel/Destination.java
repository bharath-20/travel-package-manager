package com.travelplanner.travel;

import java.util.ArrayList;
import java.util.List;

class Destination {
    private final String name;
    private List<Activity> activitiesAvailable = new ArrayList<>();

    public Destination(String name) {
        this.name = name;
        this.activitiesAvailable = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addActivity(Activity activity) {
        if (activity.getDestination() != null ) {
            System.out.println("Activity is already assigned to a destination.");
            return;
        }
        activity.setDestination(this);
        activitiesAvailable.add(activity);
    }

    public void removeActivity(Activity activity) {
        activitiesAvailable.remove(activity);
    }

    public List<Activity> getAvailableActivities() {
        return activitiesAvailable;
    }
}

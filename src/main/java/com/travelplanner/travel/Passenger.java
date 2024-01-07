package com.travelplanner.travel;

import java.util.ArrayList;
import java.util.List;

class Passenger {
    private final String name;
    private final String passengerNumber;
    private final String passengerType;
    private double balance;
    private final List<Activity> signedUpActivities;
    public Passenger(String name, String passengerNumber, String passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public boolean signUpForActivity(Activity activity, TravelPackage travelPackage) {
        if(travelPackage.getItinerary().contains(activity.getDestination())){
            System.out.println(travelPackage);
            if(travelPackage.getPassengerCapacity()<=0) {
                System.out.println("Passenger Limit Exceeded");
                return false;
            }
        }else{
            System.out.println("Destination is not enrolled in this package");
            return false;
        }
        if (activity.getCapacity() <= 0) {
            System.out.println("Activity is already at full capacity.");
            return false;
        }

        switch (passengerType) {
            case "standard":
                double standardCost = activity.getCost();
                if (balance >= standardCost) {
                    balance -= standardCost;
                    travelPackage.addPassenger(this);
                    break;
                } else {
                    System.out.println("Insufficient balance to sign up for this activity.");
                    return false;
                }
            case "gold":
                double discountedCost = activity.getCost() * 0.9;
                if (balance >= discountedCost) {
                    balance -= discountedCost;
                    travelPackage.addPassenger(this);
                    break;
                } else {
                    System.out.println("Insufficient balance to sign up for this activity.");
                    return false;
                }
            case "premium":
                travelPackage.addPassenger(this);
                break; // Premium passengers can sign up for free
            default:
                System.out.println("Invalid passenger type.");
                return false;
        }

        signedUpActivities.add(activity);
        activity.reduceCapacity();
        return true;
    }

    public double getPricePaid(Activity activity){
        double pricePaid = 0.0;
        switch (passengerType) {
            case "standard" -> pricePaid = activity.getCost();
            case "gold" -> pricePaid = activity.getCost() * 0.9;
            case "premium" -> pricePaid = 0.0;
            default -> System.out.println("Invalid passenger type.");
        }
        return pricePaid;
    }
    public String getPassengerDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Passenger Name: ").append(name).append("\n");
        details.append("Passenger Number: ").append(passengerNumber).append("\n");
        details.append("Passenger Type: ").append(passengerType).append("\n");
        details.append("Passenger Balance: ").append(balance).append("\n");
        if (!signedUpActivities.isEmpty()) {
            details.append("Activities Signed Up For:\n");
            for (Activity activity : signedUpActivities) {
                details.append("\tActivity: ").append(activity.getName()).append("\n");
                details.append("\t\tCost Paid: ").append(activity.getCost()).append("\n");
            }
        } else {
            details.append("No Activities Signed Up For.\n");
        }
        return details.toString();
    }
}

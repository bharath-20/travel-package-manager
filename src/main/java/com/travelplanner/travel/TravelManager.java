package com.travelplanner.travel;

import java.util.List;
import java.util.Scanner;

public class TravelManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding Dummy data... ");

        BuildData buildData = new BuildData();
        List<TravelPackage> travelPackageList ;
        travelPackageList = buildData.buildDummyData();

        while(true) {
            System.out.println("Choose the Travel package : \n");
            System.out.println("0 Exit ");
            System.out.println("1 Create new choice ");
            int count = 2;

            for(TravelPackage travelPackage : travelPackageList) {
                System.out.println(count + " Travel Package name : " + travelPackage.getName());
                count++;
            }
            System.out.println("Enter your package: \n");

            int  choice ;

            choice = scanner.nextInt();
            if(choice == 0) {
                System.out.println("Exiting...");
                return;
            } else if (choice == 1) {
                TravelPackage travelPackage = buildData.buildTravelPackage();
                travelPackageList.add(travelPackage);
            }else{
                TravelPackage travelPackage = travelPackageList.get(choice-2);
                boolean flag = true;
                while (flag) {
                    buildData.printChoices();
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 0 -> {
                            System.out.println("Exiting...");
                            flag = false;
                        }
                        case 1 -> travelPackage.printAvailableActivities();
                        case 2 -> travelPackage.printItinerary();
                        case 3 -> travelPackage.printPassengerList();
                        case 4 -> travelPackage.printPassengerDetails();
                        case 5 -> travelPackage.printPassengerListOfTravelPackage();
                        case 6 -> {
                            Destination destination = buildData.buildDestination(travelPackage);
                            Activity activity = buildData.buildActivity(destination);
                            buildData.buildPassenger(activity, travelPackage);
                        }
                        default -> System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }

            }
        }

    }
}


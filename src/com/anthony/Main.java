package com.anthony;
import java.util.ArrayList;
import java.util.Scanner;

/*
Problem 2, Arrays:
You are a recycling truck driver.  You’d like to collect some statistics on how much each of the houses on a certain street is recycling.
Each house has to use crates for their recycling. This street is a little unusual since it only has 8 houses, and the
 city planner must have been a computer programmer, since the house numbers are 0, 1, 2, 3, 4, 5, 6, and 7.
(Hint – the house numbers are the same as array element indexes.)
Write a program that asks for the number of recycling crates set out by each house. You should store this data in an array.
•	How many recycling crates, in total, from all the houses on the street?
•	What is the largest number of crates set out by any house?
•	What is the smallest number of crates set out by any house?
•	Which house had the most recycling? Display that house number.
 */

public class Main {
    static Scanner numberScanner = new Scanner(System.in);
    static Scanner stringScanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Use this to change the amount of houses on the street
        int[] recyclingCrates  = new int[8];
        // Create arrays to store the houses with the most or lowest amount of crates
        // This will handle ties by storing multiple house values
        ArrayList<Integer> highestHouses = new ArrayList<Integer>();
        ArrayList<Integer> lowestHouses = new ArrayList<Integer>();
        // Get the values for crates at each house
        recyclingCrates  = getUserValues(recyclingCrates);
        // Find the total amount of crates
        int totalCrates = totalCrates(recyclingCrates);
        // Find largest amount of crates
        int largestCrateAmount = findLargestAmount(recyclingCrates);
        // Find least crate amount
        int leastCrateAmount = findLeastAmount(recyclingCrates);
        // Find houses with largest amount of recycling
        findHouseLargest(recyclingCrates, largestCrateAmount, highestHouses);
        // Find houses with least crate amount
        findHouseLeast(recyclingCrates, leastCrateAmount, lowestHouses);

        // Output calculations
        System.out.println("The total number of crates for this street is: " + totalCrates);
        System.out.println("The largest amount of crates a house has on this street is: " + largestCrateAmount);
        System.out.println("The fewest amount of crates a house has on this street is: " + leastCrateAmount);
        for (int house:highestHouses) {
            System.out.println(house + " has the most amount of crates : " + largestCrateAmount);
        }
        for (int house:lowestHouses) {
            System.out.println(house + " has the least amount of crates: " + leastCrateAmount);
        }
        //Close scanners
        numberScanner.close();
        stringScanner.close();

    }

    // Method to find the houses with the least amount of crates
    private static void findHouseLeast(int[] recyclingCrates, int leastCrateAmount, ArrayList<Integer> lowestHouses) {
        int houseWithLeastAmount = 0;
        // Loop through recyclingCrates to find the house with the least crates and set
        for (int i = 0; i < recyclingCrates.length; i++) {
            int recyclingCrate = recyclingCrates[i];
            if (recyclingCrate == leastCrateAmount){
                lowestHouses.add(i);
            }
        }
    }

    // Method to find the house with the most crates
    private static void findHouseLargest(int[] recyclingCrates, int largestCrateAmount, ArrayList<Integer> highestHouses) {
        int houseWithLargestAmount = 0;
        // Loop through recyclingCrates to find the house with the most crates and set
        for (int i = 0; i < recyclingCrates.length; i++) {
            int recyclingCrate = recyclingCrates[i];
            if (recyclingCrate == largestCrateAmount){
                highestHouses.add(i);
            }
        }
    }

    // Method to find the least amount of crates
    private static int findLeastAmount(int[] recyclingCrates) {
        // Find the last value entered and set that as the least amount of crates
        int leastCrateAmount = recyclingCrates[(recyclingCrates.length - 1)];
        // Loop through the recyclingCrates array and find the lowest value
        for (int recyclingCrate : recyclingCrates) {
            // If current crate value is lowest change the lowest value to match it
            if (recyclingCrate < leastCrateAmount) {
                leastCrateAmount = recyclingCrate;
            }
        }
        return leastCrateAmount;
    }

    private static int findLargestAmount(int[] recyclingCrates) {
        // Find largest amount of crates found at any house
        int largestCrateAmount = 0;
        // Loop through the recyclingCrates array and find the highest value
        for (int recyclingCrate : recyclingCrates) {
            // If the current value is higher than the highest stored set it as the new highest
            if (recyclingCrate > largestCrateAmount) {
                largestCrateAmount = recyclingCrate;
            }
        }
        return largestCrateAmount;
    }

    // Method to find the total recycling crates
    private static int totalCrates(int[] recyclingCrates) {
        int totalCrates = 0;
        for (int crates:recyclingCrates) {
            totalCrates += crates;
        }
        return totalCrates;
    }

    // Method to get amount of crates from user
    private static int[] getUserValues(int[] recyclingCrates) {
        // Loop through and ask the user how many crates each house has
        for (int i = 0; i < recyclingCrates.length; i++) {
            System.out.print("How many recycling crates does house " + i + " have? ");
            recyclingCrates[i] = numberScanner.nextInt();
        }
        return recyclingCrates;
    }

}

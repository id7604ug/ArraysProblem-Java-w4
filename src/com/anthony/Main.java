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
        // Get the values for crates at each house
        recyclingCrates  = getUserValues(recyclingCrates);
        // Find the total amount of crates
        int totalCrates = totalCrates(recyclingCrates);
        // Find largest amount of crates
        int largestCrateAmount = findLargestAmount(recyclingCrates);
        // Find least crate amount
        int leastCrateAmount = findLeastAmount(recyclingCrates);
        // Find house with largest amount of recycling
        int houseLargest = findHouseLargest(recyclingCrates, largestCrateAmount);
        // Output calculations
        System.out.println("The total number of crates for this street is: " + totalCrates);
        System.out.println("The largest amount of crates a house has on this street is: " + largestCrateAmount);
        System.out.println("The fewest amount of crate a house has on this street is:  " + leastCrateAmount);
        System.out.println("The house with the most crates is: House " + houseLargest);
        //Close scanners
        numberScanner.close();
        stringScanner.close();

    }

    // Method to find the house with the most crates
    private static int findHouseLargest(int[] recyclingCrates, int largestCrateAmount) {
        int houseWithLargestAmount = 0;
        // Loop through recyclingCrates to find the house with the most crates and set
        for (int i = 0; i < recyclingCrates.length; i++) {
            int recyclingCrate = recyclingCrates[i];
            if (recyclingCrate == largestCrateAmount){
                houseWithLargestAmount = i;
            }
        }
        return houseWithLargestAmount;
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

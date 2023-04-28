package edu.guilford;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ComputerSortSearch 
{
    private Scanner scan;
    private static Random rand = new Random();
    public static void main( String[] args )
    {
        //Create a scanner that prompts user for max number of computers
        Scanner scan = new Scanner(System.in);
        System.out.println("How many computers would you like to create?");
        int maxComputers = scan.nextInt();
        //Create an array of computer classes
        Computer[] computers = new Computer[maxComputers];
        //Create a for loop that creates a computer class for each index of the array   
        for(int i = 0; i < maxComputers; i++){
            computers[i] = new Computer();
        }

        if (computers.length <= 10){
            //print out unsorted array
            System.out.println("Unsorted Array: " + Arrays.toString(computers));
        }
        //Time how long it takes to sort the array using selection sort
        long startTime = System.nanoTime();
        CoreClockSortAndSearch.selectionSort(computers);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("\nSelection sort took " + (duration/1.e6) + " milliseconds to sort " + maxComputers + " computers.");
        
        if (computers.length <= 10){
            //print out unsorted array
            System.out.println("\nSorted Array: " + Arrays.toString(computers));
        }

        //shuffle the array for next test
        shuffle(computers);
        //sort array using quicksort
        startTime = System.nanoTime();
        CoreClockSortAndSearch.quickSort(computers);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("\nQuick sort took " + (duration/1.e6) + " milliseconds to sort " + maxComputers + " computers.");

        //shuffle the array for next test
        shuffle(computers);
        //search for specific core clock
        //System.out.println("\nWhat core clock would you like to search for?");
        //double searchClock = scan.nextDouble();

        double searchClock = (rand.nextInt(50) + 1)/10.0;
        //searchClock = 4.0;
        startTime = System.nanoTime();
        int index = CoreClockSortAndSearch.linearSearch(computers, searchClock);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        if(index == -1){
            System.out.println("\nLinear search took " + (duration/1.e6) + " milliseconds to search " + maxComputers + " computers and did not find a computer with a core clock of " + searchClock + ".");
        } else {
            System.out.println("\nLinear search took " + (duration/1.e6) + " milliseconds to search " + maxComputers + " computers and found a computer with a core clock of " + searchClock + " at index " + index + ".");
        }

        //quick sort array for binary search test
        CoreClockSortAndSearch.quickSort(computers); //remove if testing fixed searchClock
        startTime = System.nanoTime();
        index = CoreClockSortAndSearch.binarySearch(computers, searchClock);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        if(index == -1){
            System.out.println("\nBinary search took " + (duration/1.e6) + " milliseconds to search " + maxComputers + " computers and did not find a computer with a core clock of " + searchClock + ".");
        } else {
            System.out.println("\nBinary search took " + (duration/1.e6) + " milliseconds to search " + maxComputers + " computers and found a computer with a core clock of " + searchClock + " at index " + index + ".");
        }

    }

    //shuffle
    public static void shuffle(Computer[] computers) {
        // Loop over all elements in the array
        for (int i = 0; i < computers.length; i++) {
            // Pick a random index between 0 and i
            int randomIndex = (int) (Math.random() * computers.length);
            // Swap the element at the random index with the element at i
            CoreClockSortAndSearch.swap(computers, i, randomIndex);
        }
    }
}

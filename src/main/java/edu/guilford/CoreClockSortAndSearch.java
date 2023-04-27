package edu.guilford;

public class CoreClockSortAndSearch {
    // Add a static selectionSort method that takes an array of integers as a
    // parameter
    // and sorts the array using the selection sort algorithm.
    public static void selectionSort(Computer[] array) {
        // Loop over all elements in array, and find the smallest one
        // Swap the smallest element with the first element
        // Repeat for all elements except the first
        for (int i = 0; i < array.length; i++) {
            // Assume the smallest element is the first element
            int smallest = i; // keep track of index of smallest element
            // Loop over all elements after the first element
            for (int j = i + 1; j < array.length; j++) {
                // If the current element is smaller than the smallest element
                if (array[j].getCoreClock() < array[smallest].getCoreClock()) {
                    // Set the smallest element to the current element
                    smallest = j;
                }
            }
            // Swap the smallest element with the first element
            swap(array, i, smallest);
        }
    }

    // Add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm.
    public static void quickSort(Computer[] array) {
        // Call the recursive quickSort method
        quickSort(array, 0, array.length - 1);
    }

    // Add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm.
    // This method is recursive.
    public static void quickSort(Computer[] array, int start, int end) {
        // If the array has more than one element
        if (start < end) {
            // Partition the array
            int partitionIndex = partition(array, start, end);
            // Recursively quickSort the left partition
            quickSort(array, start, partitionIndex - 1);
            // Recursively quickSort the right partition
            quickSort(array, partitionIndex + 1, end);
        }
    }

    // Add a static partition method that takes an array of integers as a
    // parameter and partitions the array using the quick sort algorithm.
    public static int partition(Computer[] array, int start, int end) {
        // Pick the last element as the pivot
        Computer pivot = array[end];
        // Set the partition index to the start
        int partitionIndex = start;
        // Loop over all elements in the array
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array[i].getCoreClock() < pivot.getCoreClock()) {
                // Swap the current element with the element at the partition index
                swap(array, i, partitionIndex);
                // Increment the partition index
                partitionIndex++;
            }
        }
        // Swap the element at the partition index with the pivot
        swap(array, partitionIndex, end);
        // Return the partition index
        return partitionIndex;
    }

    // create a method that swaps two elements in an array
    public static void swap(Computer[] array, int index1, int index2) {
        Computer temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //Add a linear or seqeuntial search algorithm
    public static int linearSearch(Computer[] array, Double target) {
        // Loop over all elements in the array
        //and stop when the target is found
        for (int i = 0; i < array.length; i++) {
            // If the current element is equal to the target
            if (array[i].getCoreClock() == target) {
                // Return the index of the current element
                return i;
            }
        }
        // Return -1 if the target is not found
        return -1;
    }

    //Add a binary search algorithm
    public static int binarySearch(Computer[] array, Double target) {
        // Set the start index to 0
        int start = 0;
        // Set the end index to the last index in the array
        int end = array.length - 1;
        // Loop until the start index is greater than the end index
        while (start <= end) {
            // Set the middle index to the average of the start and end indices
            int middle = (start + end) / 2;
            // If the target is less than the element at the middle index
            if (target < array[middle].getCoreClock()) {
                // Set the end index to the middle index minus 1
                end = middle - 1;
            }
            // If the target is greater than the element at the middle index
            else if (target > array[middle].getCoreClock()) {
                // Set the start index to the middle index plus 1
                start = middle + 1;
            }
            // If the target is equal to the element at the middle index
            else {
                // Return the middle index
                return middle;
            }
        }
        // Return -1 if the target is not found
        return -1;
    }
}

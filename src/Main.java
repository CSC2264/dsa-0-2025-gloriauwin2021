// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,  
// then press Enter. You can now see whitespace characters in your code.

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000);  // Generate 10,000 random numbers between 1 and 100
        mergesort(numbers, 0, numbers.length - 1);  // Sort using merge sort
        display(numbers);  // Display the sorted array
    }

    /* Generate an array of random integers between 1 and 100*/
    public static int[] generate(int low, int high, int size) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(high - low + 1) + low;  // Random number between low and high
        }
        return result;
    }

    // Merge sort implementation
    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(a, low, mid);  // Sort left half
            mergesort(a, mid + 1, high);  // Sort right half
            merge(a, low, mid, high);  // Merge the two halves
        }
    }

    // Merge two sorted halves
    public static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = a[low + i];
        for (int j = 0; j < n2; j++) right[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    // Display array elements
    public static void display(int[] a) {
        for (int x : a) {
            System.out.print(x + "\t");
        }
    }
}

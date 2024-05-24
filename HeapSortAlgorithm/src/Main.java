import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int size = 25; // size of array
        int max = 1000; // max integer for random numbers (0-1000)
        int[] randomList = new int[size];

        //Generates random numbers for array;
        for (int i = 0; i < size; i++) {
            randomList[i] = RandomIntGenerator.getRand(max); //Generates and adds random integers into array
        }
        System.out.println("Unsorted array:\t" + Arrays.toString(randomList)); // Unordered list
        HeapSort.heapSort(randomList); // Sorts list
        System.out.println("Sorted array:\t" + Arrays.toString(randomList)); // Sorted list

    }
}
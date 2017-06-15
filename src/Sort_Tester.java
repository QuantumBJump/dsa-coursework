import java.util.Scanner;
import java.util.Random;

public class Sort_Tester {



    public static void main(String[] args)
    {
        // allow user to input custom array size
        Scanner scanner = new Scanner(System.in);
        System.out.println("How big is your array?");
        int arraySize = scanner.nextInt();
        int [] arr = new int [arraySize];

        // variables to keep track of start/finish times
        long start;
        long finish;
        long elapsedTime;

        Random random = new Random();

        // populate array
        for (int i = 0; i < arraySize; i++) {
            arr[i] = random.nextInt(50);
        }

        // create array to sort
        int[] toBeSorted = new int[arr.length];


        Sort x = new Sort();

        // copy random array so we can sort it without changing the state
        // of the original array
        System.arraycopy(arr, 0, toBeSorted, 0, arr.length);
        start = System.nanoTime();
        x.BubbleSort(toBeSorted);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        System.out.println("Bubble sort took: " + elapsedTime/1000000 + " milliseconds.");

        // copy array again
        System.arraycopy(arr, 0, toBeSorted, 0, arr.length);
        start = System.nanoTime();
        x.insertionSort(toBeSorted);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        System.out.println("Insertion sort took: " + elapsedTime/1000000 + " milliseconds.");

        // and again
        System.arraycopy(arr, 0, toBeSorted, 0, arr.length);
        start = System.nanoTime();
        x.mergSort(toBeSorted, 0, toBeSorted.length);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        System.out.println("Merge sort took: " + elapsedTime/1000000 + " milliseconds.");

        System.arraycopy(toBeSorted, 0, arr, 0, toBeSorted.length);
//        printArray(arr);
    }

    static void printArray(int a[])
    {   // prints the array

        for(int i=0; i<a.length;i++)
            System.out.println(a[i]);

    }


}
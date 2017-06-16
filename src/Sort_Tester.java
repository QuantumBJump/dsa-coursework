import com.sun.xml.internal.fastinfoset.tools.PrintTable;

import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.IOException;


public class Sort_Tester {
    static Random random = new Random();
    static File outputfile = new File("results.csv");
    static String outputString = "array size, bubble sort, insertion sort, merge sort, quick sort\n";

    public static void write(File file, String output) {
        try {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.print(output);
            writer.close();
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(50);
        }
        return array;
    }

    public static void sort(int[] array) {
        // variables to keep track of times
        long start;
        long finish;
        long elapsedTime;
        // copy of array so we can sort without changing original array
        int[] toBeSorted = new int[array.length];
        outputString = outputString + Integer.toString(array.length) + ", ";

        Sort x = new Sort();

        System.arraycopy(array, 0, toBeSorted, 0, array.length);
        start = System.nanoTime();
        x.BubbleSort(toBeSorted);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        outputString = outputString + Long.toString(elapsedTime/1000000) + ", ";

        // copy array again
        System.arraycopy(array, 0, toBeSorted, 0, array.length);
        start = System.nanoTime();
        x.insertionSort(toBeSorted);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        outputString = outputString + Long.toString(elapsedTime/1000000) + ", ";

        // and again
        System.arraycopy(array, 0, toBeSorted, 0, array.length);
        start = System.nanoTime();
        x.mergeSort(toBeSorted, 0, toBeSorted.length);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        outputString = outputString + Long.toString(elapsedTime/1000000) + ", ";

        System.arraycopy(array, 0, toBeSorted, 0, array.length);
        start = System.nanoTime();
        x.quickSort(toBeSorted, 0, toBeSorted.length-1);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        outputString = outputString + Long.toString(elapsedTime/1000000) + "\n";
    }

    public static void main(String[] args)
    {
        // allow user to input custom array size

        int[] arraySizes = {100, 1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How big is your array?");
//        int arraySize = scanner.nextInt();
//        int [] arr = new int [arraySize];

        // reset output file
        outputfile.delete();

        for (int i = 0; i < arraySizes.length; i++) {
            int[] array = generateArray(arraySizes[i]);
            sort(array);
        }

        try {
            PrintWriter writer = new PrintWriter(outputfile, "UTF-8");
            writer.print(outputString);
            writer.close();
        } catch (IOException e) {
            System.exit(1);
        }
    }

    static void printArray(int a[])
    {   // prints the array

        for(int i=0; i<a.length;i++)
            System.out.println(a[i]);

    }


}
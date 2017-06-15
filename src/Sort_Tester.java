public class Sort_Tester {



    public static void main(String[] args)
    {

        int [] arr = new int [100000];


        // TODO: generate random number and put them in the array here ...





        Sort x = new Sort();


        // x.BubbleSort(arr);

        // x.insertionSort(arr);

        // x.mergSort(arr, 0, 100000);

        printArray(arr);


    }

    static void printArray(int a[])
    {   // prints the array

        for(int i=0; i<a.length;i++)
            System.out.println(a[i]);

    }


}
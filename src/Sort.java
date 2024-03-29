public class Sort {

    public Sort(){}


    /* Bubble Sort function */
    public void BubbleSort( int List[])
    {
        int temp;
        int size = List.length;
        for (int i = 0; i < (size - 1); i++)
        {
            for(int j=0; j< (size -(i+1)); j++)
            {
                if (List[j]> List[j+1])
                {
                    temp = List[j];
                    List[j]= List[j+1];
                    List[j+1] = temp;
                }
            }

        }
    }


    /* Insertion Sort function */
    public void insertionSort(int a[])
    {
        int size = a.length;

        for(int i=1; i<size; i++)
        {
            int  index = a[i];
            int j = i-1;
            while(index < a[j])
            {
                a[j+1]= a[j];
                a[j] = index;
                j--;
                if(j< 0)
                    break;
            }
        }
    }


    /* Merge Sort function */
    public static void mergeSort(int[] a, int low, int high)
    {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N/2;
        // recursively sort 
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
        {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j]<a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[low + k] = temp[k];
    }

    public static void quickSort(int[] inputArray, int low, int high) {
        if (inputArray == null || inputArray.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        //pick pivot
        int middle = low + (high - low) / 2;
        int pivot = inputArray[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while(inputArray[i] < pivot) {
                i++;
            }
            while(inputArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two subarrays
        if (low < j) {
            quickSort(inputArray, low, j);
        }
        if (high > i) {
            quickSort(inputArray, i, high);
        }

    }
}
public class QuickAlgo {
    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 3, 10, 5};

        System.out.println("Before sorting:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting:");
        printArray(arr);
    }

    //QUICK SORT RECURSIVE 
    public static void quickSort(int [] arr, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partition(arr, low, high);         //partition setup
            quickSort(arr, low, pivotIndex - 1);                //sorts left
            quickSort(arr, pivotIndex + 1, high);               //sorts right
        }
    }

    public static int partition (int [] arr, int low, int high)
    {
        int pivot = arr[high];  //choose last element as pivot
        int i = low - 1;        //index of smaller elements

        for(int j = low; j < high; j++)
        {
            if(arr[j] <= pivot)
            {
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr, i+ 1, high);          //place pivot in correct position
        return i + 1;
    }

    //SWAP HELPER
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //PRINTS ARRAY
    public static void printArray(int [] arr)
    {
        for(int num : arr) System.out.print(num + " " );
        System.out.println();
    }

}

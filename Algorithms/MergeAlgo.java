
public class MergeAlgo {
    public static void main(String[] args) {
        int [] arr = {5,2,9,1,6,3};

        System.out.println("Before Sort");
        printArray(arr);

        mergeSort(arr, 0, arr.length -1);

        System.err.println("After Sort");
        printArray(arr);
    }


    //RECRUSIVE MERGE SORT
    public static void mergeSort(int [] arr, int left, int right)
    {
        if(left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);                  //SORT LEFT HALF
        mergeSort(arr, mid + 1, right);             //SORT RIGHT HALF

        merge(arr, left, mid, right);               //MERGE THE HALVES TOGETHER
    }

    public static void merge(int [] arr, int left, int mid, int right)
    {
        int [] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        //COMPARE AND COPY THE SMALLER ELEMENT
        while(i <= mid && j <= right)
        {
            if(arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //COPY REMAINING ELEMENTS FROM LEFT HALF
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        //COPY REMAINING ELEMENTS FROM RIGHT HALF
        while(j <= right) {
            temp[k++] = arr[j++];
        }

        //COPY BACK TO ORIGINAL ARRAY
        for(int x = 0; x < temp.length; x++)
        {
            arr[left + x] = temp[x];
        }
    }

    //HELPER TO PRINT THE ARRAY
    public static void printArray(int [] arr)
    {
        for(int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}

/**
 * HOW MERGE SORT WORKS 
 * 1) DIVIDE AND CONQ ALGORITHM 
 * 2) HAVE A LEFT SIDE AND RIGHT SIDE (SUBARRAYS) WITH COPIES OF ELEMENTS PER ARRAY
 * 3) CALL MERGE SORT AGAIN ON THE SUBARRAYS
 * 4) RECURSIVE CALLS CONTINUE AND STOP WHEN THE ARRAYS ARE SORTED AND HAVE THE ARRAY SIZE OF 1
 * 5) HELPER FUNCTION CALLED 'MERGE'
 * 6) MERGE IS CALLED AND TAKES ELEMENTS FROM BOTTOM UP (STARTING AT SIZE 1) KEEPS ON MERGING THE SMALL ARRAYS TO CREATE ONE COHESIVE ARRAY
 * 7) TYPICALLY START ON SORTING LEFT SIDE COMPLETELY THEN RIGHT SIDE
 */
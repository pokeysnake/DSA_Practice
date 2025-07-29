import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;



public class HEAPS {
    public static void main(String[] args) {
        // Min Heap (default behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(8);
        minHeap.add(1);

        System.out.println("\nMin Heap:");
        //System.out.flush();

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");  // prints: 1 2 5 8
        }
        System.out.println(); // New line

        // Max Heap (using custom comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(4);
        maxHeap.add(15);
        maxHeap.add(1);
        maxHeap.add(20);

        System.out.println("\nMax Heap:");
        //System.out.flush();
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");  // prints: 20 15 10 4 1
        }
        System.out.println();
    }
}

class myMinHeapArray {
    private ArrayList<Integer> heap;                        //for now storing the list of values to simulate a binary tree

    public myMinHeapArray()
    {
        heap = new ArrayList<>();
    }


    //Index helpers that follow the indexing equations
    private int parent(int i) {return (i-1) / 2;}
    private int left(int i) {return 2 * i + 1;}
    private int right(int i) {return 2 * i + 2;}

    //INSERT VALUE INTO A HEAP
    public void insert(int val)
    {
        heap.add(val);                      //adds at the end of list
        heapifyUp(heap.size() - 1);         //fixe heaps order from the bottom up via bubbling
    }

    //REMOVE AND RETURN THE MINIMUM VALUE (ROOT)
    public int remove() 
    {
        if(heap.isEmpty()) return -1;
        int min = heap.get(0);

        int last = heap.remove(heap.size() -1);       //remove last element

        if(!heap.isEmpty())
        {
            heap.set(0,last);                   //move last to root (because it is the new lowest value)
            heapifyDown(0);                         //fix heaps order from top down
        }

        return min;
    }

    //PEEK AT THE MIN VALUE (ROOT)
    public int peek()
    {
        return heap.isEmpty() ? -1 : heap.get(0);
    }


    //restore heap upwards
    public void heapifyUp(int i)
    {
        while(i > 0 && heap.get(i) < heap.get(parent(i)))       //first reads value at index i, if the new element is smaller than its parent --> swap || repeat until eleemts in right spot or becoms the root
        {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    //RESTORE HEAP DOWNWARDS
    /**
     * LOOKS AT CURRENT NODE (SMALLEST = I) 
     * COMPARES TO BOTH CHILDREN L AND R AND DECIDES WHICH IS THE NEW SMALLEST
     * IF EITHER CHILD IS SMALLER, SWAP THEM AND CONTINUE DOWN
     */
    public void heapifyDown(int i)
    {
        int smallest = i;
        int l = left(i), r = right(i);

        if(l < heap.size() && heap.get(l) < heap.get(smallest)) smallest = l;
        if(r < heap.size() && heap.get(r) < heap.get(smallest)) smallest = r;

        if(smallest != i)
        {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }


    //SWAP HELPER
    private void swap (int i, int j)
    {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    //PRINT DA HEAP
    public void printHeap()
    {
        System.out.println(heap);
    }



}
public class HeapSort {
    public static void heapSort(int[] list) {
        int size = list.length;

        // create a heap of correct max size
        int[] heap = new int[size];

        // add each element of list to the heap
        for (int i = 0; i < size; i++) {
            add(list[i], heap, i);
        }
        // Remove elements from heap and place them back in the list sorted
        for (int i = size - 1; i >= 0; i--) {
            list[i] = remove(heap, i);
        }
    }
    private static void add(int item, int[] heap, int index) {
        heap[index] = item; // place new item at the end of the heap
        int temp; // temporary variable for swapping
        int parent = (index - 1) / 2; // parent's index
        //Compare added element with parent and swap if necessary
        while (index > 0 && (heap[index] > heap[parent])) {
            //swap the current item with parent
            temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent; // move up the parent's index
            parent = (index - 1) / 2; // recalculate the parent's index
        }
    }
    private static int remove(int[] heap, int last) {
        int root = heap[0]; // maximum element in the heap
        heap[0] = heap[last]; // Move the last element to root

        int i = 0, left, right, max;
        int temp;

        // heapify down
        while (i < last) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            if (left >= last)
                return root;
            else {
                max = left;
                if (right < last && heap[right] > heap[left])
                    max = right;

                if (heap[i] >= heap[max])
                    return root;
            }
            temp = heap[max];
            heap[max] = heap[i];
            heap[i] = temp;
            i = max;
        }
        return root;
    }
}

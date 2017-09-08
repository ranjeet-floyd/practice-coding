package future.fry.practice.amazon;

/**
 *
 * @author ranjeet
 */
public class KthLargestElement {

    /* Find the kth largest element in an unsorted array. 
    Note that it is the kth largest element in the sorted order, not the kth distinct element
     */
    public static void main(String[] args) {

        /*
         For example,
         Given [3,2,1,5,6,4] and k = 2, return 5.
         */
        KthLargestElement kthLargestElement = new KthLargestElement();
//        int[] arr = {3, 2, 1, 5, 6, 4};
//        int k = 2;
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Kth largest element :" + kthLargestElement
                .findKthLargestElement(arr, 0, arr.length - 1, arr.length - k));
    }

    /*
    use quick sort to find the kth largest element 
     */
    private int findKthLargestElement(int[] arr, int low, int high, int k) {
        if (low > high) {
            return Integer.MAX_VALUE;
        }
        int pos = getPivot(arr, low, high);

        if (pos - low == k - 1) {
            return arr[pos];
        }
        if (pos - low > k - 1) {
            return findKthLargestElement(arr, low, pos - 1, k);
        }

        return findKthLargestElement(arr, pos + 1, high, k - pos + low - 1);
    }

    private int getPivot(int[] arr, int low, int high) {
        int pivot = high;//choose last element as pivot.

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                //swap 
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;

            }
        }

        //finally swap ith and pivot element
        int tmp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = tmp;

        return i + 1;

    }

}

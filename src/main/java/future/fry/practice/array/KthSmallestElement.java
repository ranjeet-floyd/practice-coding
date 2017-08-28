package future.fry.practice.array;

import java.util.Arrays;

/**
 *
 * @author ranjeet
 */
public class KthSmallestElement {

    /*
    http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
     */
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 10};
//        partition(arr, 0, arr.length - 1);

        System.out.println("3th smallest element : " + kthSmallestElement(arr, 0, arr.length - 1, 3));
        System.out.println("3th largest element : " + kthLargestElement(arr, 0, arr.length - 1, 3));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static int kthLargestElement(int[] arr, int l, int r, int k) {

        //validate k
        if (k > 0 && k <= r - l + 1) {
            int pivotPos = partition(arr, l, r);
            //if pivot pos is kth largest
            if (pivotPos == r - k + 1) {
                return arr[pivotPos];
            }
            //then check it is right or left

            //if pos is less then kth position
            //go right
            if (pivotPos < r - k + 1) {
                return kthLargestElement(arr, pivotPos + 1, r, k);
            } else {
                return kthLargestElement(arr, l, pivotPos - 1, pivotPos - 1 - k);
            }

        }
        return Integer.MAX_VALUE;
    }

    private static int kthSmallestElement(int[] arr, int l, int r, int k) {

        //validate k 
        if (k > 0 && k <= r - l + 1) {
            int pivot = partition(arr, l, r);
            //if position is same as k -1 | this is our kth smallest element
            if (pivot - l == k - 1) {
                return arr[pivot];
            }

            //if position is more then go left
            if (pivot - l > k - 1) {
                return kthSmallestElement(arr, l, pivot - 1, k);
            } else {
                //must be in right
                return kthSmallestElement(arr, pivot + 1, r, k + l - pivot - 1);
            }
        }
        return Integer.MAX_VALUE;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

    }

    //consider last element as pivot and move all smaller element to left and larger element to right.
    private static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];

        int j = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                j++;
                swap(arr, i, j);

            }
        }

        swap(arr, j + 1, r);
        return j + 1;

    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);
            //divide
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
}

package future.fry.practice.random;

/**
 *
 * @author ranjeet
 */
public class MedianOfArray {

    /*
     given an unsorted array, get the median of array. – this has to be done in O(n)
     */

    public static void main(String[] args) {
        MedianOfArray medianOfArray = new MedianOfArray();
        int[] arr = {3, 2, 4, 6, 1};
        
        System.out.println(medianOfArray.median(arr));

    }

    private int median(int[] arr) {

        boolean isEvenLen = false;

        if (arr.length % 2 == 0) {
            isEvenLen = true;
        }
        int len = isEvenLen ? arr.length / 2 : (arr.length + 1) / 2;
        int left = 0;
        int right = arr.length - 1;
        int index = 0;
        while (index <= len) {
            if (arr[left] > arr[right]) {
                //swap
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] > arr[arr.length - 1 - i]) {
                //swap
                int tmp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tmp;
            }
        }

        int mid = arr.length / 2;
        if (isEvenLen) {

            return (arr[mid] + arr[mid + 1]) / 2;
        } else {
            return arr[mid];
        }
    }
}

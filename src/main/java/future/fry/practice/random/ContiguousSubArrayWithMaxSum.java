package future.fry.practice.random;

/**
 *
 * @author ranjeet
 */
public class ContiguousSubArrayWithMaxSum {

    /*
    Given an array containing both negative and positive integers. 
    Find the contiguous sub-array with maximum sum.
     */
    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ContiguousSubArrayWithMaxSum csawms = new ContiguousSubArrayWithMaxSum();
//        System.out.println(csawms.max_subarray(arr));
//        int[] indexes = csawms.max_subArrayIndex(arr);
//        System.out.println("From Index : " + indexes[0] + " To Index : " + indexes[1]);
        int maxSum = csawms.max_subArrayDy(arr, 1, arr[0], arr[0]);
        System.out.println(maxSum);


    }

    private int max_subArrayDy(int[] arr, int i, int maxTillNow, int tmpMax) {
        if (i >= arr.length) {
            return maxTillNow;
        }

        tmpMax = Math.max(arr[i], tmpMax + arr[i]);
        maxTillNow = Math.max(tmpMax, maxTillNow);
        return max_subArrayDy(arr, i + 1, maxTillNow, tmpMax);

    }

    private int max_subarray(int[] arr) {
        int max_end_here = arr[0];
        int max_so_far = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max_end_here = Math.max(arr[i], max_end_here + arr[i]);
            max_so_far = Math.max(max_end_here, max_so_far);
        }

        return max_so_far;

    }

    private int[] max_subArrayIndex(int[] arr) {
        int[] indexes = new int[2];
        int fromIndex = 0;
        int toindex = 0;
        //tmpMax calcuate for index  i
        //max track max sum till
        int tmpMax = arr[0], max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (tmpMax + arr[i] > arr[i]) {
                tmpMax = tmpMax + arr[i];

            } else {
                tmpMax = arr[i];
                //reset
                fromIndex = i;
                toindex = i;
            }
            if (max < tmpMax) {
                //change max
                max = tmpMax;
                toindex = i; // update to  index
            }
        }

        indexes[0] = fromIndex;
        indexes[1] = toindex;
        return indexes;
    }

}

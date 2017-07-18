package future.fry.practice.random;

/**
 * Find the number of rotations in a rotated and sorted array
 *
 * @author ranjeet
 */
public class RotationCount {

    /*
    Input : arr[] = {15, 18, 2, 3, 6, 12}
     */
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
//       int[] arr = {7, 9, 11, 12, 5};
//       int[]  arr = {7, 9, 11, 12, 15};
        RotationCount rotationCount = new RotationCount();
        int rotCount = rotationCount.numOfRotation(arr);
        int rotCountBS = rotationCount.numOfRotationBS(arr, 0, arr.length - 1);
        System.out.println("rotationCount : " + rotCount);
        System.out.println("rotationCount BS : " + rotCountBS);
    }

    /*
    Iterate over array and find the lowest number index.
    TC: O(n)
     */
    private int numOfRotation(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            return 0;
        }
        int prevMin = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < prevMin) {
                count = i;
                break;
            }
        }

        return count;

    }

    /*
    use binary search | find element whose left  element is grt.
     */
    private int numOfRotationBS(int[] arr, int min, int max) {
        if (min > max) {
            return 0;
        }

        if (min == max) {
            return min;
        }

        int mid = (min + max) / 2;

        if (mid < max && arr[mid + 1] < arr[mid]) {
            return mid + 1;

        }

        if (mid > min && arr[mid - 1] > arr[mid]) {
            return mid;
        }

        //go left
        if (arr[max] > arr[mid]) {

            return numOfRotationBS(arr, min, mid - 1);
        }
        return numOfRotationBS(arr, mid + 1, max);

    }

}

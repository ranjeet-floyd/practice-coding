package future.fry.practice.array;

/**
 *
 * @author ranjeet
 */
public class MaxProduct {

    /*
    A unsorted array of integers is given; 
    you need to find the max product formed my multiplying three numbers
     */
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 20};
        //Output: 1200
        //Multiplication of 10, 6 and 20
        
        System.out.println(maxProductOfThree(arr, arr.length));
    }

    /*
    Find the max three number and product of these will be max
    | use k times quick sort
     */
    private static int maxProductOfThree(int[] arr, int n) {

        if (n < 3) {
            return -1;
        }

        //max
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        //min
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            } else {

                if (arr[i] > maxB) {
                    maxC = maxB;
                    maxB = arr[i];
                } else {
                    if (arr[i] > maxC) {
                        maxC = arr[i];
                    }

                }
            }
            //update min
            if (arr[i] < minA) {
                minB = minA;
                minA = arr[i];
            } else {

                if (arr[i] < minB) {
                    minB = arr[i];
                }
            }

        }
        return Math.max(maxA * maxB * maxC, maxA * minA * minB);

    }
}

package future.fry.practice.array;

/**
 *
 * @author ranjeet
 */
public class TargetString {

    /*
    * Given a Array for Strings in Sorted Order with null strings in between and a Target String, 
    * find wheather the target string is present or not.
     */
    public static void main(String[] args) {
        String[] arr = {"", "abc", "", "", "", "", "", "", "bcd", "ef", "", "xyz", ""};
        TargetString targetString = new TargetString();
        System.out.println(targetString.isPresent(arr, 0, arr.length - 1, "xyz"));


    }

    private boolean isPresent(String[] arr, int l, int h, String target) {

        //base condition
        if (l >= h) {
            return false;
        }

        int mid = nonEmptyIndex(arr, l, h, (l + h) / 2, 0);
        if (arr[mid].equals(target)) {
            return true;
        }

        //go left
        if (arr[mid].toCharArray()[0] > target.toCharArray()[0]) {
            return isPresent(arr, l, mid - 1, target);
        } else {
            return isPresent(arr, mid + 1, h, target);
        }

    }

    private int nonEmptyIndex(String[] arr, int l, int h, int mid, int d) {

        if (arr[mid] == null || arr[mid].isEmpty()) {
            if (mid - d >= l && arr[mid - d] != null && !arr[mid - d].isEmpty()) {
                return mid - d;
            }
            else {
                if (mid + d <= h && arr[mid + d] != null && !arr[mid + d].isEmpty()) {
                    return mid + d;
                }
            }

        } else {
            return mid;
        }

        return nonEmptyIndex(arr, l, h, mid, d + 1);

    }

}

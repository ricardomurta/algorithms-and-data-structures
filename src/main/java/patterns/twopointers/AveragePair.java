package patterns.twopointers;

public class AveragePair {
    /*
Multiple Pointers - averagePair
Write a function called averagePair.
Given a sorted array of integers and a target average,
determine if there is a pair of values in the array where the average of the pair equals the target average.
There may be more than one pair that matches the average target.
Bonus Constraints:
Time: O(N)
Space: O(1)
Sample Input:
averagePair([1,2,3],2.5) // true
averagePair([1,3,3,5,6,7,10,12,19],8) // true
averagePair([-1,0,3,4,5,6], 4.1) // false
averagePair([],4) // false
    * */
    public static void main(String[] args) {
        System.out.println(averagePair(new int[]{1,2,3},2.5f));
        System.out.println(averagePair(new int[]{1,3,3,5,6,7,10,12,19},8f));
        System.out.println(averagePair(new int[]{-1,0,3,4,5,6},4.1f));
        System.out.println(averagePair(new int[]{},4f));
    }

    public static boolean averagePair(int[] arr, float num) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            float avg = (float) (arr[left] + arr[right]) / 2;
            if (avg == num) {
                return true;
            } else if (avg < num) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}

package patterns.slidingwindow;

public class MaxSubarraySum {
    /*
Given an array of integers and a number, write a function called maxSubarraySum,
which finds the maximum sum of a subarray with the length of the number passed to the function.
Note that a subarray must consist of consecutive elements from the original array.
In the first example below, [100, 200, 300] is a subarray of the original array, but [100, 300] is not.
maxSubarraySum([100,200,300,400], 2) // 700
maxSubarraySum([1,4,2,10,23,3,1,0,20], 4)  // 39
maxSubarraySum([-3,4,0,-2,6,-1], 2) // 5
maxSubarraySum([3,-2,7,-4,1,-1,4,-2,1],2) // 5
maxSubarraySum([2,3], 3) // null
Constraints:
Time Complexity - O(N)
Space Complexity - O(1)
    * */
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{100,200,300,400}, 2));
    }

    public static Integer maxSubarraySum(int[] arr, int num) {
        if (arr.length < num) return null;
        int maxSum = 0, currentSum;

        for (int i = 0; i < num; i++) {
            maxSum += arr[i];
        }

        currentSum = maxSum;

        for (int i = num; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - num];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}

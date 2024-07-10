package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
                i     j  k
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
    * */
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return null;
        int i = 0, j = 1, k = 2;
        List<List<Integer>> result = new ArrayList<>();

        while (k < nums.length - 1) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
            k++;
        }
        while (j < nums.length - 2) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
            j++;
        }
        while (i < nums.length - 3) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
            i++;
        }
        return result;
    }
}

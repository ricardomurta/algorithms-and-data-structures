package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplePointer {
    public static void main(String[] args) {
        int[] arr1 = {-3,-3,-3,-3,3,3,3,6,7,7,9,9,9,9,9};
        int[] arr2 = {-9,-5,-3,3,5,6,7,7,9,9,9,9,9};
        System.out.println(countUnique(arr1));
        countSumOfZero(arr2).forEach(arr -> System.out.print(Arrays.toString(arr)));
    }

    public static int countUnique(int[] arr) {
        int i = 0, j = 1;

        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        return ++i;
    }

    public static List<int[]> countSumOfZero(int[] arr) {
        int i = 0, j = arr.length - 1;
        List<int[]> sumOfZeroList = new ArrayList<>();

        while (i < j) {
            if (arr[i] + arr[j] < 0) {
                i++;
            } else if (arr[i] + arr[j] > 0) {
                j--;
            } else if (arr[i] + arr[j] == 0) {
                int[] newArr = {arr[i], arr[j]};
                sumOfZeroList.add(newArr);
                i++;
                j--;
            }
        }
        return sumOfZeroList;
    }
}

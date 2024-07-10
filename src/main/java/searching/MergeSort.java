package searching;

import java.util.Arrays;

public class MergeSort {
    /*
    * O()
    * */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 53, 7, 28, -29, 420, 9, 1, 3, 239, 908, 1, 5, 1})));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int middle = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int index = 0, i = 0, j = 0;
        int[] mergedArray = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[index] = arr1[i];
                i++;
            } else {
                mergedArray[index] = arr2[j];
                j++;
            }
            index++;
        }
        while (i < arr1.length) {
            mergedArray[index] = arr1[i];
            i++;
            index++;
        }
        while (j < arr2.length) {
            mergedArray[index] = arr2[j];
            j++;
            index++;
        }
        return mergedArray;
    }
}

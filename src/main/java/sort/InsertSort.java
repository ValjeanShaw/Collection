package sort;

import java.util.Arrays;

/**
 * @author: xiaoran
 * @date: 2018-07-11 10:36
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 5, 67, 9, 54, 343, 7, 32, 5, 8, 65, 42};

        InsertSort insertSort = new InsertSort();
        insertSort.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}

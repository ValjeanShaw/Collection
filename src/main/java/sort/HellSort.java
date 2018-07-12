package sort;

import java.util.Arrays;

/**
 * @author: xiaoran
 * @date: 2018-07-11 11:42
 */
public class HellSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 5, 67, 9, 54, 343, 7, 32, 5, 8, 65, 42};
        HellSort hellSort = new HellSort();
        hellSort.hellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void hellSort(int[] array) {
        for (int gap = array.length >> 1; gap > 0; gap = gap >> 1) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j - gap >= 0 && array[j] < array[j - gap]) {
                    //插入排序采用交换法
                    int temp = array[j];
                    array[j] = array[j - gap];
                    array[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }
}

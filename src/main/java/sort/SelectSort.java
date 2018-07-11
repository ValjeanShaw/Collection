package sort;

import java.util.Arrays;

/**
 * @author: xiaoran
 * @date: 2018-07-11 10:04
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 5, 67, 9, 54, 343, 7, 32, 5, 8, 65, 42};

        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * 思路：遍历链表找出最小的值，往前放置
     * @param array
     */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = min +1; j < array.length; j++) {
                if(array[j] < array [min]){
                    int temp = array[j];
                    array[j] = array[min];
                    array[min] = temp;
                }
            }
        }
    }
}

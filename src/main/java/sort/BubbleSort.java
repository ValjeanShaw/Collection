package sort;

import java.util.Arrays;

/**
 * @author: xiaoran
 * @date: 2018-07-10 13:39
 * <p>
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 5, 67, 9, 54, 343, 7, 32, 5, 8, 65, 42};

        int[] array2 = {4, 6, 3, 5, 67, 9, 54, 343, 7, 32, 5, 8, 65, 42};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        bubbleSort.bubbleSortUp(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }


    /**
     * 正常情况下的冒泡排序
     * <p>
     * 按照从小到大排序
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        if (array == null) {
            array = null;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 鸡尾酒排序，冒泡排序的变种
     * 当情况好(数组大致有序)的时候，时间复杂度能接近 o(n)
     *
     * @param array
     */
    public void bubbleSortUp(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            //大数往后走，第一趟能确定最大的数字，排在最后，right --
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;
            //小数往前走，第一趟能能确定最小的数字，排在最前，left ++
            for (int j = right; j > left; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            left++;
        }
    }
}

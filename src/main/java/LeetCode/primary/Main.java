package LeetCode.primary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author: xiaoran
 * @date: 2018-07-30 14:40
 */
public class Main {

    public static void main(String[] args) {


//        int[] array = {7,1,4,5,3,6};
//        int[] array = {1,2,3,4,5};
        int[] array = {3,2,4};
        Main main = new Main();
        main.reverseString("hellojdsafdakfnkjdsnkfnkjdsanfkjdnaskjnkjdsnaf");
//        boolean flag = main.containsDuplicate(array);
//        System.out.println(flag);
//        main.twoSum(array,6);
    }

    /**
     * 从排序数组中删除重复项
     * <p>
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
     *
     * @param nums
     * @return
     */
    public int removeDuplicate(int[] nums) {
        int a = 0;
        int b = 1;
        while (b < nums.length) {
            if (nums[a] == nums[b]) {
                b++;
            } else {
                a++;
                nums[a] = nums[b];
                b++;
            }
        }
        return a + 1;
    }

    /**
     * 买卖股票的最佳时机
     * <p>
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 0;
        int sum = 0;
        while (low < (prices.length - 1) && (high < prices.length - 1)) {
            if (prices[low] >= prices[low + 1]) {
                low++;
            } else {
                high = low;
                while (high < prices.length - 1) {
                    if (prices[high] <= prices[high + 1]) {
                        high++;
                    } else {
                        break;
                    }
                }
                sum += prices[high] - prices[low];
                low = high;
            }
        }

        return sum;
    }

    /**
     * 旋转数组
     * <p>
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] arrays = new int[len];

        for (int i = 0; i < len; i++) {
            arrays[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = arrays[i];
        }
    }

    /**
     * 存在重复
     * <p>
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Node[] arrays = new Node[100];
        for (int i = 0; i < nums.length; i++) {
            //还得考虑负数
            int hashcode = Math.abs(nums[i]) % 100;
            if (arrays[hashcode] == null) {
                Node node = new Node();
                node.val = nums[i];
                arrays[hashcode] = node;
            } else {
                Node node = arrays[hashcode];
                while (node != null) {
                    if (node.val == nums[i]) {
                        return true;
                    }
                    node = node.next;
                }
                Node headNode = new Node();
                headNode.val = nums[i];
                headNode.next = node;
                arrays[hashcode] = headNode;
            }
        }
        return false;

    }

    class Node {
        int val;
        Node next;
    }


    /**
     * 只出现一次的数字
     *
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
     *
     * 要求时间复杂度为o(n)，空间复杂度 o(1)
     *
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        //foreach 更快一些
        for(int i : nums){
            num = num ^ i;
        }
        return num;
    }

    /**
     * [4,3,2,2]
     *
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
     *
     * 加1
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int low=0,high =0;
        while(high < nums.length){
            if(nums[high] != 0){
                nums[low++] = nums[high];
            }
            high++;
        }
        while(low < nums.length){
            nums[low++] = 0;
        }

    }

    /**
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
     *
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] < target){
                if(map.get(nums[i]) == null){
                    map.put(nums[i],i);
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            int now = nums[i];
            if(now < target){
                int gap = target - now;
                Integer obj = map.get(gap);
                if(obj !=null && obj != i){
                    if(i<obj){
                        result[0] = i;
                        result[1] =obj;
                    }else{
                        result[1] = i;
                        result[0] =obj;
                    }

                    return result;
                }
                map.put(now,0);
            }
        }
        return null;
    }


    /**
     * new String()
     * 要比
     * String.valueof()效率更高
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];
        for(int i=0,j=chars.length-1;i<chars.length;i++,j--){
            result[j]=chars[i];
        }

        return String.valueOf(result);
    }


}

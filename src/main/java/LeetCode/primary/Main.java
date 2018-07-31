package LeetCode.primary;

/**
 * @author: xiaoran
 * @date: 2018-07-30 14:40
 */
public class Main {

    public static void main(String[] args) {


//        int[] array = {7,1,4,5,3,6};
//        int[] array = {1,2,3,4,5};
        int[] array = {1, 2, 3, 2, 1};
        Main main = new Main();
        boolean flag = main.containsDuplicate(array);
        System.out.println(flag);
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
}

package LeetCode.primary;

/**
 * @author: xiaoran
 * @date: 2018-07-30 14:40
 */
public class Main {

    public static void main(String[] args) {


//        int[] array = {7,1,4,5,3,6};
//        int[] array = {1,2,3,4,5};
        int[] array = {5,4,3,2,1};
        Main main = new Main();
        int sum = main.maxProfit(array);
        System.out.println(sum);
    }

    /**
     *从排序数组中删除重复项
     *
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
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 0;
        int sum = 0;
        while (low < (prices.length - 1) && (high < prices.length -1)) {
            if (prices[low] >= prices[low + 1]) {
                low ++;
            }else{
                high = low;
                while (high < prices.length - 1) {
                    if(prices[high] <= prices[high+1]){
                        high ++;
                    }else{
                        break;
                    }
                }
                sum += prices[high] - prices[low];
                low = high;
            }
        }

        return sum;
    }
}

package leetcode.primary.string;

/**
 * @author: xiaoran
 * @date: 2018-09-12 18:55
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
//        main.reverseString("hellojdsafdakfnkjdsnkfnkjdsanfkjdnaskjnkjdsnaf");

//        int count = main.reverse((214748369));
//        System.out.println(count);

        String str = "yekbsxznylrwamcaugrqrurvpqybkpfzwbqiysrdnrsnbftvrnszfjbkbmrctjizkjqoxqzddyfnavnhqeblfmzqgsjflghaulbadwqsyuetdelujphmlgtmkoaoijypvcajctbaumeromgejtewbwqptotrorephegyobbstvywljboeihdliknluqdpgampjyjpinxhhqexoctysfdciqjbzilnodzoihihusxluqoayenluziobxiodrfdkinkzzozmxfezfvllpdvogqqtquwcsijwachefspywdgsohqtlquhnoecccgbkrzqcprzmwvygqwddnehhi";
        System.out.println(main.firstUniqChar(str));

    }


    /**
     * 反转字符串
     * <p>
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
     * <p>
     * new String()
     * 要比
     * String.valueof()效率更高
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];
        for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
            result[j] = chars[i];
        }

        return String.valueOf(result);
    }


    /**
     * 颠倒整数
     * <p>
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
     *
     *采用方法，一个模10，取余数，一个乘10
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
     *
     * 桶排序，适合于范围较小的数组
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]-'a']++;
        }
        for(int i=0;i<arr.length;i++){
            if(bucket[arr[i] - 'a'] == 1){
                return i;
            }
        }
        return 0;
    }
}

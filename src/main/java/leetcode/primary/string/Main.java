package leetcode.primary.string;

/**
 * @author: xiaoran
 * @date: 2018-09-12 18:55
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.reverseString("hellojdsafdakfnkjdsnkfnkjdsanfkjdnaskjnkjdsnaf");
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

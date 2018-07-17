package Base;

/**
 * @author: xiaoran
 * @date: 2018-07-17 15:44
 */
public class sort {
    public static void main(String[] args) {
        int[] a = new int[15];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 6;
        a[4] = 8;
        a[5] = 10;
        a[6] = 14;
        a[7] = 17;
        a[8] = 19;
        a[9] = 20;

        int[] b = {2,4,6,9,15};


        int high = a.length-1;
        int i = 9;
        int j = 4;

        while(high >i && i>0){
            if(a[i] > b[j]){
                a[high] = a[i];
                high --;
                i--;
            }else{
                a[high] = b[j];
                high --;
                j--;
            }
        }

        System.out.println(a);

    }
}

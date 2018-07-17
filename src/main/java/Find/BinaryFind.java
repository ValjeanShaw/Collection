package Find;

/**
 * @author: xiaoran
 * @date: 2018-07-17 15:49
 *
 *
 */
public class BinaryFind {
    public static void main(String[] args) {
        int[] array = {1,3,4,6,7,8,9,12,34,45,77,78};
        BinaryFind binaryFind = new BinaryFind();

        System.out.println(binaryFind.binaryFind(array,4));
    }

    /**
     * 二分查找
     * @param array
     * @param obj
     * @return
     */
    public int binaryFind(int[] array,int obj){
        int high = array.length-1;
        int low = 0;
        while(high > low){
            int mid = (high + low) >> 1;
            if(array[mid] == obj){
                return mid;
            }
            if(array[mid] > obj){
                high = mid - 1;
            }
            if(array[mid] < obj){
                low = mid + 1;
            }
        }
        return -1;
    }
}

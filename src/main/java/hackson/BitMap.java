package hackson;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * @author: xiaoran
 * @date: 2018-10-19 18:15
 */
public class BitMap {
    public static void main(String[] args)
    {
        Random random=new Random();

        BitSet bitSet=new BitSet(100000000);
        for(int i=0;i<10000000;i++)
        {
            int randomResult=random.nextInt(100000000);
            bitSet.set(randomResult);
        }
        System.out.println("产生的随机数有");

        System.out.println("0~1亿不在上述随机数中有"+bitSet.size());
        for (int i = 0; i < 100000000; i++)
        {
            if(!bitSet.get(i))
            {
                System.out.println(i);
            }
        }
    }
}

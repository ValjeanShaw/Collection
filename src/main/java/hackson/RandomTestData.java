package hackson;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * @author: xiaoran
 * @date: 2018-10-17 19:33
 */
public class RandomTestData {
//    public static void main(String[] args) throws IOException {
//        Long startTime = System.currentTimeMillis();
//        //创建目录
//        File dir = new File("/Users/xiaoran/logs/data");
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        //创建文件
//        File file = new File(dir, "test.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        //实例化RandomAccessFile对象
//        RandomAccessFile raf = new RandomAccessFile(file, "rw");
//
//        FileChannel fc = raf.getChannel();
//
//        long offset = 0;
//        long i = 100000L;
//        while(i > 0) {
//            byte[] bs = getRandomString().getBytes();
//            System.out.println(getRandomString());
//            int len = bs.length * 1000;
//            MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len );
//            for(int j = 0; j < 1000; j ++) {
//                mbuf.put(bs);
//            }
//            offset = offset + len;
//            i = i - 1000;
//        }
//
//
//        //操作结束后一定要关闭文件
//        raf.close();
//        Long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
//    }

//    public static void main(String[] args) {
//
//        for(int i=0;i<100;i++){
//            System.out.println(getRandomString());
//        }
//
//    }

    public static void main(String[] args) {

        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;

        try {

            //经过测试：ufferedOutputStream执行耗时:1,1，1 毫秒
            outSTr = new FileOutputStream(new File("/Users/xiaoran/logs/data/test.txt"));
            Buff = new BufferedOutputStream(outSTr);
            long begin0 = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                if(i % 1000 == 0){
                    System.out.println(i);
                }
                Buff.write(getRandomString().getBytes());
            }
            Buff.flush();
            Buff.close();
            long end0 = System.currentTimeMillis();
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 毫秒");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 得到一个随机数的串
     * @return
     */
    public static String getRandomString(){
        int len = 15;
        Long nanoTime = System.nanoTime();
        int startIndex = (int)(Math.random() * 10);
        Long id = Long.parseLong(nanoTime.toString().substring(5+startIndex,len));
        Long nanoTimeCount = System.nanoTime();

        int lenCount = 3;
        int startIndexCount = (int)(Math.random() * 3);
        Integer count = Integer.parseInt(nanoTimeCount.toString().substring(12+startIndexCount,12+lenCount));
        Random random1 = new Random();
        String month = (random1.nextInt(3)+1)+"";
        String day = (random1.nextInt(30)+1)+"";
        String singleData = id+", "+count+", "+"2018-"+month+"-"+day+"\n";
        return singleData;
    }
}

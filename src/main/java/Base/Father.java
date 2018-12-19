package Base;

/**
 * @author: xiaoran
 * @date: 2018-09-10 19:51
 */
public class Father {
    static{
        System.out.println("父类静态方法");
    }

    public Father(){
        System.out.println("父类构造方法");
    }

    public static void main(String[] args) {
        String str = "\",中国移动\"";
        String s = str.replaceAll("\"","\\\"");
        System.out.println(s);
    }

    public void print(){
        System.out.println("父类普通方法");
    }

}

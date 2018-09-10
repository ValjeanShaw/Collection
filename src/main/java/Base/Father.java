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

    public void print(){
        System.out.println("父类普通方法");
    }

}

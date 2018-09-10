package Base;

/**
 * @author: xiaoran
 * @date: 2018-09-10 19:52
 *
 *  继承过来的子类，在构造方法中，默认隐式调用 super()
 */
public class Son extends Father{
    static{
        System.out.println("子类静态方法");
    }

    public Son(){
        System.out.println("子类构造方法");
    }

    @Override
    public void print(){
        System.out.println("子类普通方法");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.print();

        System.out.println("----------");

        Father obj = new Son();
        obj.print();
    }
}

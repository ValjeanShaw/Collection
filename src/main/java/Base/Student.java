package Base;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: xiaoran
 * @date: 2018-07-15 17:33
 *
 * 集合排序
 *
 */
@Data
public class Student implements Comparable{
    private String name;
    private Integer age;
    private String sex;

    @Override
    public int compareTo(Object o) {
        System.out.println(this.age);
        int age = ((Student) o).age;
        System.out.println("this.age:"+age);
        int result = this.age - age;
        if(result < 0){
            return -1;
        }
        if(result > 0){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.age = 1;

        Student student1 = new Student();
        student1.age = 9;

        Student student2 = new Student();
        student2.age = 4;

        Student student3 = new Student();
        student3.age = 2;

        Student student4 = new Student();
        student4.age = 7;

        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);


        System.out.println();


        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });

    }
}

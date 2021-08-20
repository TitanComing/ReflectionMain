package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Create by peng on 2021/8/20.
 */
public class GetInfoByReflectionMain {
    public static void main(String[] args) throws Exception {
        Class<Student> stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("sex"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));

        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        //方法调用
        Method getGrade = stdClass.getDeclaredMethod("getGrade", int.class);
        getGrade.setAccessible(true);
        System.out.println(getGrade.invoke(new Student(), 1));

        //静态方法调用Integer.parseInt(String):调用实例变量的地方传个null
        Method m = Integer.class.getDeclaredMethod("parseInt", String.class);
        Integer n = (Integer) m.invoke(null,"123456");
        System.out.println(n);

        //构造方法
        Constructor<Person> constructor = Person.class.getConstructor(String.class);
        Person person = constructor.newInstance("zhangsan");
        System.out.println(person);







        Object p = new Person("xiao Ming");
        Class<?> c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value);
    }
}

class Student extends Person{
    public int score;
    private int grade;

    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return year;
    }

}

class Person {

    public String sex;

    private String name;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return "Person";
    }

}
package Reflection;

/**
 * Create by peng on 2021/8/20.
 */
public class ClassMain {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取一个class的Class实例
        //方法一：直接通过一个class的静态变量class获取：
        Class<String> cls1 = String.class;
        //方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取
        String s = "Hello";
        Class<? extends String> cls2 = s.getClass();
        //方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class<?> cls3 = Class.forName("java.lang.String");
    }
}

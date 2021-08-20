package Reflection;

public class SuperMain {
    public static void main(String[] args) throws Exception {
        //get superClass
        Class<Integer> i = Integer.class;
        Class<? super Integer> n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
        Class[] is = i.getInterfaces();
        for(Class c: is){
            System.out.println(c);
        }

        Object m = Integer.valueOf(123);
        boolean isDouble = m instanceof Double; // false
        boolean isInteger = m instanceof Integer; // true
        boolean isNumber = m instanceof Number; // true
        boolean isSerializable = m instanceof java.io.Serializable; // true


    }
}

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringDemo2 {
    private static final Integer KEY_EXIT = 1024;

    public static void main(String[] args) {
//        String s1 = new String("hello");
//        String s2 = "hello";
//        System.out.println(s1 == s2);// false
//        System.out.println(s1.equals(s2));// true


//        String s1 = new String("hello");
//        String s2 = new String("hello");
//        System.out.println(s1 == s2);// false
//        System.out.println(s1.equals(s2));// true
//
//        String s3 = new String("hello");
//        String s4 = "hello";
//        System.out.println(s3 == s4);// false
//        System.out.println(s3.equals(s4));// true
//
//        String s5 = "hello";
//        String s6 = "hello";
//        System.out.println(s5 == s6);// true
//        System.out.println(s5.equals(s6));// true


//        String s1 = "hello";
//        String s2 = "world";
//        String s3 = "helloworld";
//        System.out.println(s3 == s1 + s2);// false
//        System.out.println(s3.equals((s1 + s2)));// true
//        System.out.println(s3 == "hello" + "world");//true
//        System.out.println(s3.equals("hello" + "world"));// true

//        String s1 = "abc";
//        StringBuffer s2 = new StringBuffer(s1);
//        System.out.println(s1.equals(s2));

//        StringBuffer s3 = new StringBuffer("abc");
//        System.out.println(s3.equals("abc"));

//        String str9 = "a1";
//        String str10 = "a" + 1;
//        System.out.println(str9 == str10);

//        String string = "abccba ";
//        StringBuffer stringBuffer = new StringBuffer(string);
//        StringBuffer reverse = stringBuffer.reverse();
//        System.out.println(reverse.toString().equals(string));
//
//
//        String res = string.replaceAll("a", "");
//        System.out.println(res);


//        HashMap hashMap = new HashMap();
//        hashMap.put("abc", "111");
//        hashMap.put("efg", "222");
//        System.out.println(hashMap.size());

        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        System.out.println(s3 == s1 + s2);// false
        System.out.println(s3.equals((s1 + s2)));// true
        System.out.println(s3 == "hello" + "world");//true
        System.out.println(s3.equals("hello" + "world"));// true
//        char[] s = ss.toCharArray();
//           char[] p = ps.toCharArray();
//
//             int i = 0; // 主串的位置
//               int j = 0; // 模式串的位置
//           int[] next = getNext(ps);
//            while (i < s.length && j < p.length) {
//                   //①如果j=-1，或者当前字符匹配成功（即S[i]==P[j]），都令i++，j++
//                    if (j == -1 || s[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
//                           i++;
//                               j++;
//                        } else {
//                              //②如果j!=-1，且当前字符匹配失败（即S[i]!=P[j]），则令i不变，j=next[j]，j右移j-next[j]
//                             j = next[j];
//                          }
//                   }
//              if (j == p.length) {
//                       return i - j;
//                  } else {
//                       return -1;
//                   }
//           }
//


        int[] array = {2, 3, 1, 2, 2, 5, 6, 8, 2, 3, 2, 4, 2};

        HashMap<Integer, Integer> map = new HashMap<>();//第一个值为出现的数字，第二个值为出现的次数
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int temp = map.get(array[i]);
                map.put(array[i], temp + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Collection<Integer> count = map.values();
        int maxCount = Collections.max(count);
        int maxnum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                maxnum = entry.getKey();
            }
        }
        System.out.println("出现次数最多的数字为" + maxnum);
        System.out.println("改次数一共出现了" + maxCount + "次");


//        HashMap<String, Student> hashMap = new HashMap();
//        Student student = new Student(10, "wlp");
//        Student student1 = new Student(110, "w11lp");
//        Student student2 = new Student(120, "w22lp");
//        Student student3 = new Student(130, "w33lp");
//
//        hashMap.put("aa", student);
//        hashMap.put("bb", student1);
//        hashMap.put("cc", student2);
//        hashMap.put("dd", student3);
//
//
//
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//            System.out.println("key==" + key + "===value==" + val.toString());
//        }
        try {
//            Class stuClass2 = Student.class;
            Class clazz = Class.forName("Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
//            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象


            System.out.println("**********************所有公有构造方法*********************************");
            Constructor[] conArray = clazz.getConstructors();
            for (Constructor c : conArray) {
                System.out.println(c);
            }


            System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
            conArray = clazz.getDeclaredConstructors();
            for (Constructor c : conArray) {
                System.out.println(c);
            }

            System.out.println("*****************获取公有、无参的构造方法*******************************");
            Constructor con = clazz.getConstructor(null);
            //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            //2>、返回的是描述这个无参构造函数的类对象。

            System.out.println("con = " + con);


            System.out.println("******************获取私有构造方法，并调用*******************************");
            Object obj = con.newInstance();
            con = clazz.getDeclaredConstructor(char.class);
            System.out.println(con);
            //调用构造方法
            con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
            obj = con.newInstance('男');
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //1.获取Class对象
        Class stuClass = null;
        try {
            stuClass = Class.forName("Student");

            //2.获取字段
            System.out.println("************获取所有公有的字段********************");
            Field[] fieldArray = stuClass.getFields();
            for (Field f : fieldArray) {
                System.out.println(f);
            }
            System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
            fieldArray = stuClass.getDeclaredFields();
            for (Field f : fieldArray) {
                System.out.println(f);
            }
            System.out.println("*************获取公有字段**并调用***********************************");
            Field f = stuClass.getField("name");
            System.out.println(f);
            //获取一个对象
            Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
            //为字段设置值
            f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
            //验证
            Student stu = (Student) obj;
            System.out.println("验证姓名：" + stu.name);


            System.out.println("**************获取私有字段****并调用********************************");
            f = stuClass.getDeclaredField("phoneNum");
            System.out.println(f);
            f.setAccessible(true);//暴力反射，解除私有限定
            f.set(obj, "18888889999");
            System.out.println("验证电话：" + stu);


            f = stuClass.getDeclaredField("age");
            System.out.println(f);
            f.setAccessible(true);//暴力反射，解除私有限定
            f.set(obj, 20);
            System.out.println("age：" + stu);


            Method m = stuClass.getMethod("show1", String.class);
            System.out.println(m);
            //实例化一个Student对象
            obj = stuClass.getConstructor().newInstance();
            m.invoke(obj, "刘德华");
        } catch (Exception e) {
            e.printStackTrace();
        }


        int[] aaa = new int[]{2, 3, 0};
        System.out.print(let(aaa));


        System.out.println("invok3->" + StringDemo2.KEY_EXIT);
        Field field = null;
        try {
            field = StringDemo2.class.getDeclaredField("KEY_EXIT");

            field.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, 256);
            System.out.println("invok3-<" + StringDemo2.KEY_EXIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int let(int[] ar) {
        int len = ar.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += ar[i];
        }
        return len * (len + 1) / 2 - sum;
    }


}
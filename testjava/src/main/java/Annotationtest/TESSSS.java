package Annotationtest;

import java.lang.reflect.Method;

/**
 * Created by  wlp on 2018/6/22.
 */

public class TESSSS {


    public static void main(String[] args) {


        Test mTest = new Test();
        Class mTest_Class = mTest.getClass();

        // 2. 获取测试类Test的所有方法（通过数组存放）
        Method[] method = mTest_Class.getDeclaredMethods();


        // 3. 通过注解@Carson_Test 测试类中的方法

        // a. 遍历类中所有方法
        for (Method m : method) {
            // b. 只有被 @Carson_Test 标注过的方法才允许进行测试
            if (m.isAnnotationPresent(Carson_Test.class)) {
                try {
                    m.setAccessible(true);
                    // c. 通过反射调用测试类中的方法
                    m.invoke(mTest);
                    // d. 捕捉方法出现的异常 & 输出异常信息
                } catch (Exception e) {
                    System.out.println("Test类出现Bug了！！！");
                    System.out.println("出现Bug的方法：" + m.getName());
                    System.out.println("Bug类型：" + e.getCause().getClass().getSimpleName());
                    System.out.println("Bug信息：" + e.getCause().getMessage());

                }
            }
        }
    }

}

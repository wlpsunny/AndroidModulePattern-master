package inner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by  wlp on 2018/5/31.
 */

public class Circle {
    private int radius;

    public Circle(int radius) throws IndexOutOfBoundsException {
        this.radius = radius;

//        getDraw().draw();


    }

    private Draw getDraw() {


//        throw new IndexOutOfBoundsException("");
        return new Draw();
    }

    static class InnerClass {
    }

    public static int getDataByIndex(int index, int[] data) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        return data[index];
    }

    class Draw {
        public void draw() {

            radius = 4;
        }
    }

    class Sd extends Circle {
        public Sd(int radius) throws IndexOutOfBoundsException {
            super(radius);
        }
    }

    public static void main(String[] args) {

        Circle circle = new Circle(4);
        Draw draw = circle.new Draw();


        getDataByIndex(5, new int[4]);

        new Circle.InnerClass();

        new Thread(new Runnable() {
            @Override
            public void run() {

//                System.out.println(aa);

            }
        }).start();

    }

    public String openFile() {
        try {
            FileInputStream inputStream = new FileInputStream("d:/a.txt");
            int ch = inputStream.read();
            System.out.println("aaa");
            return "step1";
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return "step2";
        } catch (IOException e) {
            System.out.println("io exception");
            return "step3";
        } finally {
            System.out.println("finally block");
            return "finally";
        }


    }

    private void switchtest() {
        int i = 5;
        char aa = "ddd".charAt(0);
        byte a=new Byte("dd");
        switch (a) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
    }

}

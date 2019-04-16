package innerclass;

class Circle {
    private double radius = 0;

    public static void main(String[] args) {


        Circle.Bean2 b2 = new Circle.Bean2();
        Circle circle = new Circle(3);
        Draw draw = circle.new Draw();

    }

    public Circle(double radius) {
        this.radius = radius;
        getDrawInstance().drawSahpe();   //必须先创建成员内部类的对象，再进行访问


    }

    public void test(int b) {
        final int a = 10;
        new Thread() {
            @Override
            public void run() {
                System.out.println(a);
                System.out.println(radius);
            }

            ;
        }.start();
    }

    private Draw getDrawInstance() {
        return new Draw();
    }

    //静态
    static class Bean2 {
        public int J = 0;

    }

    private class Draw {     //成员

        public void drawSahpe() {


            System.out.println(radius);  //外部类的private成员

            //局部
            class Stud {


            }
        }
    }
}
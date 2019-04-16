public class ThreadLocalDemo {
    public ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    public ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    public ThreadLocal<Student> stuLocal = new ThreadLocal<Student>();


    public void set(Student student) {
        stuLocal.set(student);
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public Student getStu() {
        return stuLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalDemo test = new ThreadLocalDemo();


        test.set(new Student(10, "www"));
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println(test.getStu().toString());


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                test.set(new Student(20, "xxx"));
                System.out.println(test.getLong());
                System.out.println(test.getString());
                System.out.println(test.getStu().toString());
            }

            ;
        };
        thread1.start();
        thread1.join();

//        System.out.println(test.getLong());
//        System.out.println(test.getString());
    }

    public static class Student {
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
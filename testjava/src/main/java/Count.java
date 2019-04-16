class Count {
    public static int count = 0;
    //同步的静态方法
    public synchronized static void addCountS() {
        count++;
    }
    //同步的非静态方法
    public synchronized void addCount() {
        count++;
    }

    @Override
    public String toString() {
        return "Count =" + count;
    }

}

class _2MB_Data {
    public Object instance = null;
    private byte[] data = new byte[2 * 1024 * 1024];//用来占内存，测试垃圾回收
}

public class ReferenceGC {
    public static void main(String[] args) {
        _2MB_Data d1 = new _2MB_Data();
        _2MB_Data d2 = new _2MB_Data();
        d1.instance = d2;//1
        d2.instance = d1;//2
        d1 = null;
        d2 = null;
        System.gc();
    }
}
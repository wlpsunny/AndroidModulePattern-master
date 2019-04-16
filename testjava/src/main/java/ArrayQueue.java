class ArrayQueue<T> {
    private int SIZE = 10;

    private Object[] arr = new Object[SIZE];
    private int foot;

    public ArrayQueue() {
    }

    public boolean isEmpty() {
        return foot == 0;
    }


    public void putdata(T t) {
        arr[foot] = t;
        if (foot++ > arr.length) {
            Object[] array = new Object[arr.length + SIZE];
            for (int i = 0; i < arr.length; i++) {
                if (null != array[i]) {
                    array[i] = arr[i];
                } else {
                    break;
                }
            }
        }

    }


    public void put(T t) {
        arr[foot] = t;
        if (foot++ >= arr.length) {
            Object[] nArr = new Object[arr.length + SIZE];
            for (int i = 0; i < arr.length; i++) {
                if (null != arr[i]) {
                    nArr[i] = arr[i];
                } else {
                    break;
                }
            }
            arr = nArr;
        }
    }


    public void remove() {
        if (!isEmpty()) {
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
                arr[i + 1] = null;
            }
            foot--;
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    public int size() {
        return foot;
    }

    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i < foot && i >= 0) {
            return (T) arr[i];
        } else {
            throw new RuntimeException("下标为负数或越栈");
        }
    }

    public T getdata(int i) {

        if (i < foot && i > 0) {
            return (T) arr[i];
        } else {
            throw new RuntimeException("下标服务");
        }
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.put(10);
        arrayQueue.put(6);
        arrayQueue.put(11);


        for (int i = 0; i < arrayQueue.size(); i++) {
            System.out.println(arrayQueue.get(i));
        }


    }
}
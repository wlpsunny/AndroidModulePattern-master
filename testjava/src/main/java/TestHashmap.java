import java.util.HashMap;

/**
 * Created by  wlp on 2018/6/6.
 */

public class TestHashmap {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Item item = new Item("wlp", 20);
        Item item1 = new Item("gggg", 30);
        map.put(item1, item1);
        map.put(item, item);
        item1.name = "xxx";

        People p1 = new People("Jack", 12);
        System.out.println(p1.hashCode());

        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
        hashMap.put(p1, 1);

        System.out.println(hashMap.get(new People("Jack", 12)));
//        Item va = (Item) map.get(item1);
//
//        System.out.println(va.name + map.size());
    }


    private static class Item {
        private String name;
        private int age;

        public Item(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.age;
        }
    }

    static class People {
        private String name;
        private int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return name.hashCode() * 37 + age;
        }

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            return this.name.equals(((People) obj).name) && this.age == ((People) obj).age;
        }
    }

}

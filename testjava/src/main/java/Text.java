import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Text {
    public static void main(String[] args) {


        String res = "abcbbbhhhhhhhhhhhbccaaaaabcabhsdfsdfca";
        char[] arr = res.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : arr) {
            if (hashMap.containsKey(c)) {
                Integer num = hashMap.get(c);
                hashMap.put(c, num + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            System.out.println(next.getKey() + "====" + next.getValue());
        }

//        Set<Character> characters = hashMap.keySet();
//
//
//
//
//        for (char s : characters) {
//            System.out.println(s + "====" + hashMap.get(s));
//        }


    }


}

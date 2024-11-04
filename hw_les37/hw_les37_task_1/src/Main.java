//Andrii Kryshtapovych cohort53

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a" , "Jack");
        map.put("b", "Micke");

        System.out.println("До swap: " + map);
        swapValue(map, "a", "b");
        System.out.println("Після swap: " + map);

        swapValue(map, "a", "c");
        System.out.println("Після swap з відсутнім ключем: " + map);


    }

    public static void swapValue(Map<String, String> map, String key1, String key2) {

        map.putIfAbsent(key1, "");
        map.putIfAbsent(key2, "");

        map.replace(key1, map.put(key2, map.get(key1)));
    }

}
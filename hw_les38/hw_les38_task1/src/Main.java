//Andrii Kryshtapovych cohort 53e
/*
Дан лист строк, нужно получить Map<String, Boolean>, где ключ - строка,
значение - true, если строка встретилась более одного раза, иначе false
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> str = List.of("jack","john","nick","jack","mike","ann","john");

        System.out.println(checkStringDuplicates(str));
    }
    public static Map<String, Boolean> checkStringDuplicates(List<String> str){
        // Проверка на null
        if (str == null) {
            return new HashMap<>();  // Возвращаем пустую карту, если список null
        }

        Map<String, Integer> newMap = new HashMap<>();
        for (String s : str){
            newMap.put(s, newMap.getOrDefault(s, 0) + 1);
        }

        Map<String, Boolean> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : newMap.entrySet()){
            result.put(entry.getKey(), entry.getValue() > 1);
        }

        return result;
    }

}
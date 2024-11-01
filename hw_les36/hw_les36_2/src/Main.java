//Andrii K. cohort 53
/*
Написать метод, проверяющий что в слове все буквы уникальные (не повторяются).
Строка состоит только из букв, без пробелов. При решении использовать HashSet.

public static boolean isUnique (String word)
Hello -> false
World -> true
 */


import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello -> " + isUnique("Hello"));
        System.out.println("World -> " + isUnique("World"));
        System.out.println("Lessons -> " + isUnique("Lessons"));
        System.out.println("Result -> " + isUnique("Result"));


    }

    public static boolean isUnique(String word) {
        Set<Character> uniqChar = new HashSet<>();

        for (char x : word.toCharArray()) {
            if (!uniqChar.add(x)) {
                return false;
            }
        }
        return true;
    }
}
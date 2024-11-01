//Andrii Kryshtapovych cohort
/*
Дан List строк содержащий имена пользователей.
Ваша задача написать метод, который позволит удалить из списка n имен, начиная с заданной позиции i.
Пример:
{Jack, John, Slava, Nick, Lena, Mark} удаляем 2 имени (n=2), начиная с индекса (i=1) получаем: {Jack, Nick, Lena, Mark}
{Jack, John, Slava, Nick, Lena, Mark} удаляем 3 имени (n=3), начиная с индекса (i=4) получаем: {Jack, John, Slava, Nick}
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Jack", "John", "Slava", "Nick", "Lena", "Mark"));



        System.out.println(deleteNames(new ArrayList<>(names),1,2));
        System.out.println(deleteNames(new ArrayList<>(names),4,3));


    }

    public static List<String> deleteNames(List<String> names, int i, int n) {
        if (i < 0 || i >= names.size() || n <= 0) {
            return names; // Если индексы или n некорректные, вернуть начальный список
        }
        Iterator<String> iterator = names.iterator();
        int currentIndex = 0;
        int deleteCount = 0;

        // Перемещаемся до позиции i
        while (iterator.hasNext() && currentIndex < i) {
            iterator.next();
            currentIndex++;
        }

        // Удаляем n элементов, начиная с индекса i
        while (iterator.hasNext() && deleteCount < n) {
            iterator.next();
            iterator.remove();
            deleteCount++;
        }
        return names;
    }


}
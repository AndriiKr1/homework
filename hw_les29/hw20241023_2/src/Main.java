/*
# 2
Допустим, у вас есть List целых чисел. Напишите метод, который формирует List,
 в котором будут индексы цифр из первого листа, которые больше некоторого заданного значения
Например: дано 10,12,7,6,12,89 значение 33  результат: 1, 5
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =List.of(10,12,7,6,12,89);
        int filter = 33;

        List<Integer> filterIndices = getIndicesNumbersGreaterThan(numbers,filter);
        System.out.println("Індекси чисел більше " + filter + ": " + filterIndices);
    }

    public static List<Integer> getIndicesNumbersGreaterThan(List<Integer> numbers, int filter) {
        List<Integer> indices = new ArrayList<>();
        for (int i=0; i< numbers.size(); i++) {
            if (numbers.get(i) > filter) {
                indices.add(i);
            }
        }
        return indices;
    }
}


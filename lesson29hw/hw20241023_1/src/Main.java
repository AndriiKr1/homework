/*
# 1
   Допустим, у вас есть List целых чисел. Напишите метод, который формирует List,
   в котором будут цифры из первого листа, которые больше некоторого заданного значения
   Например: дано 10,12, 7, 6,12,89 значение 33  результат: 12, 89
*/

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =List.of(10,12,7,6,12,89);
        int filter = 33;

        List<Integer> filterNumbers = filterNumbersGreaterThan(numbers,filter);
        System.out.println("Числа більше " + filter + ": " + filterNumbers);
    }

    public static List<Integer> filterNumbersGreaterThan(List<Integer> numbers, int filter) {
        List<Integer> result = new ArrayList<>();
        if (numbers==null){
            return result;
        }
        for (Integer number : numbers) {
            if (number > filter) {
                result.add(number);
            }
        }
        return result;
    }
}
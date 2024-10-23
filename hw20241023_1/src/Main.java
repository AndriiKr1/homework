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

        List<Integer> numbers = new ArrayList<>();
            numbers.add(10);
            numbers.add(12);
            numbers.add(7);
            numbers.add(6);
            numbers.add(12);
            numbers.add(89);
            numbers.add(54);


        int filter = 33;
        List<Integer> result = new ArrayList<>();
        for(int number : numbers){
            if(number > filter){
                result.add(number);
            }
        }
        System.out.println("Числа більше " + filter + ": " +result);
    }
}
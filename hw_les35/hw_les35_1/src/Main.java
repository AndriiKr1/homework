//Andrii Kryshtapovych cohort

/*Есть два списка одинаковой длины с числами. Написать функцию, которая вернет список с элементами True или False,
 где значение на i-том месте зависит от того, равны ли элементы двух списков под номером i.
 Например, {1, 2, 3, 4} и {5, 2, 3, 8} вернет {False, True, True, False}
*/
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> myList1 = List.of(1, 2, 3, 4,5);
        List<Integer> myList2 = List.of(5, 2, 3, 8,5);

        List<Boolean> resultList = myList(myList1,myList2);
        System.out.println(resultList);

    }

    public static List<Boolean> myList(List<Integer> myList1,List<Integer> myList2){
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i< myList1.size(); i++){
            result.add(myList1.get(i).equals(myList2.get(i)));
        }
        return result;
    }
}
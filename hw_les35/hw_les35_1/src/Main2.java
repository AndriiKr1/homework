import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        List<Integer> myList1 = List.of(1, 2, 3, 4, 5);
        List<Integer> myList2 = List.of(5, 2, 3, 8, 5);

        List<Boolean> resultList = myList(myList1,myList2);
        System.out.println(resultList);
    }

    public static List<Boolean> myList(List<Integer> myList1, List<Integer> myList2) {
        List<Boolean> result = new ArrayList<>();

        Iterator<Integer> iterator1 = myList1.iterator();
        Iterator<Integer> iterator2 = myList2.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            boolean isEqual = iterator1.next().equals(iterator2.next());
            result.add(isEqual);
        }

        while (iterator1.hasNext()) {
            iterator1.next();
            result.add(false);
        }
        while (iterator2.hasNext()) {
            iterator2.next();
            result.add(false);
        }

        return result;
    }

}
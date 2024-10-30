import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();
        list.add("jack");
        list.add("nick");
        list.add("oleg");
        list.add("john");
        list.add("petr");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("Размер: " + list.size());

        MyLinkedList<Person> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(new Person("Jack", 15));
        myLinkedList.add(new Person("Nick", 16));
        myLinkedList.add(new Person("John", 17));

        //myLinkedList.print();

        System.out.println(myLinkedList);
        System.out.println("------------------");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("qwer");
        stringMyLinkedList.add("sgsd");
        stringMyLinkedList.add("dfsd");
        stringMyLinkedList.add("ölmöl");
        stringMyLinkedList.add("ycxc");

        System.out.println(stringMyLinkedList);

        MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.add(1);
        myLinkedList1.add(6);
        myLinkedList1.add(7);
        myLinkedList1.add(4);
        myLinkedList1.add(1);
        myLinkedList1.add(9);

        System.out.println(myLinkedList1);

        MyLinkedList<Integer> intList = MyLinkedList.of(828, 3, 2, 1, 45, 2, 2);
        MyLinkedList<String> stringList = MyLinkedList.of("qwe", "gmkl", "fgdf");
        System.out.println(intList);
        System.out.println("-----------------------------------------------------------------");

        MyLinkedList<String> list3 = new MyLinkedList<>();

        list3.add("Первый элемент");
        list3.add("Второй элемент");
        list3.add("Третий элемент");
        System.out.println(list3);
        System.out.println("--------------------------------");
        // Вставляем элемент на позицию 1
        list3.add1(1, "Новый элемент на позиции 1");

        // Вставляем элемент на начало списка
        list3.add1(0, "Новый элемент в начале");

        // Вставляем элемент в конец списка
        list3.add1(list.size(), "Новый элемент в конце");

        System.out.println(list3);

    }

}
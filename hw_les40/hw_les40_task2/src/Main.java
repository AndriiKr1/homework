import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("12345", "Berlin", "Alexanderplatz", "15B");
        Address address2 = new Address("67890", "Munich", "Maximilianstrasse", "20C");
        Address address3 = new Address("54321", "Hamburg", "Reeperbahn", "5A");
        Address address4 = new Address("98765", "Frankfurt", "Zeil", "30D");

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Hans", "Müller", "hans.mueller@example.com", "111-222-3333", address1));
        personList.add(new Person("Julia", "Schmidt", "julia.schmidt@example.com", "444-555-6666", address2));
        personList.add(new Person("Peter", "Fischer", "peter.fischer@example.com", "777-888-9999", address3));
        personList.add(new Person("Anna", "Weber", "anna.weber@example.com", "000-111-2222", address4));

        List<String> fullNames = processPersonList(personList, p -> p.getfName() + " " + p.getlName());
        System.out.println(fullNames);

        List<String> emails = processPersonList(personList, person -> person.getEmail());
        System.out.println("Emails: " + emails);

        List<String> phones = processPersonList(personList, person -> person.getPhone());
        System.out.println("Phones: " + phones);

        List<String> addresses = processPersonList(personList, person -> person.getAddress().toString());
        System.out.println("Addresses: " + addresses);

    }

    public static List<String> processPersonList(List<Person> personList, PersonTransformer transformer) {
        List<String> resultList = new ArrayList<>();
        for (Person person : personList) {
            resultList.add(transformer.personToString(person));
        }
        return resultList;
    }
}
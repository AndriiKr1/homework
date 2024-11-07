import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class MainTest {

    Address address1 = new Address("12345", "Berlin", "Hauptstrasse", "10A");
    Address address2 = new Address("67890", "Munich", "Bahnhofstrasse", "20B");
    Address address3 = new Address("10112", "Hamburg", "Schillerstrasse", "3C");
    Address address4 = new Address("54321", "Frankfurt", "Goethestrasse", "5D");

    List<Person> personList = new ArrayList<>(List.of(
            new Person("Hans", "Müller", "hans.mueller@example.com", "123-456-7890", address1),
            new Person("Klara", "Schmidt", "klara.schmidt@example.com", "987-654-3210", address2),
            new Person("Peter", "Schneider", "peter.schneider@example.com", "456-123-7890", address3),
            new Person("Lena", "Meier", "lena.meier@example.com", "321-654-9870", address4)
    ));

    @Test
    void fullNameListTest() {
        List<String> expectedList = new ArrayList<>(List.of("Hans Müller", "Klara Schmidt", "Peter Schneider", "Lena Meier"));
        List<String> actualResult = Main.processPersonList(personList, person -> person.getfName() + " " + person.getlName());
        Assertions.assertIterableEquals(expectedList, actualResult);
    }

    @Test
    void emailListTest() {
        List<String> expectedList = new ArrayList<>(List.of("hans.mueller@example.com", "klara.schmidt@example.com", "peter.schneider@example.com", "lena.meier@example.com"));
        List<String> actualResult = Main.processPersonList(personList, person -> person.getEmail());
        Assertions.assertIterableEquals(expectedList, actualResult);
    }

    @Test
    void phoneListTest() {
        List<String> expectedList = new ArrayList<>(List.of("123-456-7890", "987-654-3210", "456-123-7890", "321-654-9870"));
        List<String> actualResult = Main.processPersonList(personList, person -> person.getPhone());
        Assertions.assertIterableEquals(expectedList, actualResult);
    }

    @Test
    void addressListTest() {
        List<String> expectedList = new ArrayList<>(List.of(
                "Hauptstrasse 10A, Berlin, 12345",
                "Bahnhofstrasse 20B, Munich, 67890",
                "Schillerstrasse 3C, Hamburg, 10112",
                "Goethestrasse 5D, Frankfurt, 54321"
        ));
        List<String> actualResult = Main.processPersonList(personList, person -> person.getAddress().toString());
        Assertions.assertIterableEquals(expectedList, actualResult);
    }
}
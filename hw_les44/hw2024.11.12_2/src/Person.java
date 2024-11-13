import java.util.Objects;

public class Person {
    private String lName;
    private String fName;
    private int age;
    private String city;

    public Person(String lName, String fName, int age, String city) {
        this.lName = lName;
        this.fName = fName;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s",fName,lName,age,city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return age == person.age && Objects.equals(lName, person.lName) && Objects.equals(fName, person.fName) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(lName);
        result = 31 * result + Objects.hashCode(fName);
        result = 31 * result + age;
        result = 31 * result + Objects.hashCode(city);
        return result;
    }
}

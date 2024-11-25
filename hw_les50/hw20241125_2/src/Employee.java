public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d: %s",id,name);
        //     return  String.format("Працівник: {ID: %d, Ім'я: %s}", id, name);
    }
}

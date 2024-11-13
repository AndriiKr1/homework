import java.util.List;

public class Programmer {
    private String name;
    private String city;
    private List<Task> tasks;

    public Programmer(String name, String city, List<Task> tasks) {
        this.name = name;
        this.city = city;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
      return   String.format("Programmer: %-15s | City: %-10s | Number of tasks: %d",
                name, city, tasks.size());
    }
}
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Integer> rates;
    private double avg;

    public Student(String name, List<Integer> rates) {
        this.name = name;
        this.rates = rates;
        this.avg = avgRate();
    }

    // Метод для обчислення середнього значення оцінок
    public double avgRate() {
        int sum = 0;
        for (int rate : rates) {
            sum += rate;
        }
        return sum / rates.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rates=" + rates +
                ", avg=" + avg +
                '}';
    }

    // Реалізація інтерфейсу Comparable для сортування за середнім балом
    @Override
    public int compareTo(Student o) {
        return Double.compare(avg, o.avgRate());
    }
}
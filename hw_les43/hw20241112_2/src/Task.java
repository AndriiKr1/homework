public class Task {
    private int number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Task(int number, String description, String status, int daysInProcessing) {
        this.number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    public int getDaysInProcessing() {
        return daysInProcessing;
    }

    @Override
    public String toString() {
        return String.format("Task {Number=%d, Description='%s', Status='%s', Days in Processing=%d}",
                number, description, status, daysInProcessing);
    }
}

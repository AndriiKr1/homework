public class Programmer {
    private String name;
    private String status; // "доступний", "зайнятий", "недоступний"

    public Programmer(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String doWork(String taskMsg) throws Exception {
        if (status.equals("зайнятий")) {
            throw new Exception("Програміст " + name + " зайнятий.");
        }
        if (status.equals("недоступний")) {
            throw new Exception("Програміст " + name + " недоступний.");
        }
        return  name + ": " + taskMsg.toUpperCase();
    }
}
public class Programmer {
    private String name;
    private String status;

    public Programmer(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String doWork(String taskMsg) throws ProgrammerBusyException, ProgrammerUnavailableNowException {
        if (status.equals("зайнятий")) {
            throw new ProgrammerBusyException("Программіст зайнятий.");
        }
        if (status.equals("не доступний")) {
            throw new ProgrammerUnavailableNowException("Программіст не доступний.");
        }
        return taskMsg.toUpperCase();
    }
}

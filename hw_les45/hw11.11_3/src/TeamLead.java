import java.util.List;

public class TeamLead {
    private String name;
    private String status; // "доступний", "недоступний"
    private List<Programmer> team;

    public TeamLead(String name, String status, List<Programmer> team) {
        this.name = name;
        this.status = status;
        this.team = team;
    }

    public String doTask(String taskMsg) throws TeamLeadUnavailableNowException, AllProgrammersAreBusyNowException {
        if (status.equals("недоступний")) {
            throw new TeamLeadUnavailableNowException("TeamLead " + name + " зараз недоступний.");
        }

        for (Programmer programmer : team) {
            try {
                if (programmer.getStatus().equals("доступний")) {
                    return programmer.doWork(taskMsg);
                }
            } catch (Exception e) {
                System.out.println("Повідомлення: " + e.getMessage());
            }
        }

        throw new AllProgrammersAreBusyNowException("Усі програмісти зараз зайняті.");
    }
}

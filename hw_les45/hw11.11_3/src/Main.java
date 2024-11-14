import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Programmer programmer1 = new Programmer("Василько", "зайнятий");
        Programmer programmer2 = new Programmer("Марія", "доступний");
        Programmer programmer3 = new Programmer("Олексій", "недоступний");


        List<Programmer> team = new ArrayList<>();
        team.add(programmer1);
        team.add(programmer2);
        team.add(programmer3);


        TeamLead teamLead = new TeamLead("Олена", "доступний", team);

        try {
            String result = teamLead.doTask("Розробити новий функціонал");
            System.out.println("Програміст " + result);
        } catch (TeamLeadUnavailableNowException e) {
            System.out.println("Чому TeamLead не на місці?");
        } catch (AllProgrammersAreBusyNowException e) {
            System.out.println("Нам не вистачає програмістів!");
        }
    }
}

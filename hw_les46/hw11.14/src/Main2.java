import Exceptions.AllProgrammersAreBusyNowException;
import Exceptions.TeamLeadUnavailableNowException;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");

        TeamLead teamLead = new TeamLead("Lena", TeamLeadStatus.AVAILABLE, List.of(jack, john));
        System.out.println(teamLead);

        teamLead.setStatus(TeamLeadStatus.AVAILABLE);
        jack.setBusy();
        john.setAvailable();


        teamLead.setStatus(TeamLeadStatus.AVAILABLE);
        try{
            System.out.println(teamLead.doTask("java exceptions are easy"));
        }catch (AllProgrammersAreBusyNowException e){
            System.out.println("Нам не хватает программистов");
        }catch (TeamLeadUnavailableNowException e){
            System.out.println("Тимлид на перекуре");
        }
    }
}

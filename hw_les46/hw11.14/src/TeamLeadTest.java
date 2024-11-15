import Exceptions.AllProgrammersAreBusyNowException;
import Exceptions.TeamLeadUnavailableNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class TeamLeadTest {

    @Test
    void doTask_iftTeamLeadUnavailable_throwTeamLeadUnavailableNowException() {
        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");
        TeamLead teamLead = new TeamLead("Lena", TeamLeadStatus.UNAVAILABLE, List.of(jack, john));

        Assertions.assertThrows(TeamLeadUnavailableNowException.class, () -> teamLead.doTask("java exceptions are easy"));
    }

    @Test
    void doTask_ifAllProgrammersAreBusy_AllProgrammersAreBusyNowException() {
        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");
        jack.setBusy();
        john.setBusy();
        TeamLead teamLead = new TeamLead("Lena", TeamLeadStatus.AVAILABLE, List.of(jack, john));

        Assertions.assertThrows(AllProgrammersAreBusyNowException.class, () -> teamLead.doTask("java exceptions are easy"));
    }

    @Test
    void doTask_ifOneProgrammerIsAvailable() {
        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");
        jack.setBusy();
        john.setAvailable();
        TeamLead teamLead = new TeamLead("Lena", TeamLeadStatus.AVAILABLE, List.of(jack, john));

        String expectedResult = "JAVA EXCEPTIONS ARE EASY";
        String actualResult = teamLead.doTask("java exceptions are easy");
        Assertions.assertEquals(expectedResult,actualResult);
    }

}
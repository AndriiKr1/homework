import Exceptions.ProgrammerBusyException;
import Exceptions.ProgrammerUnavailableNowException;

public class Programmer {

    private String name;
    private ProgrammerStatus status;


    public Programmer(String name) {
        this.name = name;
        this.status = ProgrammerStatus.AVAILABLE;
    }

    public void setAvailable() {
        this.status = ProgrammerStatus.AVAILABLE;
    }

    public void setUnAvailable() {
        this.status = ProgrammerStatus.UNAVAILABLE;
    }

    public void setBusy() {
        this.status = ProgrammerStatus.BUSY;
    }

    @Override
    public String toString() {
        return name + "(" + status + ")";
    }

    public String doWork(String msg) {
        if (status.equals(ProgrammerStatus.UNAVAILABLE)) {
            throw new ProgrammerUnavailableNowException();
        }
        if (status.equals(ProgrammerStatus.BUSY)) {
            throw new ProgrammerBusyException();
        }
        if (msg == null) {
            return "";
        }
        return msg.toUpperCase();
    }
}

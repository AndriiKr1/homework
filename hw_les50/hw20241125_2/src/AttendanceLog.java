import java.time.LocalDateTime;

public class AttendanceLog {
    private int id;
    private int employeeId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public AttendanceLog(int id, int employeeId, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.employeeId = employeeId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return String.format("%d: %d: %s %s", id, employeeId, checkIn, checkOut);
                /*
                        return String.format(
                        "Журнал відвідувань: {ID запису: %d, ID працівника: %d, Час входу: %s, Час виходу: %s}",
                        logId,
                        employeeId,
                        checkInTime.format(formatter),
                        checkOutTime.format(formatter)
               );
               */
    }
}

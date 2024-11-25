import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class WorkTimeCalc {

    private static final int WORK_DAY_HOURS = 8; // Стандартна тривалість робочого дня
    private static final LocalDateTime WORK_START_TIME = LocalDateTime.of(2023, 1, 1, 9, 0); // Початок робочого дня

    // Загальний відпрацьований час за поточний місяць
    public static Duration calculateTotalTimeForCurrentMonth(int employeeId, List<AttendanceLog> logs) {
        LocalDate now = LocalDate.now();
        return calculateTotalTimeForMonth(employeeId, logs, now.getYear(), now.getMonthValue());
    }

    // Загальний відпрацьований час за вказаний місяць
    public static Duration calculateTotalTimeForMonth(int employeeId, List<AttendanceLog> logs, int year, int month) {
        return logs.stream()
                .filter(log -> log.getEmployeeId() == employeeId &&
                        log.getCheckIn().getYear() == year &&
                        log.getCheckIn().getMonthValue() == month)
                .map(log -> Duration.between(log.getCheckIn(), log.getCheckOut()))
                .reduce(Duration.ZERO, Duration::plus);
    }

    // Переробки за вказаний інтервал дат
    public static List<String> calculateOvertimes(int employeeId, List<AttendanceLog> logs, LocalDate startDate, LocalDate endDate) {
        return logs.stream()
                .filter(log -> log.getEmployeeId() == employeeId &&
                        !log.getCheckIn().toLocalDate().isBefore(startDate) &&
                        !log.getCheckOut().toLocalDate().isAfter(endDate))
                .map(log -> {
                    Duration workedHours = Duration.between(log.getCheckIn(), log.getCheckOut());
                    long overtime = workedHours.toHours() - WORK_DAY_HOURS;
                    return overtime > 0 ? String.format("Дата: %s, Переробка: %d год.",
                            log.getCheckIn().toLocalDate(), overtime) : null;
                })
                .filter(overtime -> overtime != null)
                .collect(Collectors.toList());
    }

    // Запізнення за вказаний інтервал дат
    public static List<String> calculateLateness(int employeeId, List<AttendanceLog> logs, LocalDate startDate, LocalDate endDate) {
        return logs.stream()
                .filter(log -> log.getEmployeeId() == employeeId &&
                        !log.getCheckIn().toLocalDate().isBefore(startDate) &&
                        !log.getCheckOut().toLocalDate().isAfter(endDate))
                .map(log -> {
                    Duration lateness = Duration.between(WORK_START_TIME.toLocalTime(), log.getCheckIn().toLocalTime());
                    return lateness.isNegative() ? null :
                            String.format("Дата: %s, Запізнення: %d хв.",
                                    log.getCheckIn().toLocalDate(), lateness.toMinutes());
                })
                .filter(late -> late != null)
                .collect(Collectors.toList());
    }
}


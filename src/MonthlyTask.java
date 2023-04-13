import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) {
        super(title, description, taskType, firstDate);
    }

    @Override
    public boolean checkOccurrence(LocalDateTime requestedDate) {
        return getFirstDate().getDayOfMonth() == (requestedDate.getDayOfMonth());
    }
}

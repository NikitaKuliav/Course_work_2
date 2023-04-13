import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) {
        super(title, description, taskType, firstDate);
    }

    @Override
    public boolean checkOccurrence(LocalDateTime requestedDate) {
        return getFirstDate().getDayOfWeek().equals(requestedDate.getDayOfWeek());
    }
}

import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) {
        super(title, description, taskType, firstDate);
    }

    @Override
    public boolean checkOccurrence(LocalDateTime requestedDate) {
        return true;
    }
}

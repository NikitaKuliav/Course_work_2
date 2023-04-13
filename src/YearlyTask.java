import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) {
        super(title, description, taskType, firstDate);
    }

    @Override
    public boolean checkOccurrence(LocalDateTime requestedDate) {
        return getFirstDate().getDayOfMonth() == requestedDate.getDayOfMonth() && getFirstDate().getMonth() == requestedDate.getMonth();
    }
}

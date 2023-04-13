import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private String title;
    private String description;
    private final TaskType taskType;
    private final LocalDateTime firstDate;
    private static Integer counter = 1;
    private final Integer id;

    public Task(String title, String description, TaskType taskType, LocalDateTime firstDate) {
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.firstDate = firstDate;
        id = counter++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public LocalDateTime getFirstDate() {
        return firstDate;
    }

    public Integer getId() {
        return id;
    }
    public abstract boolean checkOccurrence(LocalDateTime localDateTime);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return title.equals(task.title) && description.equals(task.description) && taskType.equals(task.taskType) && firstDate.equals(task.firstDate) && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, taskType, firstDate, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "заголовок '" + title + '\'' +
                ", описание = '" + description + '\'' +
                ", тип задачи = " + taskType +
                ", повторяемость = " + firstDate +
                ", id = " + id +
                '}';
    }
}

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {
    private static final Map<Integer, Task> actualTasks = new HashMap<>();

    public static void addTask(Scanner scanner) {

        try {
            scanner.nextLine();
            System.out.println("Введите название задачи: ");
            String title = Validator.stringChecker(scanner.nextLine());
            System.out.println("Введите описание задачи");
            String description = Validator.stringChecker(scanner.nextLine());
            System.out.println("Введите тип задачи: 0 - Рабочая, 1 - Личная");
            TaskType taskType = TaskType.values()[scanner.nextInt()];
            System.out.println("Введите повторяемость задачи: 0 - Однократная, 1 - Ежедневная, 2 - Еженедельная, 3 - Ежемесячная, 4 - Ежегодная");
            int occurrence = scanner.nextInt();
            System.out.println("Введите дату dd.MM.yyyy HH:mm");
            scanner.nextLine();
            createEvent(scanner, title, description, taskType, occurrence);


        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createEvent(Scanner scanner, String title, String description, TaskType taskType, int occurrence) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Task task;
            try {
                task = createTask(occurrence, title, description, taskType, eventDate);
                System.out.println("Создана задача " + task);
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Введенная дата неправильного формата, введите заново");
            createEvent(scanner, title, description, taskType, occurrence);
        }
    }

    private static Task createTask(int occurrence, String title, String description, TaskType taskType, LocalDateTime localDateTime) throws IncorrectArgumentException {
        return switch (occurrence) {
            case 0 -> {
                Task oneTimeTask = new OneTimeTask(title, description, taskType, localDateTime);
                actualTasks.put(oneTimeTask.getId(), oneTimeTask);
                yield oneTimeTask;
            }
            case 1 -> {
                Task dailyTask = new DailyTask(title, description, taskType, localDateTime);
                actualTasks.put(dailyTask.getId(), dailyTask);
                yield dailyTask;
            }
            case 2 -> {
                Task weeklyTask = new WeeklyTask(title, description, taskType, localDateTime);
                actualTasks.put(weeklyTask.getId(), weeklyTask);
                yield weeklyTask;
            }
            case 3 -> {
                Task monthlyTask = new MonthlyTask(title, description, taskType, localDateTime);
                actualTasks.put(monthlyTask.getId(), monthlyTask);
                yield  monthlyTask;
            }
            case 4 -> {
                Task yearlyTask = new YearlyTask(title,description,taskType,localDateTime);
                actualTasks.put(yearlyTask.getId(), yearlyTask);
                yield yearlyTask;
            }
            default -> null;
        };

    }
    public static void printActualTasks() {
        for (Task task : actualTasks.values()) {
            System.out.println(task);
        }
    }
    public static void deleteTask(Scanner scanner){
        System.out.println("Текущие задачи: \n");
        printActualTasks();
        try {
            System.out.println("Для удаления задачи введите её ID \n");
            int id = scanner.nextInt();
            if (actualTasks.containsKey(id)) {
                actualTasks.remove(id);
                System.out.println("Задача с ID " + id + " удалена.");
            } else {
                throw new TaskNotFoundException();
            }
        } catch (TaskNotFoundException e){
            e.printStackTrace();
            System.out.println("Задача не найдена");
        }
    }
}

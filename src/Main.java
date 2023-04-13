import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Выберите пункт меню: ");
                printMenu();
                if (scanner.hasNext()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            TaskService.addTask(scanner);
                            break;
                        case 2:
                            TaskService.deleteTask(scanner);
                            break;
                        case 3:
                            TaskService.printActualTasks();
                            break;
                        case 0:
                            break label;

                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка");
                }
            }
        }

    }
    private static void printMenu() {
        System.out.println("""
                1. Добавить задачу
                2. Удалить задачу
                3. Распечатать текущие задачи
                """);
    }
}
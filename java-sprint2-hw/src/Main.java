import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();

            int cmd = scanner.nextInt();
            if (cmd == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (cmd == 2) {
                stepTracker.changeStepGoal(scanner);
            } else if (cmd == 3) {
                stepTracker.printStatistic();
            } else if (cmd == 4) {
                return;
            } else {
                System.out.println("Такой команды нет!");
            }
        }
    }

    static void printMenu() {
        System.out.println("1. Ввести количество шагов за определенный день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за опеределенный месяц");
        System.out.println("4. Выход");
    }
}

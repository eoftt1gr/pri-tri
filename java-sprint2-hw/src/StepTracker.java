import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void changeStepGoal(Scanner scan) {
        System.out.println("Введите значение цели шагов в день: ");
        goalByStepsPerDay = scan.nextInt();
        if(goalByStepsPerDay < 1) {
            System.out.println("Введите значение больше 0!");
            goalByStepsPerDay = 10000;
            return;
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Такого месяца нет!");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Такого дня нет!");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Введите число больше 0");
            return;
        }
        MonthData monthData = monthToData[month-1];
        monthData.days[day-1] = steps;
        monthToData[month-1] = monthData;
        System.out.println("Данные сохранены!");

    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Такого месяца нет!");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Количество пройденных шагов по дням:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println("Сумма шагов за месяц: " + sumSteps + ".\n");
        System.out.println("Максимальное количество пройденных шагов за месяц: " + monthData.maxSteps() + "\n");
        System.out.println("Среднее количество пройденных шагов за месяц: " + (sumSteps / 30) + ".\n");
        System.out.println("За месяц пройденно: " + converter.convertToKm(sumSteps) + "км.\n");
        System.out.println("Калорий сожженно: " + converter.convertStepsToKilocalories(sumSteps) + "ккал.\n");
        System.out.println("Лучшая серия за месяц: " + monthData.bestSeries(goalByStepsPerDay) + ".\n");
    }
}

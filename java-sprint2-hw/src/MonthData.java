public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + ". " + days[i] + " шагов.");
        }
    }

    int sumStepsFromMonth() {
        int sumOfSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumOfSteps += days[i];
        }

        return sumOfSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length ; i++) {
            if(maxSteps < days[i])
                maxSteps = days[i];
        }

        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
           if(days[i] >= goalByStepsPerDay) {
               currentSeries++;
               if (currentSeries > finalSeries) {
                   finalSeries = currentSeries;
               }
           } else {
               currentSeries = 0;
           }
        }
        return finalSeries;
    }
}

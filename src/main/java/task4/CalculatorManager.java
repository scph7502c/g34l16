package task4;

import java.util.List;

public class CalculatorManager {
    public static void performCalculations(List<Integer> numbers) {
        SumCalculator sumCalculator = new SumCalculator();
        AverageCalculator averageCalculator = new AverageCalculator();

        sumCalculator.calculate(numbers);
        sumCalculator.run();

        int sumResult = sumCalculator.getSum();

        averageCalculator.calculate(numbers);
        averageCalculator.setSumResult(sumResult);

        Thread averageThread = new Thread(averageCalculator);
        averageThread.start();

        try {
            averageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\nWyniki:");
        System.out.println("Suma: " + sumResult);
        System.out.println("Średnia: " + averageCalculator.getAverage());
    }
}
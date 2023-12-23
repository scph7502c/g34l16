package task4;

import java.util.List;

class AverageCalculator implements Calculator {
    private double average;
    private List<Integer> numbers;
    private int sumResult;

    @Override
    public void calculate(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        if (numbers.isEmpty()) {
            System.out.println("Brak liczb do obliczenia średniej.");
            return;
        }

        double size = numbers.size();
        double sum = (double) sumResult;
        average = sum / size;
    }

    public void setSumResult(int sumResult) {
        this.sumResult = sumResult;
    }

    public double getAverage() {
        return average;
    }
}
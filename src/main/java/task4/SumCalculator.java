package task4;

import java.util.List;


class SumCalculator implements Calculator {
    private int sum;
    private List<Integer> numbers;

    @Override
    public void calculate(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        sum = numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public int getSum() {
        return sum;
    }
}
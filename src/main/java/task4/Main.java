package task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> inputNumbers;

        while (true) {
            inputNumbers = InputHandler.getInputNumbers();

            if (inputNumbers.isEmpty()) {
                break;
            }

            CalculatorManager.performCalculations(inputNumbers);
            System.out.println("\nMożesz teraz wprowadzić nowe liczby.");
        }

    }
}
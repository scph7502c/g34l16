package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InputHandler {
    public static List<Integer> getInputNumbers() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNumbers = new ArrayList<>();

        System.out.println("Wprowadź liczby całkowite (aby zakończyć, wpisz 'exit'): ");

        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {

                System.exit(0);
            }

            String[] numbersArray = input.trim().split("\\s+");

            for (String str : numbersArray) {
                try {
                    int num = Integer.parseInt(str);
                    inputNumbers.add(num);
                } catch (NumberFormatException e) {
                    if (!str.isEmpty()) {
                        System.out.println("To nie jest liczba całkowita. Wpisz poprawne dane.");
                    }
                }
            }

            if (!inputNumbers.isEmpty()) {
                return inputNumbers;
            }
        }
    }
}

/**
 * Author: Nils Olivier
 * Date: 2024-02-26
 * Course: DD1380
 */

import java.util.Scanner;

/**
 * The BaseMultiplication class performs multiplication of two numbers in a
 * given base.
 */
public class BaseMultiplication {
    /**
     * The main method reads input from the user and performs the multiplication.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int base = sc.nextInt();
            int outputBase = sc.nextInt();
            String firstNumber = sc.next();
            String secondNumber = sc.next();

            long firstProduct = calculateProduct(base, firstNumber);
            long secondProduct = calculateProduct(base, secondNumber);
            long multiplicationResult = firstProduct * secondProduct;

            String resultInBaseM = Long.toString(multiplicationResult, outputBase).toUpperCase();
            System.out.println(resultInBaseM);
        }
    }

    /**
     * Calculates the product of a number in the given base.
     *
     * @param base   The base of the number.
     * @param number The number to calculate the product of.
     * @return The product of the number in the given base.
     */
    public static long calculateProduct(int base, String number) {
        long result = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                result = result * base + (c - '0');
            } else {
                result = result * base + (c - 'A' + 10);
            }
        }

        return result;
    }
}
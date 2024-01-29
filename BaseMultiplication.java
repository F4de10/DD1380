import java.util.Scanner;

/**
 * This class represents a program that calculates the product of two numbers
 * represented in a given base and converts the result to another base.
 */
public class BaseMultiplication {

    /**
     * The main method of the program.
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer N = sc.nextInt();
        Integer M = sc.nextInt();
        String A = sc.next();
        String B = sc.next();
        sc.close();

        long X = calculateProduct(N, A);
        long Y = calculateProduct(N, B);
        long C = X * Y;

        String D = Long.toString(C, M).toUpperCase();
        System.out.println(D);
    }

    /**
     * Calculates the product of a number represented in a given base.
     * 
     * @param N The base of the number.
     * @param A The number to calculate the product for.
     * @return The product of the number.
     */
    public static long calculateProduct(Integer N, String A) {
        long result = 0;

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (Character.isDigit(c)) {
                result = result * N + (c - '0');
            } else {
                result = result * N + (c - 'A' + 10);
            }
        }

        return result;
    }
}


/**
 * Author: Nils Olivier
 * Date: 2024-02-26
 * Course: DD1380
 */

import java.util.*;

/**
 * This class generates all permutations of a given string and prints them in
 * lexicographic order.
 */
public class Permutations {

    /**
     * The main method of the program.
     * It reads an input string, sorts it, generates all permutations, and prints
     * them.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        String inputString = readInput();
        inputString = sortString(inputString);

        Set<String> permutations = new TreeSet<>(); // Use TreeSet to automatically sort the permutations
        permute(0, inputString, permutations);

        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    /**
     * Reads a string from the user's input.
     *
     * @return The string entered by the user.
     */
    static String readInput() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextLine();
        }
    }

    /**
     * Generates all permutations of a string using backtracking.
     *
     * @param currentIndex The current index in the string.
     * @param inputString  The input string.
     * @param permutations The set to store the generated permutations.
     */
    static void permute(int currentIndex, String inputString, Set<String> permutations) {
        if (currentIndex == inputString.length() - 1) {
            permutations.add(inputString);
            return;
        }

        for (int j = currentIndex; j < inputString.length(); j++) {
            char[] temp = inputString.toCharArray();
            temp = swap(temp, currentIndex, j);
            permute(currentIndex + 1, String.valueOf(temp), permutations);
            swap(temp, currentIndex, j); // backtrack to restore the original order
        }
    }

    /**
     * Sorts a string in lexicographic order.
     *
     * @param inputString The input string to be sorted.
     * @return The sorted string.
     */
    static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    /**
     * Swaps two characters in a character array.
     *
     * @param charArray   The character array.
     * @param firstIndex  The index of the first character to swap.
     * @param secondIndex The index of the second character to swap.
     * @return The character array with the characters swapped.
     */
    static char[] swap(char[] charArray, int firstIndex, int secondIndex) {
        char temp = charArray[firstIndex];
        charArray[firstIndex] = charArray[secondIndex];
        charArray[secondIndex] = temp;
        return charArray;
    }
}
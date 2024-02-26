import java.util.*;

/**
 * The Permutations class generates all permutations of a given string and
 * prints them in lexicographic order.
 */
public class Permutations {
    /**
     * The main method reads a string from the user, generates all permutations of
     * the string, and prints them.
     * It uses a recursive approach to generate permutations and a TreeSet to
     * automatically sort them.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        s = sortString(s);

        Set<String> permutations = new TreeSet<>(); // Use TreeSet to automatically sort the permutations
        permute(0, s, permutations);

        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    /**
     * Recursive method to generate all permutations of a string.
     *
     * @param i            The current index in the string.
     * @param s            The string to permute.
     * @param permutations The set to store the permutations.
     */
    static void permute(int i, String s, Set<String> permutations) {
        if (i == s.length() - 1) {
            permutations.add(s);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            char[] temp = s.toCharArray();
            temp = swap(temp, i, j);
            permute(i + 1, String.valueOf(temp), permutations);
            swap(temp, i, j); // backtrack to restore the original order
        }
    }

    /**
     * Sorts a string in lexicographic order.
     *
     * @param inputString The string to sort.
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
     * @param s The character array.
     * @param i The index of the first character to swap.
     * @param j The index of the second character to swap.
     * @return The character array with the swapped characters.
     */
    static char[] swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return s;
    }
}
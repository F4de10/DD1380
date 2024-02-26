
/**
 * Author: Nils Olivier
 * Date: 2024-02-26
 * Course: DD1380
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class finds the most common substring of length n in a given string.
 * It uses a lookup table and a map to store the substrings and their counts.
 * The most common substring is determined based on its count and
 * lexicographical order.
 */
public class MostCommonStringV2 {
    private static final String ORDER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int LOOKUP_SIZE = 128;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer n = sc.nextInt();
            String s = sc.next();
            System.out.println(findMostCommonSubstring(s, n));
        }
    }

    private static String findMostCommonSubstring(String s, int n) {
        String currentString = "";
        String maxString = "";
        int maxCount = 0;

        int[] lookup = new int[LOOKUP_SIZE];
        for (int i = 0; i < ORDER.length(); i++) {
            lookup[ORDER.charAt(i)] = i;
        }

        Map<String, Integer> substringCounts = new HashMap<>();

        for (int i = n; i <= s.length(); i++) {
            currentString = s.substring(i - n, i);

            int count = substringCounts.getOrDefault(currentString, 0) + 1;
            substringCounts.put(currentString, count);

            if (count > maxCount) {
                maxString = currentString;
                maxCount = count;
            } else if (count == maxCount) {
                for (int j = 0; j < currentString.length(); j++) {
                    if (lookup[currentString.charAt(j)] < lookup[maxString.charAt(j)]) {
                        maxString = currentString;
                        break;
                    } else if (lookup[currentString.charAt(j)] > lookup[maxString.charAt(j)]) {
                        break;
                    }
                }
            }
        }

        return maxString;
    }
}
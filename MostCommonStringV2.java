import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostCommonStringV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        String s = sc.next();

        String currentString = "";
        String maxString = "";
        int maxCount = 0;

        // Create a lookup table
        String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int[] lookup = new int[128];
        for (int i = 0; i < order.length(); i++) {
            lookup[order.charAt(i)] = i;
        }

        // Create a map to store the substrings and their counts
        Map<String, Integer> substringCounts = new HashMap<>();

        // Iterate through the string, starting at the nth character
        for (int i = n; i <= s.length(); i++) {
            currentString = s.substring(i - n, i);

            // add currentString to the map with a value of 1 if it's not already in the
            // map, or increment its count by 1 if it is."
            int count = substringCounts.getOrDefault(currentString, 0) + 1;
            substringCounts.put(currentString, count);

            // Update maxString if currentString has a higher count
            if (count > maxCount) {
                maxString = currentString;
                maxCount = count;
            } else if (count == maxCount) {
                // Compare the two strings if they have the same count
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
        sc.close();

        System.out.println(maxString);
    }
}

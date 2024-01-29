import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostCommonStringV1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        String s = sc.next();

        String maxString = "z";
        String currentString = "";

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
            substringCounts.put(currentString, substringCounts.getOrDefault(currentString, 0) + 1);

            // if the currentString has the same count as the maxString, compare the two
            if (substringCounts.get(currentString) == substringCounts.getOrDefault(maxString, 0)) {
                for (int j = 0; j < currentString.length(); j++) {
                    if (lookup[currentString.charAt(j)] < lookup[maxString.charAt(j)]) {
                        maxString = currentString;
                        break;
                    } else if (lookup[currentString.charAt(j)] > lookup[maxString.charAt(j)]) {
                        break;
                    }
                }

                // if the currentString has a higher count than the maxString, set maxString to
                // currentString
            } else if (substringCounts.get(currentString) > substringCounts.getOrDefault(maxString, 0)) {
                maxString = currentString;
            }
        }
        sc.close();
        System.out.println(maxString);
    }
}

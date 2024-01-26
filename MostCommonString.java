import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostCommonString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        String s = sc.next();
        if (n > s.length()) {
            n = s.length();
        }

        String maxString = "0";
        String currentString = "";

        // Create a lookup table
        String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int[] lookup = new int[128];
        for (int i = 0; i < order.length(); i++) {
            lookup[order.charAt(i)] = i;
        }

        Map<String, Integer> substringCounts = new HashMap<>();

        for (int i = n; i <= s.length(); i++) {
            currentString = s.substring(i - n, i);
            substringCounts.put(currentString, substringCounts.getOrDefault(currentString, 0) + 1);
            if ((substringCounts.get(currentString) > substringCounts.getOrDefault(maxString, 0))
                    || (substringCounts.get(currentString) == substringCounts.getOrDefault(maxString, 0))
                            && lookup[currentString.charAt(0)] < lookup[maxString.charAt(0)]) {
                maxString = currentString;
            }
        }

        sc.close();
        System.out.println(maxString);
    }
}

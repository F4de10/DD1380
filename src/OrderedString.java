import java.util.Scanner;

public class OrderedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int currentLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= s.charAt(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }
        }

        System.out.println("Length of the shortest sorted substring: " + currentLength);
    }
}




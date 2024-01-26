import java.util.Scanner;

public class OrderedString {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    int maxLength = 1;
    int currentLength = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) >= s.charAt(i - 1)) {
        currentLength++;
      } else {
        if (currentLength > maxLength) {
          maxLength = currentLength;
        }
        currentLength = 1;
      }
    }

    if (currentLength > maxLength) {
      maxLength = currentLength;
    }

    System.out.println("Length of the longest sorted substring: " + maxLength);
  }
}

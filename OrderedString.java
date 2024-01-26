import java.util.Scanner;

public class OrderedString {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    int maxLength = 1;
    int currentLength = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) > s.charAt(i - 1)) {
        currentLength++;
      } else {
        if (currentLength > maxLength) {
          maxLength = currentLength;
        }
        if (s.charAt(i) <= s.charAt(i - 1)) {
          currentLength = 1;
        }
      }
    }

    sc.close();
    System.out.println(maxLength);
  }
}


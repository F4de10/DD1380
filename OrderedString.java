import java.util.Scanner;

public class OrderedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int maxLength = 1;
		int currentLength = 1;
		String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		for (int i = 1; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				currentLength = 0;
				continue;
			}
			if (order.indexOf(s.charAt(i)) > order.indexOf(s.charAt(i - 1))) {
				currentLength++;
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}
			} else {
				currentLength = 1;
			}
		}
		sc.close();
		System.out.println(maxLength);
	}
}

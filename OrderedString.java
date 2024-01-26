import java.util.Scanner;

public class OrderedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int maxLength = 1;
		int currentLength = 1;
		String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		// Create a lookup table
		int[] lookup = new int[128];
		for (int i = 0; i < order.length(); i++) {
			lookup[order.charAt(i)] = i;
		}

		for (int i = 1; i < s.length(); i++) {
			if (lookup[s.charAt(i)] < lookup[s.charAt(i - 1)]) {
				currentLength = 1;

			} else {
				currentLength++;
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}
			}
		}
		sc.close();
		System.out.println(maxLength);
	}
}

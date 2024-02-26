
/**
 * Author: Nils Olivier
 * Date: 2024-02-26
 * Course: DD1380
 */

import java.util.Scanner;

/**
 * The OrderedString class represents a program that finds the length of the
 * longest ordered substring in a given string.
 * The program reads a string from the user and prints the length of the longest
 * ordered substring.
 */

public class OrderedString {
	private static final String ORDER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int LOOKUP_SIZE = 128;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s = sc.nextLine();
			System.out.println(findLongestOrderedSubstring(s));
		}
	}

	private static int findLongestOrderedSubstring(String s) {
		int maxLength = 1;
		int currentLength = 1;

		// Create a lookup table
		int[] lookup = new int[LOOKUP_SIZE];
		for (int i = 0; i < ORDER.length(); i++) {
			lookup[ORDER.charAt(i)] = i;
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

		return maxLength;
	}
}
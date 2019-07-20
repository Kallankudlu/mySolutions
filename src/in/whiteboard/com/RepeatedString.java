/**
 * 
 */
package in.whiteboard.com;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author athreya.ks
 *
 */
public class RepeatedString {

	/**
	 * @param args
	 */
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);
		System.out.println(result);

		scanner.close();
	}

	static long repeatedString(String str, long n) {
		/* Found out # of times 'a' appears in our String */
		int wordAs = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				wordAs++;
			}
		}

		long completeWords = n / str.length();
		long remainingLetters = n % str.length();
		long totalAs = completeWords * wordAs;

		/* Count up the remaining 'a' characters */
		for (int i = 0; i < remainingLetters; i++) {
			if (str.charAt(i) == 'a') {
				totalAs++;
			}
		}

		return totalAs;
	}
}

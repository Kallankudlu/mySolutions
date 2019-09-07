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
public class RecursiveDigitSum {

	static int superDigit(String n, int k) {
		n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
		return (n.length() > 1) ? superDigit(n, 1) : Character.getNumericValue(n.charAt(0));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		String n = nk[0];

		int k = Integer.parseInt(nk[1]);

		int result = superDigit(n, k);
		System.out.println(result);
		scanner.close();
	}
}

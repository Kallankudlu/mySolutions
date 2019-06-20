/**
 * 
 */
package in.whiteboard.com;

import java.util.Scanner;

/**
 * @author athreya.ks
 *
 *         Consider a staircase of size : n = 4
 * 
 *            # 
 *           ## 
 *          ### 
 *         ####
 * 
 *         Observe that its base and height are both equal to , and the image is
 *         drawn using # symbols and spaces. The last line is not preceded by
 *         any spaces.
 * 
 *         Write a program that prints a staircase of size .
 */

public class StairCase {

	/**
	 * @param args
	 */
	static void staircase(int n) {
		
		int spaceCnt = 0;
		for (int i = 0; i < n; i++) {
			spaceCnt = n - (i + 1);
			System.out.print(new String(new char[spaceCnt]).replace("\0", " ")
					+ new String(new char[n - spaceCnt]).replace("\0", "#") + "\n");
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}

}

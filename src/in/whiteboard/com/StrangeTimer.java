/**
 * 
 */
package in.whiteboard.com;

import java.util.Scanner;

/**
 * @author athreya.ks
 *
 */
public class StrangeTimer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong(), n = 2;
		while (3 * (n - 1) < t)
			n = 2 * n;
		System.out.println((3 * (n - 1) - t + 1));
	}
	/*
	 * // Complete the strangeCounter function below. static long
	 * strangeCounter(long t) { long n= 2; while (3 * (n - 1) < t) n = 2 * n;
	 * return (3 * (n - 1) - t + 1); }
	 * 
	 * private static final Scanner scanner = new Scanner(System.in);
	 * 
	 * public static void main(String[] args) {
	 * 
	 * long t = scanner.nextLong();
	 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	 * 
	 * long result = strangeCounter(t);
	 * 
	 * scanner.close(); }
	 */
}

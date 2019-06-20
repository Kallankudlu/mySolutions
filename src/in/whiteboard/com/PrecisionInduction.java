/**
 * 
 */
package in.whiteboard.com;

import java.util.Scanner;

/**
 * @author athreya.ks
 *
 */
public class PrecisionInduction {

	/**
	 * @param args
	 */

	private static void plusMinus(int[] arr) {
		// TODO Auto-generated method stub
		float positive = 0, negative = 0, zeros = 0;
		for (int i : arr) {
			if (i > 0) {
				positive++;
			} else if (i < 0) {
				negative++;
			} else {
				zeros++;
			}
		}
		divide(positive, arr.length);
		divide(negative, arr.length);
		divide(zeros, arr.length);
	}

	private static void divide(float a, float b) {

		System.out.println(String.format("%.6f", a / b));

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;

		int[] arr = new int[n];
		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);
	}

}

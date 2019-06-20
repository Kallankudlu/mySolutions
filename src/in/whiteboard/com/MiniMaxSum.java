/**
 * 
 */
package in.whiteboard.com;

import java.util.Scanner;

/**
 * @author athreya.ks
 * 
 * Input : 1 2 3 4 5
 * output : 10 14
 * 
 *
 */
public class MiniMaxSum {

	static void miniMaxSum(int[] arr) {
		int maxValue = Integer.MIN_VALUE;
		long min = 0, max = 0, sum = 0;
		min = arr[0];
		max = min;
		sum = min;
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.print((sum - max) + " " + (sum - min));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}

}

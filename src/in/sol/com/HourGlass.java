package in.sol.com;

import java.util.Arrays;
import java.util.Scanner;

public class HourGlass {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		int sum[] = new int[16];
		int h = 0;

		for (int m = 0; m < 6; m++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int n = 0; n < 6; n++) {
				int arrItem = Integer.parseInt(arrRowItems[n]);
				arr[m][n] = arrItem;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					sum[h] = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
							+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
					h++;
				}
			}
			Arrays.sort(sum);
			System.out.println(sum[15]);

		}
		scanner.close();
	}
}

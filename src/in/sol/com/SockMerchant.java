package in.sol.com;

import java.util.HashMap;
import java.util.Scanner;

public class SockMerchant {
	static int sockMerchant(int n, int[] ar) {
		int matchingPairs = 0;
		HashMap<Integer, Integer> matched = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (matched.containsKey(ar[i]) && matched.get(ar[i]).equals(new Integer(1))) {
				matched.put(ar[i], 0);
				matchingPairs++;
				continue;
			}
			matched.put(ar[i], 1);
		}
		return matchingPairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();

		int[] ar = new int[n];

		// String[] arItems = scanner.nextLine().split(" ");
		Integer[] arItems = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		for (int i = 0; i < n; i++) {
			int arItem = arItems[i];
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);
		System.out.println(result);

		scanner.close();
	}
}

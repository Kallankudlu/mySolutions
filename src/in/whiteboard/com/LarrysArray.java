/**
 * 
 */
package in.whiteboard.com;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author athreya.ks
 *
 *         Larry has been given a permutation of a sequence of natural numbers
 *         incrementing from as an array. He must determine whether the array
 *         can be sorted using the following operation any number of times:
 * 
 *         Choose any 3 consecutive indices and rotate their elements in such a
 *         way that ABC -> BCA -> CAB -> ABC. 
 *         For example, if : A = {1,6,5,2,4,3}
 *         
 *         A		rotate 
 *		[1,6,5,2,4,3]	[6,5,2]
 *		[1,5,2,6,4,3]	[5,2,6]
 *		[1,2,6,5,4,3]	[5,4,3]
 *		[1,2,6,3,5,4]	[6,3,5]
 *		[1,2,3,5,6,4]	[5,6,4]
 *		[1,2,3,4,5,6]
 *
 *		YES
 *
 *
 */
public class LarrysArray {

	// Complete the larrysArray function below.
	static boolean solve(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int index = find(A, i + 1);

			while (index >= i + 2) {
				A[index] = A[index - 1];
				A[index - 1] = A[index - 2];
				A[index - 2] = i + 1;

				index -= 2;
			}

			if (index == i + 1) {
				if (index == A.length - 1) {
					return false;
				}

				A[index] = A[index + 1];
				A[index + 1] = A[index - 1];
				A[index - 1] = i + 1;
			}
		}
		return true;
	}

	static int find(int[] a, int target) {
		for (int i = 0;; i++) {
			if (a[i] == target) {
				return i;
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = 6;

		for (int tItr = 0; tItr < t; tItr++) {

			int[] A = new int[6];

			String[] AItems = scanner.nextLine().split(" ");
			//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < 6; i++) {
				int AItem = Integer.parseInt(AItems[i]);
				A[i] = AItem;
			}

			System.out.println(solve(A) ? "YES" : "NO");
		}

		scanner.close();
	}
	

}

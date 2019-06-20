/**
 * 
 */
package in.whiteboard.com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author athreya.ks
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static int diagonalDifference(List<List<Integer>> arr, int n) {
		// Write your code here
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < n; i++) {
			leftSum += arr.get(i).get(i);
			rightSum += arr.get(i).get(n - i - 1);
		}
		return Math.abs(leftSum - rightSum);
	}

	public static void main(String[] args) {

		int n = 3;

		List<List<Integer>> arr = new ArrayList<>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		Integer a1 = 11;
		Integer a2 = 2;
		Integer a3 = 4;
		Integer a4 = 4;
		Integer a5 = 5;
		Integer a6 = 6;
		Integer a7 = 10;
		Integer a8 = 8;
		Integer a9 = -12;

		list1.add(a1);
		list1.add(a2);
		list1.add(a3);
		arr.add(list1);
		list2.add(a4);
		list2.add(a5);
		list2.add(a6);
		arr.add(list2);
		list3.add(a7);
		list3.add(a8);
		list3.add(a9);
		arr.add(list3);

		int result = Solution.diagonalDifference(arr, n);
		System.out.println("---------------------------");
		System.out.println(result);
	}

}

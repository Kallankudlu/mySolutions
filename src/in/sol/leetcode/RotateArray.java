/**
 * 
 */
package in.sol.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author athreya.ks
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5};
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		/*rotate(array, k);
		bubbleSortRotate(array,k);*/
		reversalRotate(array, k);
		//nitish(array, k);
	}

	public static void rotate(int[] arr, int k) {
		if (k > arr.length)
			k = k % arr.length;

		int[] result = new int[arr.length];

		for (int i = 0; i < k; i++) {
			result[i] = arr[arr.length - k + i];
		}
		int j = 0;
		for (int i = k; i < arr.length; i++) {
			result[i] = arr[j];
			j++;
		}
		System.arraycopy(result, 0, arr, 0, arr.length);
		for (int i : result) {
			System.out.print(i + ",");
		}
	}

	public static void bubbleSortRotate(int[] arr, int order) {
		if (arr == null || order < 0)
			throw new IllegalArgumentException("Argument Exception!");
		for (int i = 0; i < order; i++) {
			for (int j = arr.length; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
	}

	public static void reversalRotate(int[] arr, int order) {
		order = order % arr.length;
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal Exception");
		}

		int a = arr.length - order;

		reverse(arr, 0, a - 1);
		reverse(arr, a, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	public static void nitish(int[] arr, int k)
	{
		int[] atemp = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] aData = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int temp1=0;		
		while(k!=0)
		{
			temp1 = aData[aData.length -1];
			for(int i= 1; i<aData.length;i++)
			{
				atemp[i]=aData[i-1];
			}
			atemp[0] = temp1;
			for(int i= 1; i<atemp.length;i++)
			{
				aData[i]=atemp[i];
			}
			aData = atemp;
			k--;
		}
		System.out.println(Arrays.toString(aData));
	}
}

/**
 * 
 */
package in.sol.algorithms;

/**
 * @author athreya.ks
 *
 */
public class InsertionSort<T extends Comparable<T>> {

	private InsertionSort() {
	}

	public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
		int length = unsorted.length;
		for (int i = 1; i < length; i++) {
			sort(i, unsorted);
		}
		return unsorted;
	}

	private static <T extends Comparable<T>> void sort(int i, T[] unsorted) {
		for (int j = i; j > 0; j--) {
			T jthElement = unsorted[j];
			T jMinusOneElement = unsorted[j - 1];
			if (jthElement.compareTo(jMinusOneElement) < 0) {
				unsorted[j - 1] = jthElement;
				unsorted[j] = jMinusOneElement;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] integers = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };

		InsertionSort sort = new InsertionSort();

		sort.sort(integers);

		// Output => 1 4 6 9 12 23 54 78 231
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}
		System.out.println("");
		// String Input
		String[] strings = { "c", "a", "e", "b", "d" };

		sort.sort(strings);

		// Output => a b c d e
		for (String str : strings) {
			System.out.print(str + " ");
		}
	}
}

/**
 * 
 */
package in.sol.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author athreya.ks
 *
 */
interface FuncInterface {
	// An abstract function
	void abstractFun(int x);

	// A non-abstract (or default) function
	default void normalFun() {
		System.out.println("Hello");
	}
}

public class WhiteBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] initial = { 127, Integer.valueOf(42) };
		List<Integer> toList = Arrays.asList(initial);

		Integer[] fromCollection = toList.toArray(new Integer[toList.size()]);

		Stream<Integer> toStream = Arrays.stream(initial);
		Integer[] fromStream = toStream.toArray(Integer[]::new);

		FuncInterface fobj = (int x) -> System.out.println(2 * x);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);

		for (Integer oneByone : fromStream) {
			System.out.println(oneByone);
		}

	}

}

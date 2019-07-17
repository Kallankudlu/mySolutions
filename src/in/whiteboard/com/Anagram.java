/**
 * 
 */
package in.whiteboard.com;

import java.util.Arrays;
/**
 * @author athreya.ks
 *
 */
import java.util.Scanner;

public class Anagram {

	/*
	 * FIRST METHOD START static boolean isAnagram(String a, String b) { if (a
	 * == null || b == null || a.length() != b.length()) { return false; } a =
	 * a.toLowerCase(); b = b.toLowerCase(); HashMap<Character, Integer> map =
	 * new HashMap<>();
	 * 
	 * Fill HashMap with 1st String for (int i = 0; i < a.length(); i++) { char
	 * ch = a.charAt(i); map.merge(ch, 1, Integer::sum); }
	 * 
	 * Compare 2nd String to 1st String's HashMap for (int i = 0; i <
	 * b.length(); i++) { char ch = b.charAt(i); if (map.containsKey(ch) &&
	 * map.get(ch) > 0) { map.put(ch, map.get(ch) - 1); } else { return false; }
	 * } return true; } END
	 */
	/* Second Method Start */
	/*
	 * static boolean isAnagram(String str1, String str2) { String s1 =
	 * str1.replaceAll("\\s", ""); String s2 = str2.replaceAll("\\s", "");
	 * boolean status = true; if (s1.length() != s2.length()) { status = false;
	 * } else { char[] ArrayS1 = s1.toLowerCase().toCharArray(); char[] ArrayS2
	 * = s2.toLowerCase().toCharArray(); Arrays.sort(ArrayS1);
	 * Arrays.sort(ArrayS2); status = Arrays.equals(ArrayS1, ArrayS2); } return
	 * status; }
	 */
	/* END */
	static boolean isAnagram(String a, String b) {

		if (a.length() != b.length())
			return false;

		a = a.toLowerCase();
		b = b.toLowerCase();

		int[] temp = new int[Character.MAX_VALUE];
		// sry, too lazy to calculate ASCII idx of a-z rel. i :)

		int summ = 0;

		for (int i = 0; i < a.length(); i++) {
			summ += ++temp[a.charAt(i)] <= 0 ? -1 : 1;
			summ += --temp[b.charAt(i)] >= 0 ? -1 : 1;
		}

		return summ == 0;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}

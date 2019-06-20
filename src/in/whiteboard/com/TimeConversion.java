/**
 * 
 */
package in.whiteboard.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author athreya.ks
 *
 */

/*
 * Problem Statement- [Time
 * Conversion](https://www.hackerrank.com/challenges/time-conversion/problem)
 */
public class TimeConversion {

	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */
		int hours = Integer.parseInt(s.substring(0, 2));
		int minutes = Integer.parseInt(s.substring(3, 5));
		int seconds = Integer.parseInt(s.substring(6, 8));
		if (s.substring(8, 10).equals("PM") && hours != 12) {
			hours += 12;
		} else if (s.substring(8, 10).equals("AM") && hours == 12) {
			hours = 0;
		}

		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scan.nextLine();

		String result = timeConversion(s);

		System.out.println(result);
	}

}

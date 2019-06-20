package in.sol.com;
import java.util.Scanner;

public class ConsecutiveBinary {
	public static void main(String[] args) {

		System.out.printf("1. Enter any number :");
		Scanner scanner = new Scanner(System.in);

		int inputNumber = scanner.nextInt();

		int number = inputNumber;
		int contNumber = 0;
		int numberOfOnes = 0;
		while (number > 0) {

			int remainder = number % 2;
			if (remainder == 1) {
				contNumber++;

				if (contNumber > numberOfOnes)
					numberOfOnes = contNumber;

			} else { // reset the contNumber
				contNumber = 0;
			}
			number = number / 2;
		}

		System.out.printf("2. Consecutive 1's in number %d is :%d", inputNumber, numberOfOnes);
	}
}

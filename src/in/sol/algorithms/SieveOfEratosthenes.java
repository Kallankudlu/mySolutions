/**
 * 
 */
package in.sol.algorithms;

import java.util.Arrays;

/**
 * @author athreya.ks
 *
 */
// Java program to print all primes smaller than or equal to
// n using Sieve of Eratosthenes
/*
 * Input: an integer n > 1.
 * 
 * Let A be an array of Boolean values, indexed by integers 2 to n, initially
 * all set to true.
 * 
 * for i = 2, 3, 4, ..., not exceeding √n: if A[i] is true: for j = i2, i2+i,
 * i2+2i, i2+3i, ..., not exceeding n: A[j] := false.
 * 
 * Output: all i such that A[i] is true.
 */
class SieveOfEratosthenes {
	void sieveOfEratosthenes(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			primes[i] = true;
		}
		for (int p = 2; p * p <= n; p++) {
			if (primes[p]) {
				for (int i = p * p; i <= n; i += p)
					primes[i] = false;
			}
		}

	}

	// Driver Program to test above function
	public static void main(String args[]) {
		int n = 30;
		SieveOfEratosthenes g = new SieveOfEratosthenes();
		g.sieveOfEratosthenes(n);
	}
}

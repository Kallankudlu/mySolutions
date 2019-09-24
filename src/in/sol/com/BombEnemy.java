/**
 * 
 */
package in.sol.com;

import java.util.Scanner;

/**
 * @author athreya.ks
 *
 */
// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
// (the number zero), return the maximum enemies you can kill using one bomb.
// The bomb kills all the enemies in the same row and column from the planted
// point until it hits the wall since the wall is too strong to be destroyed.
// Note that you can only put the bomb at an empty cell.

// Example:
// For the given grid

// 0 E 0 0
// E 0 W E
// 0 E 0 0

// return 3. (Placing a bomb at (1,1) kills 3 enemies)

public class BombEnemy {

	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in); int m = scanner.nextInt();
		 * int n = scanner.nextInt(); char[][] arr = new char[m][n]; for (int i
		 * = 0; i < m; i++) { String[] arrRowItems =
		 * scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int j = 0; j < n; j++) { String arrItem = arrRowItems[j];
		 * arr[i][n] = arrItem.charAt(j); } } scanner.close();
		 */
		int m = 4, n = 3;
		//char[][] arr = new char[m][n];
		/*arr={{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};*/
		//arr={{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		//arr={{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		char[][] arr = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		int answer = maxKilledEnemies(arr);
		System.out.println(answer);
	}

	public static int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int max = 0;
		int row = 0;
		int[] col = new int[grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'W') {
					continue;
				}

				if (j == 0 || grid[i][j - 1] == 'W') {
					row = killedEnemiesRow(grid, i, j);
				}

				if (i == 0 || grid[i - 1][j] == 'W') {
					col[j] = killedEnemiesCol(grid, i, j);
				}

				if (grid[i][j] == '0') {
					max = (row + col[j] > max) ? row + col[j] : max;
				}
			}
		}

		return max;
	}

	// calculate killed enemies for row i from column j
	private static int killedEnemiesRow(char[][] grid, int i, int j) {
		int num = 0;

		while (j <= grid[0].length - 1 && grid[i][j] != 'W') {
			if (grid[i][j] == 'E') {
				num++;
			}

			j++;
		}

		return num;
	}

	// calculate killed enemies for column j from row i
	private static int killedEnemiesCol(char[][] grid, int i, int j) {
		int num = 0;

		while (i <= grid.length - 1 && grid[i][j] != 'W') {
			if (grid[i][j] == 'E') {
				num++;
			}

			i++;
		}

		return num;
	}
}

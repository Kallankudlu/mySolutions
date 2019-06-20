/**
* 
*/
package in.sol.com;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CompareTheTriplets {

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> answer = new ArrayList<>();
		int pointsAlice = ((a.get(0) > b.get(0)) ? 1 : 0) + ((a.get(1) > b.get(1)) ? 1 : 0)
				+ ((a.get(2) > b.get(2)) ? 1 : 0);
		answer.add(pointsAlice);
		int pointsBob = ((a.get(0) < b.get(0)) ? 1 : 0) + ((a.get(1) < b.get(1)) ? 1 : 0)
				+ ((a.get(2) < b.get(2)) ? 1 : 0);
		answer.add(pointsBob);
		System.out.println(pointsAlice + " " + pointsBob);
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = compareTriplets(a, b);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}

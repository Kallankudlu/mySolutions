/**
 * 
 */
package in.sol.courseraDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * @author athreya.ks
 *
 */
public class Tree_height {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class Node {
		int index;
		Node parent;
		ArrayList<Node> children;

		public Node() {
			index = 0;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public Node(int i) {
			index = i;
			children = new ArrayList<>();
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
			if (parent != null)
				parent.children.add(this);
		}

		public ArrayList<Node> getChildren() {
			return children;
		}

		public void setChildren(ArrayList<Node> children) {
			this.children = children;
		}

	}
	/*
	 * public class TreeHeight { int n; Node root; ArrayList<Node> nodes;
	 * 
	 * void read() throws IOException { FastScanner in = new FastScanner(); n =
	 * in.nextInt(); nodes = new ArrayList<>(n);
	 * 
	 * for (int childIndex = 0; childIndex < n; childIndex++) { int parentIndex =
	 * in.nextInt(); nodes.add(childIndex, new Node(childIndex));
	 * 
	 * if (parentIndex == -1) { root = nodes.get(childIndex); root.setParent(null);
	 * } else {
	 * 
	 * try { nodes.get(childIndex).setParent(nodes.get(parentIndex)); } catch
	 * (Exception e) { nodes.add(parentIndex, new Node(parentIndex));
	 * nodes.get(childIndex).setParent(nodes.get(parentIndex)); }
	 * 
	 * 
	 * } } for (Node node : nodes) { System.out.println(node); }
	 * 
	 * }
	 */
	/*
	 * int computeHeight() { // Replace this code with a faster implementation int
	 * maxHeight = 0; for (int vertex = 0; vertex < n; vertex++) { int height = 0;
	 * for (int i = vertex; i != -1; i = parent[i]) height++; maxHeight =
	 * Math.max(maxHeight, height); } return maxHeight; }
	 */
	/*
	 * int computeHeight() { Queue<Node> trackHeight = new LinkedList<>();
	 * trackHeight.add(root); return -1; } }
	 */

	public class TreeHeight {
		int n;
		Node root;
		Node[] nodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			/*File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");
			Stream<String> testcases = Files.lines(Paths.get("data.txt"));
			testcases.map(x -> x.split(" "))
	            .filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
			testcases.close();
			try (Stream<Path> paths = Files.walk(Paths.get("E:\\anni\\coursera\\DataStructure\\Week1Assignment\\week1_basic_data_structures\\2_tree_height\\tests"))) {
			    paths
			        .filter(Files::isRegularFile)
			        .forEach(::in.nextInt);
			} */
			n = in.nextInt();
			nodes = new Node[n];

			for (int childIndex = 0; childIndex < n; childIndex++) {
				int parentIndex = in.nextInt();
				Node node;
				if (nodes[childIndex] == null) {
					node = new Node(childIndex);
					nodes[childIndex] = node;
				} else
					node = nodes[childIndex];

				if (parentIndex == -1) {
					root = node;
					root.setParent(null);
				} else {
					Node parent;
					if (nodes[parentIndex] == null) {
						parent = new Node(parentIndex);
						nodes[parentIndex] = parent;
					} else
						parent = nodes[parentIndex];

					node.setParent(parent);
				}
			}
			for (Node node : nodes) {
				System.out.println(node.getChildren());
			}

		}

		/*
		 * Depth First Search int computeHeight(Node root) { if (root == null) return 0;
		 * return 1 + root.children.stream().mapToInt(child ->
		 * computeHeight(child)).max().orElse(0); }
		 */

		/* Breadth First Search */

		int computeHeight(Node root) {
			Queue<Node> queue = new LinkedList<>();
			if (root == null)
				return 0;
			int[] height = new int[n];
			Arrays.fill(height, 0);
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			height[root.index] = 1;
			queue.add(root);

			while (!queue.isEmpty()) {
				Node f = queue.remove();
				if (f.parent != null) {
					height[f.index] = height[f.parent.index] + 1;
				}
				visited[f.index] = true;
				for (Node child : f.children) {
					if (!visited[child.index])
						queue.add(child);
				}
			}
			return Arrays.stream(height).max().orElse(0);
		}
	}

	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new Tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight(tree.root));
	}
}

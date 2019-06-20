package in.sol.com;
import java.util.Scanner;

public class BinarySearchTree {

	public static int getHeight(BstNode root) {
		return 0;
	}

	public static BstNode insert(BstNode root, int data) {
		if (root == null) {
			return new BstNode(data);
		} else {
			BstNode cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
		}
		return root;
	}
	
	/*public void levelOrder(BstNode root){
		while(root)
	}*/

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		BstNode root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}
}

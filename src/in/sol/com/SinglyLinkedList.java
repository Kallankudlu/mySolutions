package in.sol.com;

import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * This class implements a SinglyLinked List. This is done using
 * SinglyLinkedList class and a LinkForLinkedList Class.
 * 
 * A linked list is implar to an array, it hold values. However, links in a
 * linked list do not have indexes. With a linked list you do not need to
 * predetermine it's size as it gorws and shrinks as it is edited. This is an
 * example of a singly linked list. Elements can only be added/removed at the
 * head/front of the list.
 * 
 * @author athreya
 *
 */
class SinglyLinkedList {
	/** Head refered to the front of the list */
	private Node head;

	/**
	 * Constructor of SinglyLinkedList
	 */
	public SinglyLinkedList() {
		head = null;
	}

	/**
	 * This method inserts an element at the head
	 * 
	 * @param x
	 *            Element to be added
	 */
	public void insertHead(int x) {
		Node newNode = new Node(x); // Create a new link with a value attached
									// to it
		newNode.next = head; // Set the new link to point to the current head
		head = newNode; // Now set the new link to be the head
	}
	
	static void deleteDups(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while(n != null) {
			if(set.contains(n.value)) {
				previous.next = n.next;
			}
			else {
				set.add(n.value);
				previous = n;
			}
			n = n.next;
		}
		Stream<Integer> stream = set.stream();

		stream.forEach((element) -> { System.out.println(element); });
		System.out.println("--------------------------------------------------");
		
	}

	public boolean hasCycle(Node head) {
		if (head == null || head.next == null) {
			return false;
		}

		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null && fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return fast == slow;
	}

	public static Node reverseList(Node head) {
		if (head == null) {
			return head;
		}

		Node newHead = null;

		while (head != null) {
			Node next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}

		return newHead;
	}

	public static boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Stack<Integer> stack = new Stack<Integer>();

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			stack.push(slow.value);
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			if (stack.pop() != slow.value) {
				return false;
			}

			slow = slow.next;
		}

		return true;
	}

	public static Node plusOne(Node head) {
		if (plusOneRecursive(head) == 0) {
			return head;
		} else {
			Node newHead = new Node(1);
			newHead.next = head;

			return newHead;
		}
	}

	private static int plusOneRecursive(Node head) {
		if (head == null) {
			return 1;
		}

		int carry = plusOneRecursive(head.next);

		if (carry == 0) {
			return 0;
		}

		int value1 = head.value + 1;
		head.value = value1 % 10;

		return value1 / 10;
	}

	public static SinglyLinkedList addTwoNumbers(SinglyLinkedList l1, SinglyLinkedList l2) {
		SinglyLinkedList current1 = l1;
		SinglyLinkedList current2 = l2;
		SinglyLinkedList result = new SinglyLinkedList();

		Node head = new Node(0);
		Node currentHead = head;

		int sum = 0;

		while (current1.head != null || current2.head != null) {

			sum /= 10;

			if (current1.head != null) {

				sum += current1.head.value;
				current1.head = current1.head.next;

			}

			if (current2.head != null) {

				sum += current2.head.value;
				current2.head = current2.head.next;

			}
			currentHead.next = new Node(sum % 10);
			currentHead = currentHead.next;
			result.insertHead(currentHead.value);

		}

		if (sum / 10 == 1) {

			currentHead.next = new Node(1);

		}

		return result;

	}

	/**
	 * Inserts a new node at a specified position
	 * 
	 * @param head
	 *            head node of the linked list
	 * @param data
	 *            data to be stored in a new node
	 * @param position
	 *            position at which a new node is to be inserted
	 * @return reference of the head of the linked list
	 */

	Node InsertNth(Node head, int data, int position) {

		Node newNode = new Node(position);
		newNode.data = data;

		if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		Node current = head;

		while (--position > 0) {
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;
		return head;
	}

	/**
	 * This method deletes an element at the head
	 * 
	 * @return The element deleted
	 */
	public Node deleteHead() {
		Node temp = head;
		head = head.next; // Make the second element in the list the new head,
							// the Java garbage collector will later remove the
							// old head
		return temp;
	}

	/**
	 * Checks if the list is empty
	 * 
	 * @return true is list is empty
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Prints contents of the list
	 */
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Main method
	 * 
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String args[]) {
		SinglyLinkedList myList = new SinglyLinkedList();
		SinglyLinkedList secList = new SinglyLinkedList();
		SinglyLinkedList resultList = new SinglyLinkedList();
		SinglyLinkedList plusOneList = new SinglyLinkedList();
		SinglyLinkedList checkingForDups = new SinglyLinkedList();
		// System.out.println(myList.isEmpty()); // Will print true

		checkingForDups.insertHead(3);
		checkingForDups.insertHead(7);
		checkingForDups.insertHead(3);
		checkingForDups.insertHead(3);
		checkingForDups.insertHead(3);
		checkingForDups.insertHead(7);
		checkingForDups.insertHead(3);
		checkingForDups.insertHead(3);
		checkingForDups.insertHead(2);
		
		deleteDups(checkingForDups.head);
		
		myList.insertHead(3);
		myList.insertHead(7);
		myList.insertHead(3);

		secList.insertHead(3);
		secList.insertHead(3);
		secList.insertHead(4);

		plusOneList.insertHead(1);
		plusOneList.insertHead(2);
		plusOneList.insertHead(3);

		// Node resultOfPlusOne = plusOne(plusOneList.head);
		// resultOfPlusOne.display();
		Node resultOfPlusOne = reverseList(plusOneList.head);

		resultList = addTwoNumbers(myList, secList);

		resultList.display(); // 10(head) --> 7 --> 5
		// resultList.head.next.next = resultList.head;
		boolean result = isPalindrome(resultList.head);
		boolean answer = resultList.hasCycle(resultList.head);
		if (answer) {
			System.out.println("Cycle exists.");
		} else {
			System.out.println("No cycle.");
		}
		if (result) {
			System.out.println("Palindorme");
		} else {
			System.out.println("Not a palindrome.");
		}

		// myList.deleteHead();

		// myList.display(); // 7(head) --> 5
	}
}

/**
 * This class is the nodes of the SinglyLinked List. They consist of a vlue and
 * a pointer to the node after them.
 * 
 * @author athreya
 *
 */
class Node {
	public int data;
	/** The value of the node */
	public int value;
	/** Point to the next node */
	public Node next; // This is what the link will point to

	/**
	 * Constructor
	 * 
	 * @param valuein
	 *            Value to be put in the node
	 */
	public Node(int valuein) {
		value = valuein;
	}

	/**
	 * Returns value of the node
	 */
	public int getValue() {
		return value;
	}

}
package in.sol.com;

public class MyLinkedList {

	public static LNode insert(LNode head, int data){
		
		if(head == null){
			head = new LNode(data);
			return head;
		}
		return null;
	}
}

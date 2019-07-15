/**
 * 
 */
package in.sol.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author athreya.ks
 *
 */
public class LinkedList<T> implements Iterator {
	Node<T> head, current;

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	public LinkedList(T data) {
		head = new Node<>(data);
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

	private class LinkedListIterator implements Iterator<T> {
		Node<T> node = head;

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node<T> prevNode = node;
			node = node.next;
			return prevNode.data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Removal logic not implemented.");
		}
	}

	public void add(T data) {
		Node current = head;
		while (current.next != null)
			current = current.next;
		current.next = new Node<>(data);
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(1);
		list.add(2);
		list.add(4);
		list.add(3);
		// Test #1
		System.out.println("using Iterator:");
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			Integer i = itr.next();
			System.out.print(i + " ");
		}
		// Test #2
		System.out.println("\n\nusing for-each:");
		/*for (Integer data : list) {
			System.out.print(data + " ");
		}*/
	}
}

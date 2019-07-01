/**
 * 
 */
package in.whiteboard.com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author athreya.ks
 */

public class User implements Comparable<User> {
	public final Long id;
	public final String username;

	public User(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	@Override
	public String toString() {
		return String.format("%s:%d", username, id);
	}

	@Override
	/** The natural ordering for 'User' objects is by the 'id' field. */
	public int compareTo(User o) {
		return id.compareTo(o.id);
	}

	public static void main(String args[]) {
		/*
		 * List<User> users = Lists.newArrayList(new User(33L, "A"), new
		 * User(25L, "B"), new User(28L, "")); Collections.sort(users);
		 * System.out.print(users);
		 */
		Set<Integer> set = new HashSet<Integer>();
		set.add(3);
		set.add(1);
		set.add(2);
		set.add(1);
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(7);
		for (Integer integer : set) {
			System.out.println(integer);
		}
		System.out.println("------------------------------------");
		/*List number = Arrays.asList(2,3,4,5);
		List square = (List) number.stream().map(x->x*x).collect(Collectors.toList());
		for (List object : square) {
			System.out.println(object);
		}*/
		
	}
}

/**
 * 
 */
package in.whiteboard.com;

import java.util.Collections;
import java.util.List;

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
		/*List<User> users = Lists.newArrayList(new User(33L, "A"), new User(25L, "B"), new User(28L, ""));
		Collections.sort(users);
		System.out.print(users);*/
	}
}

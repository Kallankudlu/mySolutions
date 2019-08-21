/**
 * 
 */
package in.whiteboard.com;

/**
 * @author athreya.ks
 *
 */
public class Singleton {

	private Singleton() {
	}

	public String str;
	private static Singleton instance = null;

	public static Singleton getSingleInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}

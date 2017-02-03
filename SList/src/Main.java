import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
		SList<Integer> ll = new SList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		ll.pop_back();
		ll.pop_back();
		ll.pop_back();
    }
}

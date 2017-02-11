import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
		StringHelper sh = new StringHelper();
		String temp = sh.Compress("aaaabbccccd");
		temp = sh.Compress("abcd");
    }
}

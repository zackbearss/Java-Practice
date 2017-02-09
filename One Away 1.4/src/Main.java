import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
		StringHelper sh = new StringHelper();
		boolean test = sh.IsOneAway("pale", "ple");
		test = sh.IsOneAway("pales", "pale");
		test = sh.IsOneAway("pale", "bale");
		test = sh.IsOneAway("pale", "bake");
    }
}

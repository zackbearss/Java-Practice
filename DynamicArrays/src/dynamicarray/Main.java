package dynamicarray;

public class Main {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        DynamicArray<Boolean> test = new DynamicArray<Boolean>();
        boolean state = false;
        for(int i = 0; i < 15; i++){
        	test.push(state);
        	state = !state;
        }
//        test.push(true);
//        test.push(false);
//        test.push(false);
        test.insert(15, true);
        System.out.println(test.getSize());
        for(int i = 0; i < test.getSize(); i++){
        	System.out.println(test.at(i));
        }
    }
}

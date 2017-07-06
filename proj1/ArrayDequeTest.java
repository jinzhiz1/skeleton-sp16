/** Performs some basic Array list tests. */
public class ArrayDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for check the usage ratio */
	public static void checkRatio(int size, int length) {
		double ratio = (size * 1.0)/(length * 1.0);
		if(ratio >= 0.25)
			System.out.println("usage ratio is " + ratio + ", you have passed the ratio test");
		else
			System.out.println("test failed, your usage ratio is less than 25%");
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		
		ArrayDeque<String> lld1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
		
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		
		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		//printTestStatus(passed);

		lld1.addLast(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeLast();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
	}

	/** Adds more than one item to test the right result. */
	public static void addRemoveMoreThanOneTest() {
		System.out.println("Running add/remove more than one item test.");
		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

		lld1.addFirst(10);
		lld1.addFirst(11);
		lld1.addFirst(12);
		lld1.addLast(9);
		lld1.addLast(8);
		lld1.addLast(7);

		System.out.println("Printing out deque (should be 12 11 10 9 8 7): ");
		lld1.printDeque();

		lld1.removeLast();
		lld1.removeLast();
		lld1.removeLast();
		lld1.removeLast();
		System.out.println("Printing out deque (should be 12 11): ");
		lld1.printDeque();

		lld1.addLast(10);
		lld1.addLast(9);
		lld1.addLast(8);
		lld1.addLast(7);
		System.out.println("Printing out deque (should be 12 11 10 9 8 7): ");
		lld1.printDeque();

		lld1.removeFirst();
		lld1.removeFirst();
		lld1.removeFirst();
		lld1.removeFirst();
		System.out.println("Printing out deque (should be 8 7): ");
		lld1.printDeque();

		lld1.addFirst(9);
		lld1.addFirst(10);
		lld1.addFirst(11);
		lld1.addFirst(12);
		System.out.println("Printing out deque (should be 12 11 10 9 8 7): ");
		lld1.printDeque();

		//System.out.println("Congradulations! you have pass all test!");
	}

	/** Resize method test */
	public static void addRemoveResizeTest() {
		System.out.println("Running add/remove resize test.");
		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

		/* add the 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 */
		lld1.addFirst(5);
		lld1.addFirst(4);
		lld1.addFirst(3);
		lld1.addFirst(2);
		lld1.addFirst(1);
		lld1.addFirst(0);
		lld1.addLast(6);
		lld1.addLast(7);
		lld1.addLast(8);
		lld1.addLast(9);
		lld1.addLast(10);
		lld1.addLast(11);
		lld1.addLast(12);
		lld1.addLast(13);
		lld1.addLast(14);
		lld1.addLast(15);

		System.out.println("Printing out deque (should be 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15): ");
		lld1.printDeque();

		/* should be larger that 0.25 */
		checkRatio(lld1.size(), lld1.length());

		lld1.removeLast();
		lld1.removeLast();
		lld1.removeLast();
		lld1.removeLast();
		lld1.removeLast();
		lld1.removeLast();
		lld1.removeFirst();
		lld1.removeFirst();
		lld1.removeFirst();

		System.out.println("Printing out deque (should be 3,4,5,6,7,8,9): ");
		lld1.printDeque();

		/* should be larger that 0.25 */
		checkRatio(lld1.size(), lld1.length());

		System.out.println("Congradulations! You have passed all tests!");
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		addRemoveMoreThanOneTest();
		addRemoveResizeTest();
	}
} 
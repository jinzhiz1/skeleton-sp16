/** This is the Double queue Linked List, I implement the circular sentinel topology.
  * This class includes the addFirst, addLast, isEmpty, size, printDeque, removeFirst,
  * removeLast, and get method. 
  * And I use the genric type for this class
  */
public class LinkedListDeque<BleeBlorp> {
	private Node sentinel;
	private int size;

	public class Node {
		public BleeBlorp item;  /* Equivalent of first */
		public Node next;       /* Equivalent of next */
		public Node previous;   /* Equivalent of previous */

		public Node(BleeBlorp i, Node n, Node p) {
			item = i;
			next = n;
			previous = p;
		}
	}

	/** Create an empty LinkedList */
	public LinkedListDeque() {
		size = 0;
		sentinel = new Node(null, null, null);
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}

	/** Create a DequeLinkedList with only one item */
	public LinkedListDeque(BleeBlorp x) {
		size = 1;
		sentinel = new Node(null, null, null);
		sentinel.next = new Node(x, sentinel, sentinel);
		sentinel.previous = sentinel.next;
	}

	/** Adds an item to the front of the LinkedListDeque */
	public void addFirst(BleeBlorp x) {
		size += 1;
		Node temp = sentinel.next;
		sentinel.next = new Node(x, temp, sentinel);
		temp.previous = sentinel.next;
	}
	
	/** Adds an item to the back of the Deque */
	public void addLast(BleeBlorp x) {
		size += 1;
		Node temp = sentinel.previous;
		sentinel.previous = new Node(x, sentinel, temp);
		temp.next = sentinel.previous;
	}

	/** Return true if the LinkedListDeque is empty, false otherwise */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}

	/** Return the number of items in the LinkedListDeque */
	public int size() {
		return size;
	}

	/** Prints the items in the LinkedListDeque from first to last, separated by a space */
	public void printDeque() {
		Node node = sentinel.next;
		while(node != sentinel) {
			System.out.print(node.item + " ");
			node = node.next;
		}
		System.out.println();
	}

	/** Removes and returns the item at the front of the Deque. If no such item exists, returns null */
	public BleeBlorp removeFirst() {
		if(sentinel.next == null)
			return null;
		else {
			size -= 1;
			BleeBlorp removeItem = sentinel.next.item;
			sentinel.next = sentinel.next.next;
			sentinel.next.previous = sentinel;
			return removeItem;
		}
	}

	/** Removes and returns the item at the back of the Deque. If no such item exists, returns null */
	public BleeBlorp removeLast() {
		if(sentinel.previous == null)
			return null;
		else {
			size -= 1;
			BleeBlorp removeItem = sentinel.previous.item;
			sentinel.previous = sentinel.previous.previous;
			sentinel.previous.next = sentinel;
			return removeItem;
		}
	}

	/** Gets the item at the given given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. 
	  * Not alter the deque, using the iteration.
	  */
	public BleeBlorp get(int index) {
		if(index < size) {
			Node result = sentinel.next;
			while(index >= 0){
				if(index == 0)
					return result.item;
				result = result.next;
				index -= 1;
			}
		}
		return null;
	}

	/** Same as get, but uses recursion */
	public BleeBlorp getRecursive(int index) {
		if(index < size) {
			if(index == 0)
				return sentinel.next.item;
			else {
				removeFirst();
				return getRecursive(index - 1);
			}
		}
		else {
			return null;
		}
	}

	/*
	public static void main(String[] args) {
		LinkedListDeque<Integer> s1 = new LinkedListDeque<Integer>(5);
		s1.addFirst(10);
		s1.addLast(11);
		Integer res = s1.get(0);
		System.out.println(res);
		Integer res1 = s1.getRecursive(0);
		System.out.println(res1);
		System.out.println(s1.isEmpty());
		System.out.println(s1.size());
		System.out.println(s1.size);
		s1.printDeque();
		Integer first = s1.removeFirst();
		s1.printDeque();
		Integer last = s1.removeLast();
		s1.printDeque();
	}
	*/
}
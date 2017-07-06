/** This is the Double queue Array List, I implement the circular sentinel topology.
  * This class includes the addFirst, addLast, isEmpty, size, printDeque, removeFirst,
  * removeLast, and get method. 
  * And I use the genric type for this class
  */
public class ArrayDeque<Blorp> {
    private Blorp[] items;
    private int size;
    private int last;
    private int first;

    /** Construct an Empty ArrayDeque */
    public ArrayDeque() {
        items = (Blorp []) new Object[8];
        size = 0;
        first = 0;
        last = 0;
    }

    /** Construct an ArrayDeque with an item */
    public ArrayDeque(Blorp x) {
        items = (Blorp []) new Object[8];
        items[items.length - 1] = x;
        size = 1;
        first = 1;
        last = size - first;
    }

    /** Help method to resize when the size is larger than items.length */
    private void addResize(int capacity){
        Blorp[] newItems = (Blorp []) new Object[capacity];
        if (last > 0) {
            System.arraycopy(items, 0, newItems, 0, last);
        }
        if (first > 0) {
            System.arraycopy(items, items.length - first, newItems, 
                newItems.length - first, first); 
        }
        items = newItems;
    }

    /** Adds an item to the front of the Deque */
    public void addFirst(Blorp x) {
        if (size == items.length) {
            addResize(size * 4);
        }

        if(first >= 0) {
            first++;
            items[items.length - first] = x;
            size++;
        }
        else {
            first++;
            items[-first] = x;
            size++;
        }
    }

    /** Adds an item to the back of the Deque */
    public void addLast(Blorp x) {
        if (size == items.length) {
            addResize(size * 4);
        }

        if(last >= 0) {
            items[last] = x;
            last++;
            size++;
        }
        else {
            items[items.length + last] = x;
            last++;
            size++;
        }
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    /** Returns the number of items in the Deque */
    public int size() {
        return size;
    }
    
    /** Returns the total length of array */
    public int length() {
        return items.length;
    }

    /** Prints the items in the Deque from first to last, separated by a space 
      * Seperate to three situation, the forth, first < 0 && last < 0 does not
      * exists.
      */
    public void printDeque() {
        int index = first;
        if(first >= 0 && last >= 0) {
            while(index > 0){
                System.out.print(items[items.length - index] + " ");
                index--;
            }
        
            while(index < last){
                System.out.print(items[index] + " ");
                index++;
            }
        }

        else if(first >= 0 && last < 0) {
            while(index > (-last)){
                System.out.print(items[items.length - index] + " ");
                index--;
            }
        }

        else if(first < 0 && last >= 0) {
            while(-index < last) {
                System.out.print(items[-index] + " ");
                index--;
            }
        }
        System.out.println();
    }

    /** Help method to resize when the size is less than 0.25 * items.length */
    private void removeResize(int capacity){
        Blorp[] newItems = (Blorp []) new Object[capacity];
        if (last > 0) {
            System.arraycopy(items, 0, newItems, 0, last);
        }
        if (first > 0) {
            System.arraycopy(items, items.length - first, newItems, 
                newItems.length - first, first); 
        }
        items = newItems;
    }

    /** Removes and returns the item at the front of the Deque. If no such item
      * exists, returns null.
      */
    public Blorp removeFirst() {
        if(size <= (items.length/4)){
            removeResize(items.length/4);
        }

        if(size == 0)
            return null;
        else {
            first--;
            size--;
            if (first >= 0) 
                return items[items.length - first - 1];
            else
                return items[-first-1];
        }
    }

    /** Removes and returns the item at the back of the Deque. If no such item
      * exists, returns null.
      */
     public Blorp removeLast() {
        if(size < (items.length/4)){
            removeResize(items.length/4);
        }

        if(size == 0)
            return null;
        else {
            last--;
            size--;
            if(last >= -1)
                return items[last + 1];
            else
                return items[items.length + last + 1];
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, 
      * and so forth. If no such item exists, returns null. Must not alter the deque!
      */
    public Blorp get(int index) {
        if(index >= size)
            return null;
        else {
            int id = first - index;
            if(id > 0){
                return items[items.length - id];
            }
            else{
                return items[-id];
            }
        }
    }

    /*
    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<Integer>();
        a1.addFirst(4);
        a1.addLast(5);
        a1.printDeque();
    }
    */
}
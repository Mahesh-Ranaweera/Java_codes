/**
 * Heap Sort
 * Data Structures SOFE 2715U
 * Assignment 4:
 * @author Mahesh Ranaweera
 * Date : March 24, 2016
 * Code Description: This code is developed to sort a list of entries 
 * 					 that is stored in entry.txt. HeapPriorityQueue code
 * 					 is used to create the heap. Preordertraversal of the
 * 					 created heap and the sorted list is printed.
 */

package Heap;

import java.util.ArrayList;
import java.util.Comparator;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class forthAssignment
{

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception
    {
    	//Location of the file
        String fileLoc = "C:/"+ "Users/UserName/Desktop/Java txt File/entry.txt";

        try
        {
            FileReader file = new FileReader(fileLoc);
            BufferedReader reader = new BufferedReader(file);

            HeapPriorityQueue<Integer, String> newHeap = new HeapPriorityQueue<Integer, String>();
            HeapPriorityQueue<Integer, String> tmpHeap = new HeapPriorityQueue<Integer, String>();
           
            String line = reader.readLine();

            while(line!=null)
            {
                String tempStr = line;
                
                //Read from file test
                //System.out.println(tempStr);
                
                //remove spaces
                tempStr = tempStr.replace(" ", "");
                //remove bracket "<"
                tempStr = tempStr.replace("<", "");
                //remove bracket ">"
                tempStr = tempStr.replace(">", "");

                //split data and store in a array
                String[] strArray = tempStr.split(",");

                //let index be Key and Value be val
                int index = Integer.parseInt(strArray[0]);
                String val = strArray[1];

                //debug
                //System.out.println("Key :"+index+" Value is:"+val);

                //Inserting into Heap
                newHeap.insert(index, val);

                line = reader.readLine();
            }
            reader.close();

            //Saving a copy of the original heap
            tmpHeap = newHeap;
            
            //Preorder Traversal
            System.out.println();
            System.out.println("Preorder:");       
            int run = 0;
            newHeap.getPreorder(newHeap, run);

            //Heap test
            
            System.out.println();
            System.out.println("Heap:");
            for (int i=0; i<newHeap.size(); i++)
            {
            	newHeap.print(i);
            } 
            

            System.out.println();
            System.out.println("Sorted List:");
            while(!tmpHeap.isEmpty())
            {
            	int key = (int) tmpHeap.min().getKey();
            	String Value = (String) tmpHeap.min().getValue();

            	tmpHeap.removeMin();

            	System.out.print("<"+key+" ,"+Value+"> ");
            }
        }

        catch(IOException e)
        {
            System.out.println("========================");
            System.out.println(" CANNOT FIND THE FILE");
            System.out.println("========================");
        }
    }

}


//DefaultComparator
class DefaultComparator<E> implements Comparator<E> {

  /**
   * Compares two elements.
   *
   * @return a negative integer if <tt>a</tt> is less than <tt>b</tt>,
   * zero if <tt>a</tt> equals <tt>b</tt>, or a positive integer if
   * <tt>a</tt> is greater than <tt>b</tt>
   */
  @SuppressWarnings({"unchecked"})
  public int compare(E a, E b) throws ClassCastException {
    return ((Comparable<E>) a).compareTo(b);
  }
}

//Entry
interface Entry<K,V> {
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getKey();

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getValue();
}


//PriorityQueue
interface PriorityQueue<K,V> {

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  int size();

  /**
   * Tests whether the priority queue is empty.
   * @return true if the priority queue is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Inserts a key-value pair and returns the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  Entry<K,V> insert(K key, V value) throws IllegalArgumentException;

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  Entry<K,V> min();

  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  Entry<K,V> removeMin();
}

//AbstractPriorityQueue
abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
  //---------------- nested PQEntry class ----------------
  /**
   * A concrete implementation of the Entry interface to be used within
   * a PriorityQueue implementation.
   */
  protected static class PQEntry<K,V> implements Entry<K,V> {
    private K k;  // key
    private V v;  // value

    public PQEntry(K key, V value) {
      k = key;
      v = value;
    }

    // methods of the Entry interface
    public K getKey() { return k; }
    public V getValue() { return v; }

    // utilities not exposed as part of the Entry interface
    protected void setKey(K key) { k = key; }
    protected void setValue(V value) { v = value; }
  } //----------- end of nested PQEntry class -----------

  // instance variable for an AbstractPriorityQueue
  /** The comparator defining the ordering of keys in the priority queue. */
  private Comparator<K> comp;

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * @param c comparator defining the order of keys in the priority queue
   */
  protected AbstractPriorityQueue(Comparator<K> c) { comp = c; }

  /** Creates an empty priority queue based on the natural ordering of its keys. */
  protected AbstractPriorityQueue() { this(new DefaultComparator<K>()); }

  /** Method for comparing two entries according to key */
  protected int compare(Entry<K,V> a, Entry<K,V> b) {
    return comp.compare(a.getKey(), b.getKey());
  }

  /** Determines whether a key is valid. */
  protected boolean checkKey(K key) throws IllegalArgumentException {
    try {
      return (comp.compare(key,key) == 0);  // see if key can be compared to itself
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Incompatible key");
    }
  }

  /**
   * Tests whether the priority queue is empty.
   * @return true if the priority queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { return size() == 0; }
}



//HeapPriorityQueue
class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
  /** primary collection of priority queue entries */
  protected ArrayList<Entry<K,V>> heap = new ArrayList<>();

  /** Creates an empty priority queue based on the natural ordering of its keys. */
  public HeapPriorityQueue() { super(); }

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * @param comp comparator defining the order of keys in the priority queue
   */
  public HeapPriorityQueue(Comparator<K> comp) { super(comp); }

  /**
   * Creates a priority queue initialized with the respective
   * key-value pairs.  The two arrays given will be paired
   * element-by-element. They are presumed to have the same
   * length. (If not, entries will be created only up to the length of
   * the shorter of the arrays)
   * @param keys an array of the initial keys for the priority queue
   * @param values an array of the initial values for the priority queue
   */
  public HeapPriorityQueue(K[] keys, V[] values) {
    super();
    for (int j=0; j < Math.min(keys.length, values.length); j++)
      heap.add(new PQEntry<>(keys[j], values[j]));
    heapify();
  }

  // protected utilities
  protected int parent(int j) { return (j-1) / 2; }     // truncating division
  protected int left(int j) { return 2*j + 1; }
  protected int right(int j) { return 2*j + 2; }
  protected boolean hasLeft(int j) { return left(j) < heap.size(); }
  protected boolean hasRight(int j) { return right(j) < heap.size(); }

  /** Exchanges the entries at indices i and j of the array list. */
  protected void swap(int i, int j) {
    Entry<K,V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  /** Moves the entry at index j higher, if necessary, to restore the heap property. */
  /*protected*/ public int upheap(int j) {
    while (j > 0) {            // continue until reaching root (or break statement)
      int p = parent(j);
      if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
      swap(j, p);
      j = p;                                // continue from the parent's location
    }
    return j; //added for preorder traversal 
  }

  /** Moves the entry at index j lower, if necessary, to restore the heap property. */
  protected void downheap(int j) {
    while (hasLeft(j)) {               // continue to bottom (or break statement)
      int leftIndex = left(j);
      int smallChildIndex = leftIndex;     // although right may be smaller
      if (hasRight(j)) {
          int rightIndex = right(j);
          if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
            smallChildIndex = rightIndex;  // right child is smaller
      }
      if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
        break;                             // heap property has been restored
      swap(j, smallChildIndex);
      j = smallChildIndex;                 // continue at position of the child
    }
  }

  /** Performs a bottom-up construction of the heap in linear time. */
  protected void heapify() {
    int startIndex = parent(size()-1);    // start at PARENT of last entry
    for (int j=startIndex; j >= 0; j--)   // loop until processing the root
      downheap(j);
  }

  // public methods

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  @Override
  public int size() { return heap.size(); }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  @Override
  public Entry<K,V> min() {
    if (heap.isEmpty()) return null;
    return heap.get(0);
  }

  /**
   * Inserts a key-value pair and return the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key);      // auxiliary key-checking method (could throw exception)
    Entry<K,V> newest = new PQEntry<>(key, value);
    heap.add(newest);                      // add to the end of the list
    upheap(heap.size() - 1);               // upheap newly added entry
    return newest;
  }

  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  @Override
  public Entry<K,V> removeMin() {
    if (heap.isEmpty()) return null;
    Entry<K,V> answer = heap.get(0);
    swap(0, heap.size() - 1);              // put minimum item at the end
    heap.remove(heap.size() - 1);          // and remove it from the list;
    downheap(0);                           // then fix new root
    return answer;
  }

  /** Used for debugging purposes only */
  private void sanityCheck() {
    for (int j=0; j < heap.size(); j++) {
      int left = left(j);
      int right = right(j);
      if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0)
        System.out.println("Invalid left child relationship");
      if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0)
        System.out.println("Invalid right child relationship");
    }
  }

  /** Used to print the heap **/
  public void print(int index)
  {
	System.out.print("<"+heap.get(index).getKey()+" ,"+heap.get(index).getValue()+"> ");
  }

  /** Preorder traversal **/
  public static void getPreorder (HeapPriorityQueue<Integer, String> myHeap, int index)
  {
  	int k=index;

   	System.out.print("<"+((Entry) myHeap.heap.get(k)).getKey()+" ,"+((Entry) myHeap.heap.get(k)).getValue()+"> ");
   	if (myHeap.hasLeft(index))
   	{
   		//debug
       	//System.out.println("Left: At "+myHeap.left(index));
   		//k = myHeap.left(index);
   		getPreorder(myHeap, myHeap.left(index));
    }
        	
    if (myHeap.hasRight(index))
    {
    	//debug
       	//System.out.println("Right: As "+myHeap.right(index));
      	//k = myHeap.right(index);
       	getPreorder(myHeap, myHeap.right(index));
    }
  }
}


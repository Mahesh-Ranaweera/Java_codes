/*
 * Comparing Sorting Algorithms
 * Data Structures SOFE 2715U
 * Assignment 5: Comparing Sorting Algorithms
 * Author : Mahesh, Ranaweera
 * Date	  : April 5, 2016
 * Code Description : This code is developed to measure the running time of the 
 * 					  Heap-Sort, In-Place Quick Sort and Merge Sort. Experiment will
 * 					  run 10 times to get a minimum, average and maximum running times.
 * 					  Random numbers from 0-100,000 random numbers will be generated and
 * 					  inserted into the corresponding sorting algorithms. Sorting times
 * 				      of each algorithms will be displayed in the console.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.Random;


public class fifthAssignment
{
	public static void main(String[] args)
	{
		System.out.println("=======================================================");
		System.out.printf("%-19s %8s %12s %7s \n", " Algorithm name","Min","Average","Max");
		System.out.println("=======================================================");
		
		SortingTime algorithmTime = new SortingTime();

  		algorithmTime.heapSorting();
  		algorithmTime.inPlaceQuickSorting();
  		algorithmTime.mergeSorting();      
	}
}


class SortingTime
{
	/*
	 * ALGO_LOOP=Number of times the sorting algorithm run
	 * RAND_MAX =Random number generating range from 0-100,000 (inclusive)
	 * RAND_NUM =Generating 10,000 integers
	 */
	public static final int ALGO_LOOP=10;
	public static final int RAND_MAX=100000;
	public static final int RAND_NUM=10000;
	
	public void algTime(String algorithm,long elapsedTime, long[] algTimeArray)
	{
		//getting running time average
		long avgElapsed = elapsedTime / 10;
		
		//sorting the elapsed time from max to min
		long tempNum=0;
		for (int r=0; r<algTimeArray.length; r++)
		{
			for (int s=0; s<algTimeArray.length-1; s++)
			{
				if(algTimeArray[s+1]>algTimeArray[s])
				{
					tempNum = algTimeArray[s+1];
					algTimeArray[s+1] = algTimeArray[s];
					algTimeArray[s] = tempNum;
				}
			}
		}
		
		/*
		 //DEBUG: print the time array
		for (int i=0; i<timeArray.length; i++)
		{
			System.out.println(timeArray[i]+" ");
		}*/
		
		int MIN=9; //get array min run time value
		int MAX=0; //get array max run time value
		
		System.out.printf("%-19s %8s %10s %10s \n", algorithm,algTimeArray[MIN]+" ms",avgElapsed+" ms",algTimeArray[MAX]+" ms");
		System.out.println("");
	}
	
	public void heapSorting()
	{
		//Array to store running times
		long[] timeArray = new long[10];
		
		//Looping algorithm for 10 times to get min, max and average sorting times
		//code loops 10 times
		long elapsedTime=0;
		int run=0;
		while(run<ALGO_LOOP)
		{
			//Heap, creating new Heap
			HeapPriorityQueue<Integer, String> newHeap = new HeapPriorityQueue<Integer, String>();
			
			Random newGenNum = new Random();
			//Filling random numbers into the Heap
			for (int i=0; i<RAND_NUM; i++)
			{
				int num = newGenNum.nextInt(RAND_MAX);
				newHeap.insert(num, "");
			}
			
			//DEBUG: content of Heap
			/*
			 System.out.println("HeapTest:");
	         for (int i=0; i<newHeap.size(); i++)
	         {
	         	newHeap.print(i);
	         }
	         System.out.println();
	         */
	         
	         //System.out.println("SortedHeap:");
	         
	         //Heap sorting from min to max integer
	         
	         //Timing start
	         long startTime = System.currentTimeMillis();
	         while(!newHeap.isEmpty())
	         {
	         	int key = (int) newHeap.min().getKey();
	         	String Value = (String) newHeap.min().getValue();

	         	newHeap.removeMin();

	         	//DEBUG: sorted Heap
	         	//System.out.print("<"+key+"> ");
	         }
	         //end of HeapSort
	         //System.out.println();
			
	         //get end time
	         long endTime = System.currentTimeMillis();
				
	         //time taken
			 long elapsed = endTime - startTime;
				
			 //storing time in a array
			 timeArray[run]=elapsed;
			 elapsedTime = elapsedTime + elapsed;
			
			 run++;
		}
		
		//Passing values, Algorithm name, elapased time and time array
		algTime("Heap-Sort", elapsedTime,timeArray);	
		
	}
	
	public void mergeSorting()
	{
		MergeSort newMergeSort = new MergeSort();
		Comparator<Integer> comp = new Comparator<Integer>(){
			public int compare(Integer d1, Integer d2)
			{
				return d1.compareTo(d2);
			}
		};
		
		//Array to store running times
		long[] timeArray = new long[10];
		
		long elapsedTime=0;
		int run=0;
		while(run<ALGO_LOOP)
		{
			Random newGenNum = new Random();
	        
			//merge Sort array
	        int[] mergeS = new int[RAND_NUM];
	        
	        //Storing Random numbers in the mergeS array
			for (int i=0; i<RAND_NUM; i++)
			{
				int num = newGenNum.nextInt(RAND_MAX);
				mergeS[i] = num;
				//System.out.print("value"+i+"="+mergeS[i]+" ");
			}
			
			//Timing start
	         long startTime = System.currentTimeMillis();
	         
	        //sorting values using mergeSort
			newMergeSort.mergeSort(mergeS, comp);
			
			
			//System.out.println();
			//DEBUG: print the sorted array
			/*
			for (int j=0; j<mergeS.length; j++)
			{
				System.out.print("value"+j+"="+mergeS[j]+" ");
			}
			*/
			
			//get end time
	        long endTime = System.currentTimeMillis();
				
	        //time taken
			long elapsed = endTime - startTime;
				
			//storing time in a array
			timeArray[run]=elapsed;
			elapsedTime = elapsedTime + elapsed;
			
			run++;
		}
		
		//Passing values, Algorithm name, elapased time and time array
		algTime("Merge-Sort", elapsedTime,timeArray);	
	}
	
	public void inPlaceQuickSorting()
	{
		Comparator<Integer> comp = new Comparator<Integer>(){
			public int compare(Integer d1, Integer d2)
			{
				return d1.compareTo(d2);
			}
		};
		
		//Array to store running times
		long[] timeArray = new long[10];
				
		long elapsedTime=0;
		int run=0;
		while(run<ALGO_LOOP)
		{
			QuickSort newQuickSort = new QuickSort();

			Random newGenNum = new Random();
			
			//inPlaceSort array
	        int[] inPlaceS = new int[RAND_NUM];
	        
	        //Storing random numbers in InPlaceQuickSort array
	  		for (int i=0; i<RAND_NUM; i++)
	  		{
	  			int num = newGenNum.nextInt(RAND_MAX);
	  			inPlaceS[i] = num;
	  			//System.out.print("value"+i+"="+inPlaceS[i]+" ");
	  		}
	  		//System.out.println();
	  		
	  		//Timing start
	        long startTime = System.currentTimeMillis();
	  		
	        //sorting values using in-place-quicksort
	  		newQuickSort.quickSortInPlace(inPlaceS, comp);
	  		
	  		/*
	  		System.out.println();
	  		for (int j=0; j<inPlaceS.length; j++)
	  		{
	  			System.out.print("value"+j+"="+inPlaceS[j]+" ");
	  		}
	  		*/
	  		
	  		//get end time
	        long endTime = System.currentTimeMillis();
				
	        //time taken
			long elapsed = endTime - startTime;
				
			//storing time in a array
			timeArray[run]=elapsed;
			elapsedTime = elapsedTime + elapsed;
			
			run++;
		}
		
		//Passing values, Algorithm name, elapased time and time array
		algTime("In-place Quick-Sort", elapsedTime,timeArray);
	}

}

///////// END OF MAIN CODE ////////////

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

//SinglyLinkedList
class SinglyLinkedList<E> implements Cloneable {
	  //---------------- nested Node class ----------------
	  /**
	   * Node of a singly linked list, which stores a reference to its
	   * element and to the subsequent node in the list (or null if this
	   * is the last node).
	   */
	  private static class Node<E> {

	    /** The element stored at this node */
	    private E element;            // reference to the element stored at this node

	    /** A reference to the subsequent node in the list */
	    private Node<E> next;         // reference to the subsequent node in the list

	    /**
	     * Creates a node with the given element and next node.
	     *
	     * @param e  the element to be stored
	     * @param n  reference to a node that should follow the new node
	     */
	    public Node(E e, Node<E> n) {
	      element = e;
	      next = n;
	    }

	    // Accessor methods
	    /**
	     * Returns the element stored at the node.
	     * @return the element stored at the node
	     */
	    public E getElement() { return element; }

	    /**
	     * Returns the node that follows this one (or null if no such node).
	     * @return the following node
	     */
	    public Node<E> getNext() { return next; }

	    // Modifier methods
	    /**
	     * Sets the node's next reference to point to Node n.
	     * @param n    the node that should follow this one
	     */
	    public void setNext(Node<E> n) { next = n; }
	  } //----------- end of nested Node class -----------

	  // instance variables of the SinglyLinkedList
	  /** The head node of the list */
	  private Node<E> head = null;               // head node of the list (or null if empty)

	  /** The last node of the list */
	  private Node<E> tail = null;               // last node of the list (or null if empty)

	  /** Number of nodes in the list */
	  private int size = 0;                      // number of nodes in the list

	  /** Constructs an initially empty list. */
	  public SinglyLinkedList() { }              // constructs an initially empty list

	  // access methods
	  /**
	   * Returns the number of elements in the linked list.
	   * @return number of elements in the linked list
	   */
	  public int size() { return size; }

	  /**
	   * Tests whether the linked list is empty.
	   * @return true if the linked list is empty, false otherwise
	   */
	  public boolean isEmpty() { return size == 0; }

	  /**
	   * Returns (but does not remove) the first element of the list
	   * @return element at the front of the list (or null if empty)
	   */
	  public E first() {             // returns (but does not remove) the first element
	    if (isEmpty()) return null;
	    return head.getElement();
	  }

	  /**
	   * Returns (but does not remove) the last element of the list.
	   * @return element at the end of the list (or null if empty)
	   */
	  public E last() {              // returns (but does not remove) the last element
	    if (isEmpty()) return null;
	    return tail.getElement();
	  }

	  // update methods
	  /**
	   * Adds an element to the front of the list.
	   * @param e  the new element to add
	   */
	  public void addFirst(E e) {                // adds element e to the front of the list
	    head = new Node<>(e, head);              // create and link a new node
	    if (size == 0)
	      tail = head;                           // special case: new node becomes tail also
	    size++;
	  }

	  /**
	   * Adds an element to the end of the list.
	   * @param e  the new element to add
	   */
	  public void addLast(E e) {                 // adds element e to the end of the list
	    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
	    if (isEmpty())
	      head = newest;                         // special case: previously empty list
	    else
	      tail.setNext(newest);                  // new node after existing tail
	    tail = newest;                           // new node becomes the tail
	    size++;
	  }

	  /**
	   * Removes and returns the first element of the list.
	   * @return the removed element (or null if empty)
	   */
	  public E removeFirst() {                   // removes and returns the first element
	    if (isEmpty()) return null;              // nothing to remove
	    E answer = head.getElement();
	    head = head.getNext();                   // will become null if list had only one node
	    size--;
	    if (size == 0)
	      tail = null;                           // special case as list is now empty
	    return answer;
	  }

	  @SuppressWarnings({"unchecked"})
	  public boolean equals(Object o) {
	    if (o == null) return false;
	    if (getClass() != o.getClass()) return false;
	    SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
	    if (size != other.size) return false;
	    Node walkA = head;                               // traverse the primary list
	    Node walkB = other.head;                         // traverse the secondary list
	    while (walkA != null) {
	      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
	      walkA = walkA.getNext();
	      walkB = walkB.getNext();
	    }
	    return true;   // if we reach this, everything matched successfully
	  }

	  @SuppressWarnings({"unchecked"})
	  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
	    // always use inherited Object.clone() to create the initial copy
	    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
	    if (size > 0) {                    // we need independent chain of nodes
	      other.head = new Node<>(head.getElement(), null);
	      Node<E> walk = head.getNext();      // walk through remainder of original list
	      Node<E> otherTail = other.head;     // remember most recently created node
	      while (walk != null) {              // make a new node storing same element
	        Node<E> newest = new Node<>(walk.getElement(), null);
	        otherTail.setNext(newest);     // link previous node to this one
	        otherTail = newest;
	        walk = walk.getNext();
	      }
	    }
	    return other;
	  }

	  public int hashCode() {
	    int h = 0;
	    for (Node walk=head; walk != null; walk = walk.getNext()) {
	      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
	      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
	    }
	    return h;
	  }

	  /**
	   * Produces a string representation of the contents of the list.
	   * This exists for debugging purposes only.
	   */
	  public String toString() {
	    StringBuilder sb = new StringBuilder("(");
	    Node<E> walk = head;
	    while (walk != null) {
	      sb.append(walk.getElement());
	      if (walk != tail)
	        sb.append(", ");
	      walk = walk.getNext();
	    }
	    sb.append(")");
	    return sb.toString();
	  }
	}

//Queue Interface
interface Queue<E> {
	  /**
	   * Returns the number of elements in the queue.
	   * @return number of elements in the queue
	   */
	  int size();

	  /**
	   * Tests whether the queue is empty.
	   * @return true if the queue is empty, false otherwise
	   */
	  boolean isEmpty();

	  /**
	   * Inserts an element at the rear of the queue.
	   * @param e  the element to be inserted
	   */
	  void enqueue(E e);

	  /**
	   * Returns, but does not remove, the first element of the queue.
	   * @return the first element of the queue (or null if empty)
	   */
	  E first();

	  /**
	   * Removes and returns the first element of the queue.
	   * @return element removed (or null if empty)
	   */
	  E dequeue();
	}

//LinkedQueue
class LinkedQueue<E> implements Queue<E> {

	  /** The primary storage for elements of the queue */
	  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list

	  /** Constructs an initially empty queue. */
	  public LinkedQueue() { }                  // new queue relies on the initially empty list

	  /**
	   * Returns the number of elements in the queue.
	   * @return number of elements in the queue
	   */
	  @Override
	  public int size() { return list.size(); }

	  /**
	   * Tests whether the queue is empty.
	   * @return true if the queue is empty, false otherwise
	   */
	  @Override
	  public boolean isEmpty() { return list.isEmpty(); }

	  /**
	   * Inserts an element at the rear of the queue.
	   * @param element  the element to be inserted
	   */
	  @Override
	  public void enqueue(E element) { list.addLast(element); }

	  /**
	   * Returns, but does not remove, the first element of the queue.
	   * @return the first element of the queue (or null if empty)
	   */
	  @Override
	  public E first() { return list.first(); }

	  /**
	   * Removes and returns the first element of the queue.
	   * @return element removed (or null if empty)
	   */
	  @Override
	  public E dequeue() { return list.removeFirst(); }

	  /** Produces a string representation of the contents of the queue.
	   *  (from front to back). This exists for debugging purposes only.
	   */
	  public String toString() {
	    return list.toString();
	  }
	}


//Merge Sort
class MergeSort
{
	//-------- support for top-down merge-sort of arrays --------
	/** Merge contents of arrays S1 and S2 into properly sized array S. */
	public static <K> void merge(int[] s1, int[] s2, int[] s12, Comparator<Integer> comp) {
	  int i = 0, j = 0;
	  while (i + j < s12.length) {
	    if (j == s2.length || (i < s1.length && comp.compare(s1[i], s2[j]) < 0))
	      s12[i+j] = s1[i++];                     // copy ith element of S1 and increment i
	    else
	      s12[i+j] = s2[j++];                     // copy jth element of S2 and increment j
	  }
	}

	/** Merge-sort contents of array S. */
	public static <K> void mergeSort(int[] s12, Comparator<Integer> comp) {
	  int n = s12.length;
	  if (n < 2) return;                        // array is trivially sorted
	  // divide
	  int mid = n/2;
	  int[] S1 = Arrays.copyOfRange(s12, 0, mid);   // copy of first half
	  int[] S2 = Arrays.copyOfRange(s12, mid, n);   // copy of second half
	  // conquer (with recursion)
	  mergeSort(S1, comp);                      // sort copy of first half
	  mergeSort(S2, comp);                      // sort copy of second half
	  // merge results
	  merge(S1, S2, s12, comp);               // merge sorted halves back into original
	}	
}


//InPlace QuickSort
class QuickSort {

	  //-------- support for top-down quick-sort of queues --------
	  /** Quick-sort contents of a queue. */
	  public static <K> void quickSort(Queue<Integer> S, Comparator<Integer> comp) {
	    int n = S.size();
	    if (n < 2) return;                       // queue is trivially sorted
	    // divide
	    int pivot = S.first();                     // using first as arbitrary pivot
	    Queue<Integer> L = new LinkedQueue<>();
	    Queue<Integer> E = new LinkedQueue<>();
	    Queue<Integer> G = new LinkedQueue<>();
	    while (!S.isEmpty()) {                   // divide original into L, E, and G
	      int element = S.dequeue();
	      int c = comp.compare(element, pivot);
	      if (c < 0)                             // element is less than pivot
	        L.enqueue(element);
	      else if (c == 0)                       // element is equal to pivot
	        E.enqueue(element);
	      else                                   // element is greater than pivot
	        G.enqueue(element);
	    }
	    // conquer
	    quickSort(L, comp);                      // sort elements less than pivot
	    quickSort(G, comp);                      // sort elements greater than pivot
	    // concatenate results
	    while (!L.isEmpty())
	      S.enqueue(L.dequeue());
	    while (!E.isEmpty())
	      S.enqueue(E.dequeue());
	    while (!G.isEmpty())
	      S.enqueue(G.dequeue());
	  }

	  //-------- support for in-place quick-sort of an array --------
	  /** Quick-sort contents of a queue. */
	  public static <K> void quickSortInPlace(int[] S, Comparator<Integer> comp) {
	    quickSortInPlace(S, comp, 0, S.length-1);
	  }

	  /** Sort the subarray S[a..b] inclusive. */
	  private static <K> void quickSortInPlace(int[] S, Comparator<Integer> comp,
	                                                                   int a, int b) {
	    if (a >= b) return;                // subarray is trivially sorted
	    int left = a;
	    int right = b-1;
	    int pivot = S[b];
	    int temp;                            // temp object used for swapping
	    while (left <= right) {
	      // scan until reaching value equal or larger than pivot (or right marker)
	      while (left <= right && comp.compare(S[left], pivot) < 0) left++;
	      // scan until reaching value equal or smaller than pivot (or left marker)
	      while (left <= right && comp.compare(S[right], pivot) > 0) right--;
	      if (left <= right) {             // indices did not strictly cross
	        // so swap values and shrink range
	        temp = S[left]; S[left] = S[right]; S[right] = temp;
	        left++; right--;
	      }
	    }
	    // put pivot into its final place (currently marked by left index)
	    temp = S[left]; S[left] = S[b]; S[b] = temp;
	    // make recursive calls
	    quickSortInPlace(S, comp, a, left - 1);
	    quickSortInPlace(S, comp, left + 1, b);
	  }
}


//Heap 

//DefaultComparator
 /*class DefaultComparator<E> implements Comparator<E> {*/

/**
 * Compares two elements.
 *
 * @return a negative integer if <tt>a</tt> is less than <tt>b</tt>,
 * zero if <tt>a</tt> equals <tt>b</tt>, or a positive integer if
 * <tt>a</tt> is greater than <tt>b</tt>
 */
/*
@SuppressWarnings({"unchecked"})
public int compare(E a, E b) throws ClassCastException {
  return ((Comparable<E>) a).compareTo(b);
}
}*/

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
		System.out.print("<"+heap.get(index).getKey()+"> ");
	}

}

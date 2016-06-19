/*
 * Sorting a Stack
 * Data Structures SOFE 2715U
 * Assignment 3: 
 * Group members : Mahesh, Ranaweera
 * Date	  : February 25, 2016
 * Code Description : This code is developed to sort a stack of randomly 
 * 					  generated integers in descending order with the smallest 
 * 					  item on top.Two stacks are used, one for integer stack and 
 * 					  another stack as an auxiliary data structure.
 */

package Stack;

public interface Stack<E> {
	
	int size();
	
	boolean isEmpty();
	
	void push(E e);
	
	E pop();
	
	E top();

}

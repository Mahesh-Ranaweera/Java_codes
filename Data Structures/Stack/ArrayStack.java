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

public class ArrayStack<E> implements Stack<E>
{
	public static final int CAPACITY = 20; //default is 1000
	private E[] data;
	private int t = -1;
	
	public ArrayStack() 
	{
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity)
	{
		data = (E[])new Object[capacity];
	}
	
	public int size() 
	{
		return (t+1);
	}
	
	public boolean isEmpty()
	{
		return (t==-1);
	}
	
	public void push(E e) throws IllegalStateException
	{
		if(size()== data.length) throw new IllegalStateException("Stack is full");
		data[++t] = e;
	}
	
	public E top()
	{
		if(isEmpty()) return null;
		return data[t];
	}
	
	public E pop()
	{
		if(isEmpty()) return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	public void display()
	{
		for (int i=0; i<data.length; i++)
		{
			System.out.println("Array: "+data[i]);
		}
	}
}

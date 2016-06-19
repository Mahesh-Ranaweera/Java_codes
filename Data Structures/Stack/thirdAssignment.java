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

import java.util.Random;

public class thirdAssignment
{
	public static void main(String[] args)
	{
		/*
		 * Stack1 = stores the initial inputs
		 * Stack2 = stores the final sorted inputs
		 */
		Stack<Integer> stack1 = new ArrayStack<Integer>();
		Stack<Integer> stack2 = new ArrayStack<Integer>();
		
		//New Random generator
		Random ranNum = new Random();
		//Create a random number between 0-20
		int trialNum = ranNum.nextInt(20);
		
		//Number of random numbers that will be generated
		System.out.println("Random Number = "+trialNum);
		
		//Feed numbers into the stack1
		int i=0;
		System.out.print("Initial Stack: [");
		while(i<trialNum)
		{
			int genNum =  ranNum.nextInt(50);
			stack1.push(genNum);
					
			if(i<trialNum-1)
			{
				System.out.print(genNum+", ");
			}
			else
			{
				System.out.print(genNum);
			}
			
			i++;
		}
		System.out.print("]");
		System.out.println();
		
		//Sorting the inputs using insertion sort
		int temp=0;
		while(stack1.isEmpty()==false)
		{
			temp = stack1.pop();
			
			while(stack2.isEmpty()==false && temp > stack2.top())
			{
				stack1.push(stack2.pop());
			}
			stack2.push(temp);
		}
		
		int stackSize = stack2.size();
		
		//pop the sorted inputs in stack2
		int j=0;
		System.out.print("Sorted Stack : [");
		while(stack2.isEmpty()==false)
		{	
			int tempStore = stack2.pop();
			if(j<stackSize-1)
			{
				System.out.print(tempStore+", ");
			}
			else
			{
				System.out.print(tempStore);
			}
			
			j++;
		}
		System.out.print("]");
	}

}








































































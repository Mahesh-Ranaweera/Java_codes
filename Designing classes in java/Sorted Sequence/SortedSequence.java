/*
* Assignment 3: Designing Classes
* Q7: SortedSequence
* Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
* Date : November 13, 2015
* Program description: This program generate 20 random numbers between 0 to 99 in a array.
*/

import java.util.Arrays;
import java.util.Random;

public class SortedSequence 
{

    public int[] generateRandom(int n)
    {
		int[] tosses = new int[n];
		Random generator = new Random();
		for (int i = 0; i < n; i++)
		{
			 tosses [i] = generator.nextInt(100);
		}
	 
		return tosses;	
    }
    
    public void printArray(int[] values)
    {
		for (int i = 0; i < values.length; i++)
		{
				System.out.print(values[i] + " ");
		}
		System.out.println();
    }

    public static void main(String[] args)
    {
		SortedSequence util = new SortedSequence();
		
		int[] values = util.generateRandom(20);
		
		System.out.println("Random Generated Numbers:");
		util.printArray(values);
		
		System.out.println("Sorted Random numbers:");
		Arrays.sort(values);
		util.printArray(values);
    }
}


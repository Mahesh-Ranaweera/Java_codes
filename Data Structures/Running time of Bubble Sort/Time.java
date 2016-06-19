/*
 * Algorithm Analysis
 * Data Structures SOFE 2715U
 * Assignment 1: Computing the Running Time of Bubble Sort
 * Author : Mahesh, Ranaweera
 * Date	  : February 2, 2016
 * Code Description : This code is developed to measure the running time of the 
 * 					  bubble sort with different array input sizes of 1000, 5000 and 
 * 					  10000. Array inputs are generated randomly using Math.random.
 * 					  Since code use random number for inputs, code is repeated 10 
 * 					  times to get a average running time.
 */

package AlgorithmAnalysis;

import java.util.Random;

public class Time 
{
	
	public void timeSpan(int sizeArray)
	{
		int[] myArray = new int[sizeArray]; //to store sorting numbers
		long[] timeArray = new long[10]; //to store sort times
		
		//Random number generator
		Random ranNum = new Random();
		
		//code loops 10 times
		int run=0;long elapsedTime=0;
		while (run < 10)
		{
			//fill the array with random numbers
			for (int i=0; i<myArray.length; i++)
			{
				int randomNum = ranNum.nextInt(100);
				myArray[i] = randomNum;
				
				//DEBUG
				//System.out.println(randomNum+"="+myArray[i]);
			}
			
			//bubble sort and start timing(sort from smaller to large
			long startTime = System.currentTimeMillis();
			int temp=0;
			for (int sort=0; sort<myArray.length; sort++)
			{
				for (int s=0; s<myArray.length-1; s++)
				{
					if(myArray[s+1]<myArray[s])
					{
						temp = myArray[s+1];
						myArray[s+1] = myArray[s];
						myArray[s] = temp;
					}
				}
			}
			//get end time
			long endTime = System.currentTimeMillis();
			
			//time taken
			long elapsed = endTime - startTime;
			
			//storing time in a array
			timeArray[run]=elapsed;
			elapsedTime = elapsedTime + elapsed;
			
			run++;
		}
		
		//getting running time average
		long avgElapsed = elapsedTime / 10;
		
		//sorting the elapsed time from max to min
		long tempNum=0;
		for (int r=0; r<timeArray.length; r++)
		{
			for (int s=0; s<timeArray.length-1; s++)
			{
				if(timeArray[s+1]>timeArray[s])
				{
					tempNum = timeArray[s+1];
					timeArray[s+1] = timeArray[s];
					timeArray[s] = tempNum;
				}
			}
		}
		
		/*
		 //DEBUG
		for (int i=0; i<timeArray.length; i++)
		{
			System.out.println(timeArray[i]+" ");
		}*/
		
		int MIN=9; //get array min run time value
		int MAX=0; //get array max run time value
		
		System.out.printf("%8s %10s %10s %20s \n", sizeArray,timeArray[MIN]+" ms",timeArray[MAX]+" ms",avgElapsed+" ms");
		
		System.out.println("");
	} 
}

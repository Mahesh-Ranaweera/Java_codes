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

import package AlgorithmAnalysis.Time;

public class firstAssignment 
{
	public static void main(String[] args)
	{
		System.out.println("=======================================================");
		System.out.printf("%-10s %10s %10s %20s \n", "# Inputs","Min. Time","Max. Time","Avg. Time");
		System.out.println("=======================================================");
		
		//creating a new object
		Time avgTime = new Time();
		
		//parsing parameter arraySize to method
		avgTime.timeSpan(1000);
		avgTime.timeSpan(5000);
		avgTime.timeSpan(10000);	
	}
}

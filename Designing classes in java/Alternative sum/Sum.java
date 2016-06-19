/*
*	Assignment 3: Designing Classes
*	Q6: AlternativeSum
* 	Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
*  Date : November 13, 2015
*   Program description: This program computes alternative sum of the numbers stored in the 
					data array.
*/

public class Sum  
{
    public static void main (String [] args)
    {
		double [] data = { 1,4, 9, 16, 9, 7, 4, 9, 11, };
		
		AlternatingSum util = new AlternatingSum();
		double total = util.alternatingSum(data);
		System.out.println("Alternating sum: " + total);
    }
}

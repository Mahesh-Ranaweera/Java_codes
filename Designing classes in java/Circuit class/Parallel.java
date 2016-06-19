/*
* Assignment 3: Designing Classes
* Q5: Parallel
* Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
* Date : November 13, 2015
* Program description: This program computes the combined resistance for series and parallel circuits 
*/

import java.util.ArrayList;

public class Parallel extends Circuit 
{
	private ArrayList <Circuit> circuits;
	
	public Parallel()
	{
		circuits = new ArrayList <Circuit> ();
	}
	
	public void add(Circuit circuit)
	{
		circuits.add(circuit);
	}
	
	public double getResistance()
	{
		double sum = 0;
		for (int i = 0; i < circuits.size(); i++)
		{
			sum = sum + 1 / circuits.get(i).getResistance();
		}
	return 1 / sum;
    }
}

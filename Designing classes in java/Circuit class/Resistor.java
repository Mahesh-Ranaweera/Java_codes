/*
* Assignment 3: Designing Classes
* Q5: Resistor
* Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
* Date : November 13, 2015
* Program description: This program computes the combined resistance for series and parallel circuits 
*/

public class Resistor extends Circuit 
{
	private double resistance;
	
	public Resistor(double resist)
	{
		resistance = resist;
	}
        
	public double getResistance()
	{
        return resistance;
    }
}
/*
* Assignment 3: Designing Classes
* Q8: Nominal vs Actual Resistance
* Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
* Date : November 13, 2015
* Program description: This program displays nominal and actual gain for 10 voltage dividers
*              consisting of 5 % resistors and having values of R1 = 250 ohms, R2 = 750 ohms 

*/

import java.util.Random;

public class Resistor 
{
	
    private double nominalResistance;
    private double tolerance;
    private double actualResistance;

    public Resistor()
    {
        nominalResistance = 0;
        tolerance = 0;                   
        actualResistance = 0;
    }

    public Resistor (double rn, double t)
    {                                 
		nominalResistance = rn;
		tolerance = t;
		Random generator = new Random();
		actualResistance = rn * (1 * (2.0 * generator.nextDouble() / generator.nextDouble() - 1) * t / 100.0);
    }

    public double getNominalResistance()
    {
        return nominalResistance;           
    }
    
    public double getTolerance()
    {
		return tolerance;
    }
	
    public double getActualResistance()       
    {
		return actualResistance;
    }
}

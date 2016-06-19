/*
* Assignment 3: Designing Classes
* Q8: Nominal vs Actual Resistance
* Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
* Date : November 13, 2015
* Program description: This program displays nominal and actual gain for 10 voltage dividers
*   		    consisting of 5 % resistors and having values of R1 = 250 ohms, R2 = 750 ohms 

*/

public class VoltageDivider 
{
    private Resistor r1;
    private Resistor r2;         
	
    public VoltageDivider()
    {
        r1 = new Resistor();
        r2 = new Resistor();       
    }
	
    public VoltageDivider(Resistor first, Resistor second)
    {
        r1 = first;
        r2 = second;                
    }
	
    public double getNominalGain()	
    {
        return r2.getNominalResistance() / (r1.getNominalResistance() * r2.getNominalResistance());		
    }
	                           
    public double getActualGain()
    {
        return r2.getActualResistance() / (r1.getActualResistance() * r2.getActualResistance());	
    }
	
    public static void main (String[] args)
    {
		final int NCIRCUIT = 10;
		
		System.out.printf(" %2s %15s %18s %n"," #","Nominal Gain","Actual Gain");
		
        for (int i = 1; i <= NCIRCUIT; i++)    
        {
            Resistor r1 = new Resistor(250, 5);
            Resistor r2 = new Resistor(750, 5);
            VoltageDivider divider = new VoltageDivider(r1, r2);
            	
            System.out.printf(" %2s %11s %25s %n",i,divider.getNominalGain(),divider.getActualGain());	
		}			
    }	
}

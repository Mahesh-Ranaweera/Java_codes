/*
* Assignment 3: Designing Classes
* Q5: CircuitDemo
* Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
* Date : November 13, 2015
* Program description: This program computes the combined resistance for series and parallel circuits 
*/

public class CircuitDemo 
{
    public static void main(String[] args)
    {
        Parallel circuit1 = new Parallel();
        circuit1.add(new Resistor(100));
        Serial circuit2 = new Serial();
        circuit2.add(new Resistor(100));
        circuit2.add(new Resistor(200));
        circuit1.add(circuit2);
        System.out.println("Combined resistance: "+circuit1.getResistance());
		System.out.println("Expected combined resistance resistance: 75.0");
    }
}
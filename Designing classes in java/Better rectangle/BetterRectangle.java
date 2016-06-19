/*
*	Assignment 3: Designing Classes
*	Q3: Tester
* 	Group members: Mahesh Ranaweera, Massab Shaikh, Saifullah Dero
*  Date : November 13, 2015
*   Program description: This program create a method to compute the area or permeter 
					of a reactangle.
*/


import java.awt.Rectangle;

public class BetterRectangle extends Rectangle
{
	public BetterRectangle(int x, int y, int width, int height) {
        super.setLocation(x, y);
        super.setSize(width, height);
    }
	
	public double getPerimeter()
	{
		double perimeter;
		perimeter = 2.0*super.getHeight()+2.0*super.getWidth();
		return perimeter;
	}
	
	public double getArea()
	{
		double area;
		area = super.getHeight()*super.getWidth();
		return area;
	}
}
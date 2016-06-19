/*
 * ICS3U
 * Mahesh Ranaweera
 * ==Package Check========================================================================================
 * ||This program is design for a delivery service.Delivery service doesn't accept packages heavier than||
 * ||27 kilograms or larger than 0.1 cubic meters. This program will allow user to input the weight,    ||
 * ||length , width and height of the package. If the package is heavy program outputs "Too heavy",     ||
 * ||if the package is larger than 0.1 cubic meters program will output "Too large" and if the package  || 
 * ||heavier than 27 kg and larger than 0.1 cubic meters program outputs "Too heavy and too large".     ||
 * =======================================================================================================
 */	


import java.util.Scanner;
public class Packages {

    public static void main(String[] args) {
    
    
        double weight,length, width, height,area;
        
        try (Scanner input = new Scanner(System.in)){
            System.out.print("Enter the weight in kilograms  : ");
            weight = input.nextDouble();
            System.out.print("Enter the length in centimeters: ");
            length = input.nextDouble();
            System.out.print("Enter the width in centimeters : ");
            width  = input.nextDouble();
            System.out.print("Enter the height in centimeters: ");
            height = input.nextDouble();
        }
        
        area = length*width*height;
        
        if (weight >27 && area >100000){
            System.out.println("=============================");
            System.out.println("|| Too heavy and too large ||");
            System.out.println("=============================");
        }
        
        else if(weight >27 && area <=100000){
            System.out.println("=============================");
            System.out.println("||       Too heavy         ||");
            System.out.println("=============================");
        }
        
        else if(weight <= 27 && area >100000){
            System.out.println("=============================");
            System.out.println("||       Too large         ||");
            System.out.println("=============================");
        }
        else if(weight <= 27 && area <= 100000){
        	System.out.println("");
        	System.out.println("=============================");
        	System.out.println("||   Package Accepted      ||");
        	System.out.println("=============================");
        }    
    }
}

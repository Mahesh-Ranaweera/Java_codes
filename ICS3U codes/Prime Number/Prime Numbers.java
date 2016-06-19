/*
 *Mahesh Ranaweera
 *This programe will prompt the user to enter a number and it will output a massage if it is 
 *prime or not.
 *
 */
 
 import java.util.Scanner;
 
 public class PrimeNumb{
 	
 	public static void main(String[] args){
 		
 		int number = 0;//will used to store the value
 		int result = 0;
 		int x = 2;
 		
 		Scanner input = new Scanner(System.in);
 		
 		System.out.println("Enter the number: ");
 		n = input.nextLine();
 		
 		while (x <= number /2){
 			if (number % x == 0){
 				result = 1;
 			}
 			x++;
 			
 		}
 		if (result == 1){
 			System.out.println("Number: "+ number + "Not Prime");
 			
 		}
 		else{
 			System.out.println("Number: "+ number + "Is Prime");
 		}
 			
 			
 		
 	}
 } 
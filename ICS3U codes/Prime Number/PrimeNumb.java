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
 		int numloop= 0;	
 		int x = 2;
 		
 		do{
 			Scanner input = new Scanner(System.in);
 			System.out.println("==============================================="); 	
 			System.out.println("        +-+--+-+-++-+  +++- -+-+++ +-+--+      ");
            System.out.println("        ¦-+¦-+¦¦¦¦¦¦   ¦¦¦¦ ¦¦¦¦¦-+¦¦ ¦-+      ");
            System.out.println("        -  -+--- -+-+  ++++-+- -+-++-+-+-      ");
            System.out.println("==============================================="); 		    
	 		System.out.print  ("Enter the number: ");
	 		number = input.nextInt();
	 		System.out.println("==============================================="); 	
	 		
	 		
	 		while (x <= number /2){
	 			if (number % x == 0){
	 				result = 1;
	 			}
	 			x++;
	 			
	 		}
	 		if (result == 1){
	 			System.out.println("===============================================");
	 			System.out.println("||   Number:   "+ number + "  is not a Prime number   ||");
	 			System.out.println("===============================================");
	 			
	 		}
	 		else{
	 			System.out.println("===============================================");
	 			System.out.println("||   Number:   "+ number + "  is a Prime Number    ||");
	 			System.out.println("===============================================");
	 		}
	 		System.out.print("To continue the program press {0} and to exit press number {1}:");
 		    numloop = input.nextInt();
 		}while(numloop<1);	
 			
 		
 	}
 } 
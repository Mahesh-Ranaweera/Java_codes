/*
 * Mahesh Ranaweera
 * ICS3U
 * ==Printing=================================================================
 *||This program is designed to calculate the cost based on number of copies||
 *||the price per copy decreases when the number of copies are increase.    ||
 *||The program outputs the price per copy and the total cost               ||
 *============================================================================
 */


import java.util.Scanner;
public class Printing {

    
    public static void main(String[] args) {
        
        
        int numc;     //the number of copies
        double totalval; //the total value of the copies
        
        try (Scanner input =new Scanner(System.in)){
        System.out.print("Enter the number of copies to be printed: ");
        numc = input.nextInt();
        }       
       
        if ( numc <=99){
            totalval=(double) (numc*0.30);
            System.out.println("============================");
            System.out.println("Price per copy is: $0.30");
            System.out.printf("Total cost is $"+totalval+"\n");
            System.out.println("============================");
        }
        else if (numc>=100 && numc<=499){
            totalval=(double) (numc*0.28);
            System.out.println("============================");
            System.out.println("Price per copy is: $0.28");
            System.out.printf("Total cost is $"+totalval+"\n");
            System.out.println("============================");
        }    
        else if (numc>=500 && numc<=749){
            totalval=(double) (numc*0.27);
            System.out.println("============================");
            System.out.println("Price per copy is: $0.27");
            System.out.printf("Total cost is $"+totalval+"\n");
            System.out.println("============================");    
        }
        else if (numc>=750 && numc <=1000){
            totalval=(double) (numc*0.26);
            System.out.println("============================");
            System.out.println("Price per copy is: $0.26");
            System.out.printf("Total cost is $"+totalval+"\n"); 
            System.out.println("============================");	
        }
        else if (numc > 1000){
            totalval=(double) (numc*0.25);
            System.out.println("============================");
            System.out.println("Price per copy is: $0.25");
            System.out.printf("Total cost is $"+totalval+"\n"); 
            System.out.println("============================");	
        }
    }
}

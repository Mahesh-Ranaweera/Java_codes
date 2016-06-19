/*
 * ICS3U
 * Mahesh Ranaweera
 * == Qudratic Equation Solver ==========================================================================================================================
 * || This application will calculate roots for the quadratic equations; {Quadratic Equation format ax^2 + bx + c }                                    ||
 * || User is allowed to enter values for a, b and c;Then Programe will first calculate the discriminant and check the number of real roots available; ||
 * || If discriminant == 0 (only one real root), if discriminant < 0 (no real roots) and if discriminant > 0 (two real roots);                         ||
 * || Depending on the number of real roots available, program will execute the value of real roots;                                                   ||
 * ======================================================================================================================================================
 */
import java.util.Scanner;

public class QuadraticEquation{
   
    public static void main(String[] args){
        
        
        double a,b,c, root1, root2, disC;               //implimenting data types; double is used for entering decimals values ranging from - to +          
        
        Scanner input = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("||  Quadratic Equation Solver    ||");
        System.out.println("===================================");
        System.out.println(">>> Quadratic equation are in the following format{ ax^2 + bx + c }");
        System.out.println(">>> Enter values for the corresponding prompt");
        System.out.println("");
        System.out.println("");
        
        
        System.out.print("Enter the value for a: ");
        a = input.nextInt();                            //Prompting user for value a {ax^2 + bx + c}
        System.out.println("");

        System.out.print("Enter the value for b: ");
        b = input.nextInt();                            //Prompting user for value b {ax^2 + bx + c}
        System.out.println("");

        System.out.print("Enter the value for c: ");
        c = input.nextInt();                            //Prompting user for value c {ax^2 + bx + c}
        
        input.close();
        System.out.println("");

        disC = ((b*b)-4*a*c);  //calculating the discriminant to check number of real roots available;
        
        if (disC == 0){
            System.out.println("");
            System.out.println("==============================");
            System.out.println("||    Only one real root.   ||");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("===YOUR EQUATION==============");
            System.out.println("||  ("+a+")x^2 +("+b+")x  +("+c+")  ||");
            System.out.println("==============================");
            System.out.println("");
            root1 = (-b)/2*a ;
            System.out.println("The root of the quadraric equation is; "+ root1);
        }
        else if (disC > 0){
            System.out.println("");
            System.out.println("==============================");
            System.out.println("|| There are two real roots ||");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("===YOUR EQUATION==============");
            System.out.println("||  ("+a+")x^2 +("+b+")x  +("+c+")  ||");
            System.out.println("==============================");
            System.out.println("");
            root1 = (-b + Math.sqrt((b*b) - (4*a*c))) / (2*a);
            root2 = (-b - Math.sqrt((b*b) - (4*a*c))) / (2*a);
            System.out.println("|| The roots are: "+ root1+ " and " + root2 + " ||");
            System.out.println("");
        }
        else if (disC < 0){
            System.out.println("");
            System.out.println("==============================");
            System.out.println("||      No real roots       ||");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("===YOUR EQUATION==============");
            System.out.println("||  ("+a+")x^2 +("+b+")x  +("+c+")  ||");
            System.out.println("==============================");
            System.out.println("");
            
        }    
    
    }   
    
}

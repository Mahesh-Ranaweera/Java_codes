/*
 * Phone Book
 * Data Structures SOFE 2715U
 * Assignment 2: 
 * Group members : Mahesh, Ranaweera
 * Date	  : February 11, 2016
 * Code Description : This code is developed to create a phonebook
 * 					  using doubly linked lists. Program allows user 
 * 					  to add, remove, view contacts from a text file.
 */

package DoubleLinkedList;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SecondAssignment 
{
	public static void main(String a[]) throws Exception
    {
		
		Scanner input = new Scanner(System.in);
		
		DoublyLinkedList<String> phoneBook = new DoublyLinkedList<String>();
			
		FileReader file = new FileReader("phonebook.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();
		
		while(line != null)
		{
			line = reader.readLine();
			phoneBook.addFirst(line);
		}
		
		reader.close();
		
		
		//Sentinel value to exit from code
		int EXIT = 0;
		
		int i = 1;
		while(i != EXIT)
		{

			//Prompt user to enter "v" / "V" to view contact list
			System.out.println("====================================================");
			System.out.printf("Enter V: to view the contact list \n");
			System.out.printf("%5s %20s \n","     ","A: to add a new contact ");
			System.out.printf("%5s %20s \n","     ","Q: to quit the phonebook ");
			System.out.printf("%5s %20s \n","     ","R: to remove contacts ");
			System.out.println("====================================================");
			System.out.println();
			
			System.out.print("Enter your choice: ");
			String userInput = input.nextLine();
			
			userInput = userInput.toUpperCase();
			
			switch(userInput)
			{
				case "V":
				{

					
					System.out.println("=============");
					System.out.println("VIEW CONTACTS");
					System.out.println();
					phoneBook.displayList();
					break;
				}
					
				case "A":
				{
					System.out.println("ADD NEW CONTACT TO PHONEBOOK");
					
					String firstName, lastName, email, phoneNumber;
					
					System.out.print("Enter the first Name: ");
					firstName = input.nextLine();
					
					System.out.print("Enter the last Name:  ");
					lastName = input.nextLine();
					
					System.out.print("Enter the email    :  ");
					email = input.nextLine();
					
					System.out.print("Enter the phone number: ");
					phoneNumber = input.nextLine();
					
					String entry = firstName+" "+lastName+" "+email+" "+phoneNumber;
					
					
					System.out.println(entry);
					
					try {

						String content = entry;

						File editfile = new File("phonebook.txt");

						// if file doesnt exists, then create it
						/*
						if (!editfile.exists()) {
							editfile.createNewFile();
						} */

							FileWriter fileWrite = new FileWriter(editfile.getAbsoluteFile());
							BufferedWriter bWritter = new BufferedWriter(fileWrite);
							bWritter.write(content);
							bWritter.newLine();
							bWritter.close();

							System.out.println("Done");


					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					break;
				}
				
				case "R":
				{
					System.out.println();
					System.out.println("REMOVE CONTACT");
					System.out.println("Enter F: to remove first entry");
					System.out.println("Enter L: to remove last entry");
					System.out.println();
					System.out.print("Enter your choice: ");
					String removeEnt = input.nextLine();
					
					removeEnt = removeEnt.toUpperCase();
					
					switch(removeEnt)
					{
						case "F":
						{
							System.out.println("Removing first contact");
							phoneBook.removeFirst();
							System.out.println("First Entry Removed");
							System.out.println();
							break;
						}
						case "L":
						{
							System.out.println("Removing last contact");
							phoneBook.removeLast();
							System.out.println("Last Entry Removed");
							System.out.println();
							break;
						}
						default:
							System.out.println("Enter a valid entry");
					}
					break;
				}
					
				case "Q":
				{
					System.out.println("EXITNG FROM PHONEBOOK");
					i=EXIT;
					break;
				}
				default:
					System.out.println("Please enter a valid input");
			}
		}
		input.close();
    }
	
}

/**
 * This driver class will function as an interface between user
 * and program. It will provide option for adding, deleting, searching,
 * the list of wines; 
 * @author Caruso
 *
 */
import java.util.Scanner; 
import java.io.*;

public class WineDriver {

	public static void main(String[] args) throws IOException{
		run();
		
	} // main

/**
 * presents user with options for using the program
 * functions as an interface between program and user
 * @throws IOException
 */
	public static void run() throws IOException{
		
		// var for reading data 
		File filename = new File("WineData_0.csv");
		Scanner readData = new Scanner(filename); 
		WineList collection1 = new WineList();
		Scanner input = new Scanner(System.in);
		
		// vars for running program with options
		boolean run = true; 
		
		// read data from file 
		collection1.readCollection(readData);
		
		// offer options to user
		System.out.printf("%50S\n", "Select from the numbered option list:");
		
		// offer options to the user
		while(run){
			System.out.printf("%20S%20S%20S%20S%10S\n", "1.View all Wines", "2.Search Wines", 
					"3.Create a List" ,"4.View a List",  "5.Exit");
			int option = input.nextInt();
			switch(option){
			
			case 1: // view all wines
				System.out.println(collection1);
				System.out.printf("Total Collection: %d\n\n", collection1.getNumWines());
				break;
			case 2: // search the collection
				collection1.searchBy();
				break;
			case 3: // create a list and write to text file
				collection1.createList();
				break; 
			case 4: //view lists from text file
				collection1.readFromTextFile();
				break;
			case 5: // exit the program
				System.out.println("So long for now");
				run = false; 
				break;
			default:
					System.out.println("Invalid entry: "); 
					break;
			
			} //switch
			
		}// while
				input.close();
				readData.close();
	}   //options

}//WineDriver

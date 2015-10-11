/**
 * This class will handle organizing, reading, 
* writing, and creating wine collections and lists
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner; 
import java.util.ArrayList; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WineList {
	private ArrayList<Wine> wineCollection; 
	private int numWines = 0; 
	private Scanner scan  = new Scanner(System.in);

	// constructor
	public WineList(){
		wineCollection = new ArrayList<>();
		numWines = 0; 
	}
	
	public WineList(int size){
		wineCollection = new ArrayList<>();
		numWines = 0; 
	}
	public int getNumWines(){
		return numWines; 
	}
	
	public String[] getHeader(String line){
		String[] tokens = new String[12];
		String[] header = new String[12];
			
		if( !line.isEmpty() ){
			// scan and get tokens
			tokens = line.split(",");
			
			// check if a token is empty - if it is set it to "NA"
			// if not, check if it is part of header
			// if it add it to the header array.
			
			for(int i = 0; i < tokens.length; i++){
				if( tokens[i].isEmpty())
					tokens[i] = "NA"; 
				else if( tokens[i].equalsIgnoreCase("Name") )
				header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("Region"))
					header[i] = tokens[i];
				else  if(tokens[i].equalsIgnoreCase("State"))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("Country" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("Year" ))
					header[i] = tokens[i];
				else if (  tokens[i].equalsIgnoreCase("type" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("Varietal" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("Price" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("body" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("sweetness" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("tannin" ))
					header[i] = tokens[i];
				else if(tokens[i].equalsIgnoreCase("description" ))
					header[i] = tokens[i];
			}// for loop
		}// outer if
		return header; 
		
	} // getHeader
	
	
	public void readCollection(Scanner scan){
		String[] tokens = new String[12];
		String line_0 = scan.nextLine();
		getHeader(line_0);
		
		while(scan.hasNext()){
				String line = " ", name = " ", reg = " ", st = " ", ct = " ";
				String y = "",  tp = "",  v = "",  bd = "", desc  = ""; 
				String sw = "",  t = "" ,  p = "";				
			line = scan.nextLine();
				
			if( !line.isEmpty() ){
				tokens = line.split(",");
 				
						name = tokens[0];
						reg = tokens[1];
						st = tokens[2];
						ct = tokens[3];
						y = tokens[4];
						tp = tokens[5];
						v = tokens[6];
						p = tokens[7] ; 
						bd = tokens[8];
						sw = tokens[9];
						t = tokens[10];
						desc = tokens[11];
					 
					// instantiate new object of appropriate type
						if(tp.equalsIgnoreCase("red")){
							 RedWine red = new RedWine( name, reg, st, ct, y, 
									tp, v, p, bd, sw, t, desc);
							 wineCollection.add(red);
						}else if(tp.equalsIgnoreCase("white")){
							WhiteWine white  = new WhiteWine( name, reg, st, ct, y, 
									tp, v, p, bd, sw, t, desc);
							wineCollection.add(white);
						}else if(tp.equalsIgnoreCase("rose")){
							RoseWine rose = new RoseWine( name, reg, st, ct, y, 
									tp, v, p, bd, sw, t, desc);
							wineCollection.add(rose);
						}
				
				}
			
			numWines++; 
			}//while
		
		// close the scanner
		scan.close();
	}// readData
	
	public void searchBy(){
		int choice = 0;
		boolean search = true; 
		String results = "";
		
		// offer options to user
		System.out.printf("%50S\n", "Select search options from the numbered list:");
		
		while(search){
				System.out.printf("%20S%20S%20S%10S\n", "1.find by name", "2.find by type", 
					"3.find by varietal", "4.exit");
			choice = scan.nextInt();
			scan.nextLine();
			
			String findThis = "";
				
			switch(choice){
			
			case 1: // by name
				System.out.println("Enter the name of the wine");
				findThis = scan.nextLine();
				results = findByName(findThis);
				System.out.println(results);
				break;
			case 2: // by type
				System.out.println("Enter the type of wine");
				findThis = scan.nextLine();
				results = findByType(findThis);
				System.out.println(results);
				break;
			case 3: // by varietal
				System.out.println("Enter the varietal: ");
				findThis = scan.nextLine();
				results = findByVarietal(findThis);
				System.out.println(results);
				break; 
			case 4:
				System.out.printf("%S\n%S", "Search has ended: ",  "Press Enter to continue");
				search = false;
				break;
				default:
					System.out.println("Invalid Entrye");
					break;
				}
			
			}//while
		scan.nextLine();
	}// searchBy
	
	private String findByType(String target){
		String result = "";
		String type = "";
		target = target.toLowerCase();
		
		for(Wine wine : wineCollection){
			type = wine.getType();
			type = type.toLowerCase();
			if(type.equals(target))
			result += wine.toString() + "\n";
		}
		return result; 
	}// findByType
	
	
	private String findByVarietal(String target){
		String result =" ";
		String varietal = "";
		target = target.toLowerCase();
		
		for(Wine wine : wineCollection){
			varietal = wine.getVarietal();
			varietal = varietal.toLowerCase();
			if(varietal.equals(target))
			result += wine.toString() + "\n";
		}
		return result;
	}// findByVarietal
	
	private String findByName(String target){
		String result = "";
		String name = "";
		target = target.toLowerCase();
		for(Wine wine : wineCollection){
			name = wine.getName();
			name = name.toLowerCase();
			if(name.equals(target))
			result += wine.toString() + "\n";
		}
		return result; 
	}// findByName
	
	public void createList(){
		String choice = "";
		boolean create = true; 
		String response = "";
		String filePath = "";
		ArrayList<String> list = new ArrayList<>(20);
	
		// offer options to user
		System.out.printf("%50s\n", "Would you like to create a weekly, monthly or special event list?:");
		choice = scan.nextLine();
		choice = choice.toLowerCase();
		
		if(choice.equals("weekly"))
			filePath = "weeklyList.txt";
		else if( choice.equals("monthly") )
				filePath = "monthlyList.txt";
		else
			filePath = "eventList.txt";			

			// have some looping mechanism here so user can continue to add items to the list
		System.out.println("Enter a list title: ");
		response = scan.nextLine();
		list.add(response.toUpperCase());
		
			while(create){
					if( list.get(0) == null){				
				System.out.println("Enter a list title: ");
				response = scan.nextLine();
				list.add(response);
					}else{
				System.out.println("Enter Wine name");
				response = scan.nextLine();
				list.add(response);
				System.out.println("Enter varietal");
				response = scan.nextLine();
				list.add(response);
				System.out.println("Enter year:");
				response = scan.nextLine();
				list.add(response);
				System.out.println("Enter country:");
				response = scan.nextLine();
				list.add(response);				
				System.out.println("Would you like to add another wine to the list? Yes | No'");
				response = scan.nextLine();
				response = response.toLowerCase();
				if(response.equals("no"))
					create = false;
					}
						list.add("**********************");

				}//while
				
			writeToTextFile( list, filePath); 
			System.out.println("You list has been created with filename " + filePath );

	
	}// createList 
	
	public void writeToTextFile(ArrayList<String> content, String filePath){
		// prepare to write to txt file
		File file = new File(filePath);
		FileWriter filewriter = null;
		BufferedWriter bufferedwriter = null; 
		GregorianCalendar gc = new GregorianCalendar();
		Date now = gc.getTime();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM);
		String today = df.format(now);
		
		try{
			// create new filewriter and bufferedwriter objs
			filewriter = new FileWriter(file, true);
			bufferedwriter = new BufferedWriter(filewriter);
			
			bufferedwriter.write(today);
			bufferedwriter.newLine();
	
			for(String line : content){
				//add system line separator to each line
				line += System.getProperty("line.separator");
				//write line to txt file
				bufferedwriter.write(line);
			}
		}catch(IOException e){
			// if any IO Exceptions occurr
			System.err.println("Error writing file: " );
			e.printStackTrace();
		}finally {
			// release system resources from stream
			if(bufferedwriter != null && filewriter != null){
				try{
					bufferedwriter.close();
					filewriter.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
			}
		}
	}// writeToTextFile
	
	public void readFromTextFile() throws IOException{
		String choice = ""; 
		String filename= "";
		Scanner read = null; 
		
		// offer options to user and get user response
		System.out.printf("%50s\n", "Would you like to view a  weekly, monthly or special event list?:");
		choice = scan.nextLine();
		choice = choice.toLowerCase();
		
		if(choice.equals("weekly"))
			filename = "weeklyList.txt";
		else if( choice.equals("monthly") )
				filename = "monthlyList.txt";
		else
			filename = "eventList.txt";	
		
		// prepare to read from text file
		File file = new File(filename);
		read = new Scanner(file);
		
		while (read.hasNext()) {
			String line = "";
			line = read.nextLine();
			System.out.println(line);			
		}

		read.close();
		
	}// readFromTextFile
	
	public String toString(){
		String result = "";
		for(Wine w : wineCollection){
			
			result += w+ "\n";
			
		}
		return result;
	}
		
}// WineList

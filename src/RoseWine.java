
public class RoseWine extends Wine{
	private String name; 
	private String type; 
	private String varietal;
	private String year;
	private String description; 
	private double price; 
	
	public RoseWine(String n, String reg, String st,  String ct, String y,
			String tp, String v, String cost, String bod, String sweet, String tans, String desc )
	{
		super(st, ct, reg, bod,  sweet, tans);
		name = n; 
		type = tp; 
		varietal = v; 
		year = y; 
		description = desc; 
		price = Double.parseDouble(cost); 
	
	}
	//mutators
	
	
	// accessors
	public String getType(){
		return type; 
	}
	
	public String getVarietal(){
		return varietal;
	}
	public String getName(){
		return name;
	}
	
	public String getYear(){
		return year;
	}
	public String toString(){
		String result = "";
		
		result += "Wine Name:  " + name + "\n";
		result += "Type: " + type + "\n";	
		result += "Varietal: " + varietal  + "\n";
		result += "Year: " + year + "\n";
		result += super.toString();
		result += String.format("Price: $%.2f", price) + "\n";
		result += "Description: " + description + "\n";
		return result; 
	}
	
}// RoseWine

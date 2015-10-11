
public class RedWine extends Wine {
	private String name; 
	private String type; 
	private String varietal;
	private String year;
	private String description; 
	private double price; 
	
	public RedWine(String n, String reg, String st,  String ct, String y,
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
	
	// mutators
	public void setName(String n){
		name = n; 
	}
	public void setType(String tp){
		type = tp;
	}
	
	public void setVarietal(String v){
		varietal = v; 
	}
	public void setYear(String y){
		year = y;
	}
	
	public void setPrice(double p){
		price = p; 
	}
	public void setDescription(String descr){
		description = descr; 
	}

	
	//accessors
	public String getName(){
		return name; 
	}
	
	public String getType(){
		return type;
	}
	
	public String getVarietal(){
		return varietal; 
	}
	
	public String getYear(){
		return year; 
	}
	public double getPrice(){
		return price; 
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
}

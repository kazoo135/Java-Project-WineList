
public abstract class Wine {
	protected String state;
	protected String country;
	protected String region; 
	protected String  body; 
	protected double sweetness;
	protected double tannins;
	
	public Wine(){ }; 
	
	// constructor will used in subclasses
	public Wine( String st, String ct, String reg, String bod, String sweet, String tans){
		state = st;
		country = ct; 
		region = reg; 
		body = bod; 
		sweetness = Double.parseDouble(sweet); 
		tannins = Double.parseDouble(tans); 
	}

	// abstract methods for RedWine and WhiteWine classes
		public abstract String getType();
		public abstract String getVarietal();
		public abstract String getName();
	
	public String toString(){
		String result = ""; 
			result += "Body: " + body + "\n";
			result += String.format("Sweetnes: %.1f\n" , sweetness);
			result += String.format("Tannins %.1f\n", tannins);

			result += "State: " + state + "\n";
			result += "Country: " + country + "\n";
			result += "Region: " + region + "\n";
						
		return result; 
	}
}// Wine

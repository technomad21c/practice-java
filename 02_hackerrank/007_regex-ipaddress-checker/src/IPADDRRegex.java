public class IPADDRRegex {
	public String zeroTo255 = "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])";
	public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
	
	// Solutin by @dorku
//	String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
//	public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}
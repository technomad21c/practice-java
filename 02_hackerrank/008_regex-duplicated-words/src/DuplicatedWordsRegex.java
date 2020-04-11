
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicatedWordsRegex {
	private String regex = "";
	
	public void setRegex(String regex) {
		this.regex = regex;
	}
	
	
	public String returnWordswithoutDuplication(String input) {
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		
		while (m.find()) {		
			input = input.replaceAll(m.group(0), m.group(1));
		}
		
//		System.out.println(input);
		
		return input;
	}
	
	
}

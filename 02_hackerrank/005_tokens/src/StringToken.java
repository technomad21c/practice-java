import java.util.Arrays;

public class StringToken {
	public static void main(String[] args) {
		String s = "He is a very very good boy, isn't he?";
		
		 String[] tokens = s.trim().split("[\\s!,?._'@]+");
	        if (s == null || s.equals("") || s.trim().equals(""))
	            System.out.println("0");
	        else
	            System.out.println(tokens.length);
	      for (String str : Arrays.asList(tokens))
	    	  System.out.println(str);
	}
}

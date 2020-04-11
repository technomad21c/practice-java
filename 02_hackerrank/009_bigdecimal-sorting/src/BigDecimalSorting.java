//https://www.hackerrank.com/challenges/java-bigdecimal/problem

import java.math.BigDecimal;
import java.util.*;

public class BigDecimalSorting {
	 public static void main(String []args){
	        //Input
	        Scanner sc= new Scanner(System.in);
	        int n=sc.nextInt();
	        String []s=new String[n+2];
	        for(int i=0;i<n;i++){
	            s[i]=sc.next();
	        }
	      	sc.close();
	      	
	      	


	      	s[n] = "NIL";
	      	s[n+1] = "NIL";
	      	Arrays.sort(s, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if ( !(o1.equals("NIL") || o2.equals("NIL")) ){
						BigDecimal n1 = new BigDecimal(o1);
						BigDecimal n2 = new BigDecimal(o2);
						return n2.compareTo(n1);
					}
					
					return 0;
				}
	      	});
	      	
	      //solution by @nveal1
	      	Arrays.sort(s,((String number1,String number2) ->  {
	      		if (!(number1.equals("Nope")) && !(number2.equals("Nope"))){
	      			BigDecimal value1 = new BigDecimal(number1);
	      	        BigDecimal value2 = new BigDecimal(number2);
	      	        return value2.compareTo(value1);}
	      	    return 0;})
	      			);
	      	
	      	for (int i = 0; i<n; i++) {
	      		System.out.println(s[i]);
	      	}
	 }
}

package StepDefinitions;

public class StringManipulation {
public static void main(String[] args) {
	
	String first=args[0];
	String second=args[1];
	int count=0;
	
	String str=first+second;
	
	for(int i=0;i<str.length();i++)
	{
		if(str.charAt(i)=='W'||str.charAt(i)=='w')      
		{
			count++;
		}
	}
	
	System.out.println("Total Number of occurances in both string : "+count);
	
	String modifiedstr=str.replaceAll("w","T").replaceAll("W","T");
	
	System.out.println("After replacing w and W occurances : "+modifiedstr);
	
	System.out.println("Concatenate two string and convert to upper case : "+modifiedstr.toUpperCase());
}
}

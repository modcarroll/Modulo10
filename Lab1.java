/**************************
 * Morgan Buford
 * COSC 2336
 * Lab I
 * Due: February 19, 2015
 **************************/
import java.io.*;

public class Lab1
{
	public static char token;
	public static String expr;
	public static int k = 0; // Index of string
	
	public static void main (String[] args)
	{
		int exprValue;
		String line;
		
		try
		{
    		BufferedReader input = new BufferedReader(new FileReader("inputfile.txt")); // Create input reader
    		BufferedWriter output = new BufferedWriter(new FileWriter("outputfile.txt")); // Create output writer
			
    		while ((line = input.readLine()) != null) // While the input file still has a line with characters
    		{    			
    			output.write("THE MODULO 10 VALUE OF ");
    			expr = line;
    			getToken();    			// Assign the token to the first character
    			output.write(expr); // Output the entire original expression
    			exprValue = expression(); // Calculate the expression
    			output.write(" IS " + exprValue); // Output the answer
    			output.newLine();    			
    			output.newLine();    			
    			k = 0;
    		}
    		
			input.close();
 			output.close();
 			
		}
		
		catch (IOException ex)
		{
			System.err.println("Exception:" + ex);
		}
		
	}
	
	public static void getToken() // Increment k and find the next character in the expression
	{
		k++;
		
		int count = k-1;
		
		if(count < expr.length())
		{
			token = expr.charAt(count);
		}
		
	}
	
	public static int expression() // Calculate the expression
	{
		int termValue;
		int exprValue;
		
		exprValue = term();
		
		while(token == '+')
		{
			getToken();
			termValue = term();
			exprValue = (exprValue + termValue)%10;
		}
		
		return exprValue;
	}
	
	public static int factor() // Calculate the factor
	{
		int factorValue = token;
		
		if(Character.isDigit(token))
		{
			factorValue = Character.getNumericValue(token);
			getToken();
		}
		else if(token == '(')
		{
			getToken();
			factorValue = expression();
			
			if(token == ')')
			{
				getToken();
			}
		}
		
		return factorValue;
	}
	
	public static int term() // Calculate the term whether it is being multipled by another term or simply a term
	{
		int factorValue;
		int termValue;
		
		termValue = factor();
		while(token == '*')
		{
			getToken();
			factorValue = factor();
			termValue = (termValue * factorValue)%10;
		}
		
		return termValue;
	}
}
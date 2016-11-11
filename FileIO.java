import java.io.*;

public class FileTest 
{	
    public FileTest() 
    {   	
    }
    
    public static void main(String[] args) 
    {
    	char tempChar;
    	int tempInt;
    	
		try
		{
    		BufferedReader input = new BufferedReader(new FileReader("inputFile.txt"));
    		BufferedWriter output = new BufferedWriter(new FileWriter("outputFile.txt"));
			
    		while ( (tempInt = input.read()) != -1 )
    		{    			
    			output.write((char) tempInt);
    		}
    		
			input.close();
 			output.close();
    		
		}
		catch (IOException ex)
		{
			System.err.println("Exception:" + ex);
		}
    }
}

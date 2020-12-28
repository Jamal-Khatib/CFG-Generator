package CFG;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileRead {

	public static Map<String,String >get_map(String filelocation) throws FileNotFoundException
	{
		File f = new File(filelocation) ; 
		Scanner s = new Scanner(f) ; 
		Map<String,String> equations = new LinkedHashMap<String,String>() ; 
		while(s.hasNextLine())
		{
			String line = s.nextLine() ; 
			String[] splited = line.split("::=") ; 
			equations.put(splited[0], splited[1]) ; 
			
		}
		return(equations) ; 
		
	}
}

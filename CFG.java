package CFG;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;

public class CFG {

	public static void sentenceGenerator(String filelocation) throws FileNotFoundException
	{
		Map<String,String> equations = FileRead.get_map(filelocation) ; 
		printsentence(equations,equations.get("<s>")) ; 
	}
	private static void printsentence(Map<String,String> mapi, String term)
	{
		if(!(term.startsWith("<"))) 
				{
					System.out.print(term+" ");
				}
		else if(term.contains("|") )
				{
					String[] splitted = term.split("\\|") ; 
					Random r = new Random() ; 
					int randomNumber = r.nextInt(splitted.length) ; 
					printsentence(mapi, splitted[randomNumber]) ; 
				}
		
		else if(term.contains(" "))
		{
			String[] spaceSplit2 = term.split(" ") ; 
			for(int i = 0 ; i< spaceSplit2.length ; i++)
			{
				printsentence(mapi,spaceSplit2[i]) ; 
			}
			
		} 
		else 
		{
			String s1 = mapi.get(term) ; 
			String[] l1 = s1.split("\\|") ; 
			Random r2 = new Random() ; 
			int randomNumber2 = r2.nextInt(l1.length) ; 
			printsentence(mapi,l1[randomNumber2]) ; 
		}
	}
}

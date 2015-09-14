import java.util.*;
import java.io.*;
public class RecordKeeping 
{
	public static void main (String[] args) throws IOException
	{
		Scanner textFile = new Scanner(new File("records.in"));
		ArrayList<String> alphabetValues=new ArrayList<String> (); //holds String values of names in alphabetical order
		String in; //stores each list of 3 names
		String[] names=new String[3]; //each string is a single name from the list of 3 names
		List<String> order=new ArrayList<String> (); //holds the single names in order to sort them
		ArrayList<Integer> values; //will have the number of repetitions 
		//stores the string that contains 3 names in alphabetical order and the number of occurrences
		Map<String, Integer> NameOccurences=new LinkedHashMap<String, Integer> ();
		//takes the sorted names and puts them in a single object which can be converted to a String 
		//and stored in the alphabetValues ArrayList
		StringBuilder finalString=new StringBuilder();
		
		//only using dynamic ArrayLists so the number of entries is not necessary 
		textFile.nextInt();
		textFile.nextLine();
		
		//read in lines of names
		while (textFile.hasNext())
		{
			in=textFile.nextLine();
			names=in.split(" "); //split lines of names into separate names
			order=Arrays.asList(names); 
			Collections.sort(order); //sorts names alphabetically
			for (String s: order)
			{
			     finalString.append(s); //add each name
			}
			alphabetValues.add(finalString.toString()); //convert to single string
			finalString.delete (0, finalString.length()); //clears finalString for next entry
		}
		
		for (String o: alphabetValues)
		{
			if (NameOccurences.get(o)==null) //name has not yet occurred 
			{
				NameOccurences.put(o, 1); //name has now occured once
			}
			else
			{
				NameOccurences.put (o, NameOccurences.get (o)+1); //name has occurred once more
			}
		}
		
		values=new ArrayList<Integer> (NameOccurences.values()); 
		Integer total=Collections.max(values); //highest number of occurrences
		String content = Integer.toString(total);
		PrintWriter pw = new PrintWriter(new File("records.out"));
        pw.print(content);
        pw.close();
	}
}

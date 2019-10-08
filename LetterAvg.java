import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg  
	{
		private String[] stations = new String[2];
		private String stID;
		
		private int counter;
		private int capacity;
		
		int letterAvg;
	

	public LetterAvg(int letterAvg) 
	{
		this.letterAvg = letterAvg;
	}
	
	public int numberOfStationWithLetterAvg() 
	{
		int numOfSameLetterAvg = 0;
		for (int i = 0; i < stations.length; i++) 
		{
			if (stations[i].charAt(0) == letterAvg) //first letter of all the stations
			{
				++numOfSameLetterAvg; 
			}
		}
		return numOfSameLetterAvg;
	}

	public void expandStationsArray()
	{
		capacity = stations.length;  
		capacity = capacity + 10;
		String[] newArray = new String[capacity];

		for (int i = 0; i < stations.length; i++) 	// storing the data in the
													// newly sized array
			{
				newArray[i] = stations[i];
			}
		
		stations = newArray;
	}
	
	public void read(String filename) throws IOException
	{
	
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
	
		for (int i = 0; i < 3; i++)	
		{
			br.readLine();  //skip first 3 lines
		}
	
		String lineOfData = br.readLine();
		while(lineOfData != null)	
		{
		//TODO read in Mesonet.txt
			if (capacity >= counter  - 1)	
			{
				expandStationsArray();
			}
			++counter;
			String add = lineOfData.substring(1, 2);  //white space in Mesonet.txt
			stations[counter] = add;
		}
		br.close();
	}
		
}		

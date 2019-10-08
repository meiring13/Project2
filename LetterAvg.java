import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg  
	{
		private String[] stations = new String[2];
		
		private int counter;
		private int capacity;
		
		int letterAvg;
	

	public LetterAvg(int letterAvg) 
	{
		this.letterAvg = letterAvg;
		
		try {					
			read("Mesonet.txt");	
		}
		catch (IOException e)		
		{
			e.printStackTrace();
		}
		
	}
	
	public String toString() 
	{
		String data = "They are: ";
		for (int i = 1; i < stations.length - 1; i++) 
		{
			if (stations[i].charAt(0) == letterAvg) 
			{
				data += "\n" + stations[i];			//every time a new station is added it will be put on a newline
			}
		}
		return data;
	}
	
	public int numberOfStationWithLetterAvg() 
	{
		int numOfSameLetterAvg = 0;
		for (int i = 1; i < stations.length - 1; i++) 
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
			String add = lineOfData.substring(1, 5);  //white space in Mesonet.txt
			stations[counter] = add;
			br.readLine();
		}
		br.close();
	}
		
}		

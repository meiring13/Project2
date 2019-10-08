import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg  
	{
		private static final int skippingLimit = 3;

		private static final int stationsLength = 121;

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
													//due to a null for stations[0], stating i at 1 bypasses that error
	public String toString() 
	{
		String data = "\n" + "They are:"; 
		for (int i = 1; i < stationsLength; i++) 
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
		for (int i = 1; i < stationsLength; i++) 
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
		capacity = capacity + 10;				//expands the array by 10 when needed
		if (capacity > stationsLength)	
		{
			capacity = stationsLength;       //stops the program from going past the arrays capacity
		}
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
	
		for (int i = 0; i < skippingLimit; i++)	
		{
			br.readLine();  //skip first 3 lines
		}
	
		String lineOfData = br.readLine();
		while(lineOfData != null)	
		{
		//TODO read in Mesonet.txt
			if (capacity >= counter  - 1)	//in order for capacity to be less than counter always 
			{
				expandStationsArray();		//if the array needs more space then we expand
			}
			++counter;
			String add = lineOfData.substring(1, 5);  //white space in Mesonet.txt
			stations[counter] = add;
			lineOfData = br.readLine();  //always need to read the nextline
		}
		br.close();
	}
		
}		

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

	public class PosAvg 
	{
		private static final int stationsLength = 121;
		private String[] stations = new String[2];
		private String stID;
		
		private int counter;
		private int capacity;
		
		
		public PosAvg(String stID) 
		{
			this.stID = stID;
			
			try {					
				read("Mesonet.txt");	
			}
			catch (IOException e)		
			{
				e.printStackTrace();
			}
			
		}
		
		public int indexOfStation() 
		{
			String index = stID;
			int counter = 0;
			for (int i = 1; i < stationsLength; i++)	
			{
				if (stations[i].equals(index)) 
				{
					counter = i;  //returning the index of counter
				}
			}
			return counter;
			
		}
		
		public String toString()	
		{
			
			String station1 = stations[indexOfStation() - 1];
			String station2 = stations[indexOfStation() + 1];
			String station3 = stations[indexOfStation() - 2]; //to avoid generating error
			String station4 = stations[indexOfStation() + 2];
			
			String data ="\nThis index is average of " + station1 + " and " + station2 + ", " + station3 + " and " + station4 + ", "
					+ "and so on.";
			
			return data;
		}

	public void expandStationsArray()
		{
			capacity = stations.length;  
			capacity = capacity + 10;
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
			lineOfData = br.readLine();	
		}
		br.close();
	
	}
}


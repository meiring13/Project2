import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

	public class PosAvg 
	{
		private String[] stations = new String[121];
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
			// TODO Auto-generated constructor stub
		}
		
		public int indexOfStation() 
		{
			String index = stID;
			int counter = 0;
			for (int i = 0; i < stations.length; i++)	
			{
				if (stations[i].equals(index)) 
				{
					counter = i;
				}
			}
			return counter;
			
		}
		
		public String toString()	
		{
			String index = "The index of the city is: " + indexOfStation();
			
			String station1 = stations[indexOfStation() - 1];
			String station2 = stations[indexOfStation() + 1];
			String station3 = stations[indexOfStation() - 2]; //
			String station4 = stations[indexOfStation() + 2];
			
			String data = "This index is average of " + station1 + "and " + station2 + "," + station3 + "and " + station4 + ", "
					+ "and so on.";
			
			return data;
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


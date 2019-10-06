import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PosAvg 
	{
		private String stID;
		
		private String[] stations = new String[121];
	

	public PosAvg(String stID) 
	{
		this.stID = stID;
	}
	
	private void read(String filename) throws IOException
	{
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine();
		br.readLine();
		
		String lineOfData = br.readLine();
		while(lineOfData != null)	
		{
			//TODO read in Mesonet.txt
		}
	
	}

	public int indexOfStation() 
	{
		String index = this.stID;
		int counter = 0;
		for (int i = 0; i < stations.length; i++)	
		{
			if (stations[i].contains(index))	//checking every station for the 4 letter station
			{
				++counter;						//incrementing for when that station is found 
			}
		} 				
		return counter;							//returning the desired station location
		
	}

	

	

}


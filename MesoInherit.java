import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MesoInherit extends MesoAbstract //extends mesoAbstract 
{
	MesoStation mesoStation;

		public MesoInherit(MesoStation mesoStation) 
		{
			this.mesoStation = mesoStation;
		}
		
	public int[] calAverage() 
	{
		int[] data = new int[3];
		int sum = 0;
		for (int i = 0; i < mesoStation.getStID().length(); i++)	
		{
			sum += (int)mesoStation.getStID().charAt(i);
		}
		double average = (double)sum/4;
		
		data[0] = (int)Math.ceil(average);
		data[1] = (int)Math.floor(average);
		data[2] = (int)Math.round(average);
		
		return data;
	}
	
	public char letterAverage() 
	{
		return (char)calAverage()[2];
	}


	
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MesoInherit extends MesoAbstract //extends mesoAbstract 
{
	private MesoStation mesoStation;
	
		public MesoInherit(MesoStation mesoStation) 
		{
			this.mesoStation = mesoStation;
		}
		
		public MesoStation getMesoStation() 
		{
			return mesoStation;
		}
	/*
	public int[] calAverage() 
	{
		int[] data = new int[3];
		for (int i = 0; i < data.length; i++)	
		{
			//TODO
		}
		
	}
	*/
	public char letterAverage() 
	{
		return 0;
		// TODO Auto-generated method stub
	}
	
}

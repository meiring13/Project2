
public class MesoInherit extends MesoAbstract //extends mesoAbstract because we are inheriting the methods from mesoAbstract
{
		private MesoStation mesoStation;

		public MesoInherit(MesoStation mesoStation) 	//constructor
		{
			this.mesoStation = mesoStation;  
		}
		
	public int[] calAverage() 	
	{
		int[] data = new int[3];			
		int sumAscii = 0;	
		for (int i = 0; i < mesoStation.getStID().length(); i++)	//looping through the length of the desired station id
		{
			sumAscii += (int)mesoStation.getStID().charAt(i);  
		}
		
		double average = (double)sumAscii/4;  //averaging the values
										
		data[0] = (int)Math.ceil(average);       //ascii ceiling
		data[1] = (int)Math.floor(average);		//ascii floor
		data[2] = (int)Math.round(average);		//ascii average
		
		return data;
	}
	
	public char letterAverage() 
	{
		return (char)calAverage()[2];	//casted to satisfy the return type
	}


	
}

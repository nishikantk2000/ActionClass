package testNGclass;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class AllenOneDP 
{
	@DataProvider(name="DP1")
	public Object[] getData1()
	{
	    Object[] data= new Object[3];
	    Map<String, String> m1 = new HashMap<String, String>();
	    m1.put("name", "Virat");
	    m1.put("role", "Batsman");
	    data[0] = m1;
	    
	    Map<String, String> m2 = new HashMap<String, String>();
	    m2.put("name", "Hardik");
	    m2.put("role", "AllRounder");
	    data[1] = m2;
	    
	    Map<String, String> m3 = new HashMap<String, String>();
	    m3.put("name", "Bumrah");
	    m3.put("role", "Bowler");
	    data[2] = m3;
	    
		return data;
	}
	
	@DataProvider(name="DP2")
	public Object[] getData2()
	{
		Object[][] data = new Object[5][2];
		data[0][0] = "Dhoni";
		data[0][1] = "7000";
		
		data[1][0] = "Malinga";
		data[1][1] = "100";
		
		data[2][0] = "Sanju";
		data[2][1] = "2000";

		data[3][0] = "KL Rahul";
		data[3][1] = "3000";

		data[4][0] = "Rushabh";
		data[4][1] = "4000";

		return data;
	}

}

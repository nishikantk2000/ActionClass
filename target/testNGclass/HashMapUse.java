package testNGclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HashMapUse 
{
	@Test(dataProvider="getData")
	public void verigyLoginTest(String userName, String password)
	{
		System.out.println(userName + " : " + password);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][]  data = new Object[4][2];
		
		data[0][0] = "Virat";
		data[0][1] = "ViratPwd";

		data[1][0] = "Rohit";
		data[1][1] = "RohitPwd";
		
		data[2][0] = "Surya";
		data[2][1] = "SuryaPwd";
		
		data[3][0] = "Hardik";
		data[3][1] = "HardikPwd";

		return data;
	}
	
}

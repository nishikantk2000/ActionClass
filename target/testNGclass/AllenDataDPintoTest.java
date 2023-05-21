package testNGclass;

import java.util.HashMap;

import org.testng.annotations.Test;

public class AllenDataDPintoTest 
{
	@Test(dataProvider="DP1", dataProviderClass=AllenOneDP.class)
	public void verifyPaymentTest1(HashMap<String, String> map)
	{
		System.out.println(map.get("name") + " :: " + map.get("role"));
	}
	
	@Test(dataProvider="DP2", dataProviderClass=AllenOneDP.class)
	public void verifyPaymentTest2(String pName, String runs)
	{
		System.out.println(pName + " :: " + runs);
	}
}

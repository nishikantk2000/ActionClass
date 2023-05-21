package testNGclass;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExeclDataRead {
	@Test(dataProvider="getData")
	public void verifyLoginTest(HashMap<String, String> map)
	{
		System.out.println(map.get("username") + " : " + map.get("password") + " : " + map.get("age") );
	}
	
	
	@DataProvider
	public Object[] getData()
	{
		Object[] data = new Object[4];
		
		Map<String, String> map1= new HashMap<>();
		map1.put("username", "Virat");
		map1.put("password", "ViratPwd");
		map1.put("age", "26");
		
		data[0] = map1;
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("username", "Rohit");
		map2.put("password", "RohitPwd");
		map2.put("age", "25");
		data[1] = map2;

		Map<String, String> map3 = new HashMap<>();
		map3.put("username", "Surya");
		map3.put("password", "SuryaPwd");
		map3.put("age", "30");
		data[2] = map3;
		
		Map<String, String> map4 = new HashMap<>();
		map4.put("username", "Hardik");
		map4.put("password", "HardikPwd");
		map4.put("age", "33");
		data[3] = map4;
		
		return data;
       }
}

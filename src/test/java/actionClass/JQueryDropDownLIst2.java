package actionClass;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownLIst2 {

	static List<String> clickOnDDOptions(List<WebElement> low, String... value)
		{
			  List<Boolean> res = new ArrayList<Boolean>();
			  for(WebElement ele: low)
			  {
				  for(String val: value)
				  {
					  if (ele.getText().equalsIgnoreCase(val))
						  ele.click();
				  }
			  }
			  for(String val: value)
			  {
				  
				  boolean flag = false;
				  for(int i=0;i<low.size();i++)
				  {
					  if (val.equalsIgnoreCase(low.get(i).getText()))
					  {
						  flag=true;
						  break;
					  }
				  }
				  if (flag==false)
					  res.add(false);
				  else
					  res.add(true);
			  }
		
			return null;
			  
			  
		}
		
		
	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup(); 
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		  driver.manage().window().maximize();
		  
		 driver.findElement(By.xpath("//input[@id='justAnInputBox']/following-sibling::button")).click();
		  
		  List<WebElement> low = driver.findElements(By.xpath("(//div[@class='comboTreeWrapper'])[1]//span[@class='comboTreeItemTitle']"));

		  List<String> result = clickOnDDOptions(low, "choice 4","choice 7","choice 6 2 2");
		  if (result.contains(false))
			  throw new RuntimeException("One/many choice/s are invalid !!!");
		  if(driver.findElements(By.xpath("(//div[@class='comboTreeWrapper'])[1]//span[@class='comboTreeItemTitle']")).size()!=0)
		  { 
			  System.out.println("choice Element Displayed =");
		  }else 
		  { 
			  System.out.println("Element Dosenot present in Windows");
		  }
		 
	      ListIterator<String> select= result.listIterator();
	      while(select.hasPrevious())
	      { 
	    	  String privious=select.previous();
	      }
	
		//System.out.println("ShowElement="+result.getClass());
	}
}

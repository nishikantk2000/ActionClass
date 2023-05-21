package testNGclass;

import java.util.Date;

import org.testng.annotations.Test;

public class DateFunction {
  @Test
  public void dateshow() 
  {
	  Date dt = new Date();
	  System.out.println(dt);
  }
}

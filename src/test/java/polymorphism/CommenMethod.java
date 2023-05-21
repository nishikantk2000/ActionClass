package polymorphism;

import org.openqa.selenium.support.ui.Select;

public class CommenMethod {
	Select list;
	public void listDetails(Select listofElements, Select list) {
		this.list = list;
	}
	//comman method by selecting the element
    public void selectByindex(int indexOfelement) {
    	this.list.selectByIndex(indexOfelement);
    }
	@SuppressWarnings("unused")
	private void selectByVisibleText(String textoftheElements) {
		this.selectByVisibleText(textoftheElements);
		
	}
}

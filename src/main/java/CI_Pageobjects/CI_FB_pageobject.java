package CI_Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CI_FB_pageobject {
	
	WebDriver driver;
	public CI_FB_pageobject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void goTo()
	{
		driver.get("https://www.facebook.com/");
	}
	
	public String getText()
	{
		
		String text=driver.findElement(By.cssSelector("div[class='_6ltj']")).getText();	
		return text;
	}

}

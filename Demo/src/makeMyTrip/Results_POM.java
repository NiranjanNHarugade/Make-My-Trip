package makeMyTrip;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Results_POM {
	
	@FindBy (xpath="//span[@class='bgProperties icon20 overlayCrossIcon']") private WebElement  popup;
	@FindBy (xpath="//p[@class='boldFont blackText airlineName']")private List<WebElement> flightname;
	@FindBy (xpath="//p[@class='blackText fontSize18 blackFont white-space-no-wrap']")private List<WebElement> price;
	@FindBy (xpath="//span[text()='View Prices']")private List<WebElement> viewButton;
	@FindBy (xpath="//p[text()='Spicesaver']/ancestor::div [@class='fareName']/following-sibling::div[@class='viewFareBtnCol ']/button")private WebElement bookButton;


   public Results_POM (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
   public void AllResults(WebDriver driver,WebDriverWait wait )
	{	
		wait.until(ExpectedConditions.visibilityOf(popup)).click();		
		
		for(int i=0;i<flightname.size();i++)
		{
			Reporter.log("Name of flight = "+flightname.get(i).getText()+"\nPrice = "+price.get(i).getText(),true);
		}	
	}
	
	
	
	public String Selectflight() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		String name="";
		for(WebElement fl:flightname)
		{
			String flights=fl.getText();
			if(flights.equals(Utility.Xcel_data(1, 5)))
			{
				Reporter.log(flights+" Flight Avialble",true);
				Thread.sleep(200);
				name=flights;
				break;
			}
		}return name;
	}	
	
	
	
	public void Bookflight() throws EncryptedDocumentException, IOException, InterruptedException 
	{   int number = 0;
		for(WebElement fl:flightname)
		{
			if(fl.getText().equals(Utility.Xcel_data(1, 5)))
			 {  number=flightname.indexOf(fl);
				break;	
			 }
		}
		viewButton.get(number).click();
		Thread.sleep(100);
		bookButton.click();
	}
	
	
	
}

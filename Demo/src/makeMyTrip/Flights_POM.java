package makeMyTrip;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Flights_POM {
	
	@FindBy (xpath = "//input[@data-cy='fromCity']") private WebElement from ;
	@FindBy (xpath = "//input[@data-cy='toCity']") private WebElement to ;
	@FindBy (xpath ="(//div[@role='heading'])[1]") private WebElement month ;
	@FindBy (xpath ="//span[@aria-label='Next Month']") private WebElement nextmonth ;
	@FindBy (xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']") private WebElement searchbutton ;
	@FindBy (xpath = "//ul[@role='listbox']/li/div/div/p[@class='font14 appendBottom5 blackText']") private List<WebElement>Suggestlist ;
	@FindBy (xpath ="(//div[@class='DayPicker-Body'])[1]/div/div/div/p[1]") private List< WebElement> datelist ;


	public Flights_POM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void journeyDetails() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		// Select Start location.
		from.sendKeys(Utility.Xcel_data(1, 1));
		Thread.sleep(500);
		for(WebElement ll:Suggestlist)
		{
			if(ll.getText().contains(Utility.Xcel_data(1, 1)))
			{	ll.click();
				break;
			}
		}
		
		
		// Select End location.
		to.sendKeys(Utility.Xcel_data(1, 2));
		Thread.sleep(1000);
		for(WebElement ll:Suggestlist)
		{  
			if(ll.getText().contains(Utility.Xcel_data(1, 2)))
			{	ll.click();
				break;
			}
		}
		
		
		
		// Select Month
		while(true)
		{
			if(month.getText().equals(Utility.Xcel_data(1, 4))) {break;}
			else { nextmonth.click(); }
		}
	
		
		
		// Select date
		int Date=(int)Double.parseDouble(Utility.Xcel_data(1, 3));
		for(WebElement dl:datelist) 
		{	Thread.sleep(100);
			if(dl.getText().contains(String.valueOf(Date))) 
			{   
				dl.click();
				break;
			}
		}
		
		
		searchbutton.click();
		
	}
	

}

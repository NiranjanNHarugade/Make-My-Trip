 package makeMyTrip;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass extends Base {
	
	Flights_POM FL;
	Results_POM RL;
	Booking_POM BK;
	
	SoftAssert SA;
	
	@BeforeTest
	public void launch_Browser() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		Launch_Browser();	
	}
	
	
	@BeforeClass
	public void Set_Journey() throws EncryptedDocumentException, IOException, InterruptedException {
		
		FL=new Flights_POM(driver);
		RL=new Results_POM(driver);
		BK=new Booking_POM(driver);
		FL.journeyDetails();
		
		
	}
	
	@Test
	public void validateResults() throws EncryptedDocumentException, IOException, InterruptedException {
		
		RL.AllResults(driver,wait);
		SA = new SoftAssert();
		Thread.sleep(100);
		SA.assertEquals(RL.Selectflight(), Utility.Xcel_data(1, 5),"This Flight is not available");
		SA.assertAll();
		RL.Bookflight();
		BK.Ragister(driver, js);
		
		
	}
	
//
//	@AfterClass
//	public void closetab()
//	{
//		driver.close();
//	}
//		
//	
//	@AfterTest
//	public void closeBrowse ()
//	{
////		driver.quit();	
	}


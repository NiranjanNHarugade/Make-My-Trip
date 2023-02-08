package makeMyTrip;

import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	
	protected static WebDriver driver;
	Actions as;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	public void Launch_Browser() throws IOException, EncryptedDocumentException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\All files\\SystemReq\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(Utility.PropertyFile_data("URL"));
		as= new Actions(driver);
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait( driver, Duration.ofSeconds(10));

	}
	
	

	

}

package makeMyTrip;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
 import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

//	 Data From xcel
	public static  String Xcel_data(int row ,int cell) throws EncryptedDocumentException, IOException
	{
	   	File data = new File ("C:\\All files\\MakeMyTrip\\EndToEnd.xlsx");
		String value = WorkbookFactory.create(data).getSheet("Sheet1").getRow(row).getCell(cell).toString();
		return value;	
	}
	
	
//	Data From file
	public static String PropertyFile_data(String key) throws IOException 
	{
		FileInputStream ProFile = new FileInputStream("C:\\Users\\Admin\\My-Workplace\\Demo\\src\\makeMyTrip\\Resource");
		Properties pp = new Properties();
		pp.load(ProFile);
		String KeyValue = pp.getProperty(key);
		return KeyValue;
	}

	
	
	public void SySdate() {
		
		
	}
}



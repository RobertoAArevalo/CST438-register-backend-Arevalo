package com.cst438;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;

@SpringBootTest
public class lastEnd2end {
	public static final String CHROME_DRIVER_FILE_LOCATION 
                          = "/Users/robertoarevalo/Downloads/chromedriver-mac-arm64/chromedriver";
	public static final String URL = "http://localhost:3000";
	public static final String ALIAS_NAME = "test";
	public static final int SLEEP_DURATION = 1000; // 1 second.
	public static final String TEST_USER_EMAIL = "tests@csumb.edu";
	public static final String TEST_STUDENT_NAME = "tests";
	public static final int TEST_STUDENT_ID = 2121; 



	@Autowired
	StudentRepository studentRepository;
	
	
		
		@Test
		public void playBadGame() throws Exception {


			System.setProperty("webdriver.chrome.driver",
                                         CHROME_DRIVER_FILE_LOCATION);
	//TODO update the class ChromeDriver()  for your browser
	// For chromedriver 111 need to specify the following options 
		ChromeOptions ops = new ChromeOptions();
		ops.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		ops.addArguments("--remote-allow-origins=*");	


           WebDriver driver = new ChromeDriver(ops);
			
			try {
				WebElement we;
				
				driver.get(URL);
				// must have a short wait to allow time
                             //  for the page to download 
				Thread.sleep(SLEEP_DURATION);


				// get the 2 multiply factors
				we = driver.findElement(
                                    By.id("1stStuButton"));
				we.click();
				Thread.sleep(SLEEP_DURATION);

				
				driver.findElement(By.name("name")).sendKeys(TEST_STUDENT_NAME);
		        driver.findElement(By.name("email")).sendKeys(TEST_USER_EMAIL);
		        driver.findElement(By.id("addStuButton")).click();
		        Thread.sleep(SLEEP_DURATION);

			
				
				
				// find all table cell entries
				// DataGrid uses a <div> with 
                             // class='MuiDataGrid-cellContent' to display cell data
				
				// check that first row of table contains
				//    the two factors and shows a text value of correct
				
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
				
			} finally {
				driver.close();
			       driver.quit();


			}
	}
}

package ServiceNow.ExternalCert;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

public class CertTypeTest {
	ExtentReports extent;
	@BeforeTest
	public void extentReporting()
	{
		
				
		String path ="\\Users\\deepthiandugula\\Documents\\reports\\index.html";

	    ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	
		
		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Rahul Shetty");
		
	}
	
@Test
		public  void ServiceNow() throws InterruptedException, IOException
	{
	ExtentTest test= extent.createTest("ServiceNow");
		System.setProperty("webdriver.chrome.driver", "/Users/deepthiandugula/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://bupaaus.service-now.com/bess/?id=is_sc_cat_item_default&sys_id=8e015ce0dbe1cc10bd40abf34a961934&sysparm_category=04a08b5cdbc4770000e496888a961970");
		driver.findElement(By.cssSelector("#okta-signin-username")).sendKeys("deepti.andugula@bupa.com.au");
		WebElement submit1 = driver.findElement(By.cssSelector("#okta-signin-submit"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", submit1);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement pswd =driver.findElement(By.xpath("//div/span/input[@class ='password-with-toggle']"));
		pswd.sendKeys("Very$!mple@123");
	
		WebElement submit2 = driver.findElement(By.xpath("//input[@value ='Verify']"));
		js.executeScript("arguments[0].click();", submit2);
		
		//select2-container ng-pristine ng-valid ng-scope ng-isolate-scope ng-empty ng-touched select2-dropdown-open select2-container-active
		Thread.sleep(8000);
		Boolean value = driver.findElement(By.xpath("//div[@class ='select2-container ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-empty']")).isDisplayed();
        Assert.assertTrue(value);
		WebElement search1 = driver.findElement(By.xpath("//div[@class ='select2-container ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-empty']"));
		search1 .click();
		
		WebElement drpdwn = driver.findElement(By.xpath("//div/div/input[@id='s2id_autogen3_search']"));
		Boolean value1 = drpdwn.isDisplayed();
		  
		  drpdwn.sendKeys("New Certificate Request", Keys.ENTER); 
		  TakesScreenshot tsh =(TakesScreenshot)driver;
		   File Source = tsh.getScreenshotAs(OutputType.FILE);
		  // FileUtils.copyFile(Source, "/Users/deepthiandugula/eclipse-workspace/ExternalCert");
		   String path = "/Users/deepthiandugula/eclipse-workspace/ExternalCert/"+"Testcase"+".png";
			FileUtils.copyFile(Source, new File(path));
		  
		  driver.close();
		 
		  test.log(Status.PASS, "Passed Testcase");
		  extent.flush();
		 
       // select2-container-active
        
        
	
	}
		


	
}

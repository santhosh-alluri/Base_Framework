package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.DriverManager;
import com.pom.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.SeleniumUIUtils;

public class Login extends BaseClass {
	LoginPage login = new LoginPage();
	ExtentTest logger;
	WebDriver driver = null;
	SeleniumUIUtils UI = null;
	
	
	@Parameters("browser")
	@BeforeClass
	public void init(String browser)
	{ 
		driver = openBrowser(browser);
		UI = new SeleniumUIUtils(driver);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void preSetup() {
		System.out.println("Before test");
		logger = report.startTest("Login Demo");
	}
	
	@Test(description="This TC will perform valid login")
	public void loginToApplication() throws Throwable
	{
		
		// login.userName(driver).sendKeys("test");
		UI.sendKeys(login.userName(driver), "Admin1");
		logger.log(LogStatus.INFO, "entered username as : "+ "Admin1");
		UI.sendKeys(login.password(driver), "password");
		logger.log(LogStatus.INFO, "entered password as : "+ "Admin1");
		UI.click(login.loginButton(driver));
		logger.log(LogStatus.INFO, "clicked on button");
   //   	UI.click(driver.findElement(By.id("xxyz")));
	//	logger.log(LogStatus.INFO, "clicked on unknow button");

	}       
	
	
	
	@AfterMethod
	public void captureResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String path = UI.takeSnapShot(driver, result.getName());
			System.out.println("img path "+ path);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "This test skipped");
		}
		report.endTest(logger);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}

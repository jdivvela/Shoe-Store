package com.shoestore.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Base {

	public static final String baseURL="https://rb-shoe-store.herokuapp.com";
	public static String BROWSER=null;
	public WebDriver driver;
	@Parameters({"browser"})
	@BeforeSuite
	public void selectBrowser(String browser){
		// choose browser such as chrome , firefox in test.xml
		BROWSER=browser;
		System.out.println(BROWSER);
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup()
	{
		String dir=getProjectLocation();
		
        if(BROWSER.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", dir+"/utils/chromedriver");
		driver=new ChromeDriver();
		}
        if(BROWSER.equals("firefox")){
         driver=new FirefoxDriver();
        }  
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass(alwaysRun = true)
	public void close()
	{
		driver.quit();
	}
	@AfterTest
	public void Testname()
	{
	System.out.println("***********************************************");	
	}
	
	public static String getProjectLocation(){
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        return dir;
	}
	
	
	public static void intialwait(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

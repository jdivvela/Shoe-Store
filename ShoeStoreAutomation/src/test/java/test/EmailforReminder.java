package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shoestore.common.Base;
import com.shoestore.common.Constants;

public class EmailforReminder extends Base {
	
	
	boolean StringPresent;
	String message;
	
	
	
	@Test
	public void testEMailReminder() throws InterruptedException{

	//	home.testReminderEmail(email);
		
		driver.findElement(By.id("remind_email_input")).sendKeys(Constants.VALIDEMAIL);
		driver.findElement(By.id("remind_email_submit")).click();
		message=driver.findElement(By.xpath("//*[@class='flash flash_success']")).getText();
		System.out.println(message);
		if(message.contains(Constants.SUCESSREMINDEREMAILMESSAGE))
		{
			Assert.assertTrue(true);
		}
		if(message.contains(Constants.SUCESSREMINDEREMAILMESSAGE))
		{
			Assert.assertFalse(true);
		}
		intialwait();
	
	}
	
	@Test
	public void testInvalidEMailReminder(){
	
		driver.findElement(By.id("remind_email_input")).sendKeys(Constants.VALIDEMAIL);
		driver.findElement(By.id("remind_email_submit")).click();
		
		message=driver.findElement(By.xpath("//*[@class='flash alert_danger']")).getText();
			System.out.println(message);
		if(message.contains(Constants.INVALIDREMINDEREMAILMESSAGE))
		{
			Assert.assertTrue(true);
		}
		if(message.contains(Constants.INVALIDREMINDEREMAILMESSAGE))
		{
			Assert.assertFalse(true);
		}
		intialwait();

	}
	
	
}

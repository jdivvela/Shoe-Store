package test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shoestore.common.Base;

public class ReleasedShoeTest extends Base{

	HashMap<String,String> hashmap=new HashMap<String, String>();
		
	@Test
	public void testMonth() throws InterruptedException{
		hashmap.put("1", "January");
		hashmap.put("2", "February");
		hashmap.put("3", "March");
		hashmap.put("4", "April");
		hashmap.put("5", "May");
		hashmap.put("6", "June");
		hashmap.put("7", "July");
		hashmap.put("8", "August");
		hashmap.put("9", "September");
		hashmap.put("10", "October");
		hashmap.put("11", "November");
		hashmap.put("12", "December");		
		
		for(int i=1;i<=12;i++){
		
			driver.findElement(By.linkText(hashmap.get(String.valueOf(i)))).click();
			intialwait();
			//List<WebElement> element=driver.findElements(By.xpath("//*[@class='shoe_result_value shoe_brand']"));
			int brandSize=driver.findElements(By.xpath("//*[@class='shoe_result_value shoe_brand']")).size();
			int descSize=	driver.findElements(By.xpath("//*[@class='shoe_result_value shoe_description']")).size();
			int imageSize=driver.findElements(By.xpath("//*[@class='shoe_result_value shoe_description']")).size();
			int priceSize=driver.findElements(By.xpath("//*[@class='shoe_result_value shoe_description']")).size();
			if(brandSize==descSize && imageSize==priceSize && descSize==imageSize){
				System.out.println(hashmap.get(String.valueOf(i))+" has all the value present for brand, descripton ,image,price");
				Assert.assertTrue(true);
			}
			else
			{
				System.out.println("All the value are not present for shoe in "+hashmap.get(String.valueOf(i)));
				Assert.assertFalse(true);;
			}
		}
	}
		
}

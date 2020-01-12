package com.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LaunchVtigerTest {

	@Test
	public void launchTest()
	{
		System.out.println("Test Started");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Actions act = new Actions(driver);
		WebElement moreDD = driver.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(moreDD).perform();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys("ICICI_16");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		driver.findElement(By.xpath("(//a[text()='Campaigns'])[3]")).click();
		driver.findElement(By.xpath("(//a[text()='ICICI_16'])[2]")).click();
		WebElement moreDD1 = driver.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(moreDD1).perform();
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		driver.findElement(By.xpath("//img[@title='Last Viewed']")).click();
		driver.findElement(By.xpath("//a[text()='ICICI_16']")).click();
		driver.findElement(By.name("Duplicate")).click();
		driver.findElement(By.name("campaignname")).clear();
		driver.findElement(By.name("campaignname")).sendKeys("ICICI_12");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		driver.findElement(By.xpath("(//a[text()='Campaigns'])[3]")).click();
		List<WebElement> allCamp = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(WebElement wb : allCamp)
		{
			String cName = wb.getText();
			if(cName.equals("ICICI_12"))
			{
				System.out.println("Duplicate Campagin created");
				break;
			}
		}
		driver.quit();
		System.out.println("pass");
		System.out.println("Test Finish");
	}
}

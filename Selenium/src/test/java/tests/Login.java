package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.BaseUtils;

public class Login {

	public static void main(String[] args) throws InterruptedException, IOException {
		// initilize driver
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// read property - url
		//String url = BaseUtils.readProperties("url");
		//driver.get(url);
		driver.get("https://freecrm.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-xs-2.btn-shadow.btn-rect.btn-icon.btn-icon-left")).click();
		driver.findElement(By.name("email")).sendKeys("ludadess@yahoo.ca");
		driver.findElement(By.name("password")).sendKeys("Fantasy_1");
		driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/contacts']")).click();
		Thread.sleep(2000);
		String checkBox = "//td[contains(text(),'happy one')]/preceding-sibling::td//div[contains(@class,'checkbox')]";
		driver.findElement(By.xpath(checkBox)).click();
		
		//WebElement inputBox = driver.findElement(By.name("q"));
		//flashElement(inputBox, driver);
		
		//driver.findElement(By.name("q")).sendKeys("Bach music");
		//driver.findElement(By.cssSelector("input[class='gLFyf gsfi']")).sendKeys("Bach history");
		//Thread.sleep(1000);
		//WebElement btn = driver.findElement(By.name("btnK"));
		//flashElement(btn, driver);
		//driver.findElement(By.name("btnK")).click();
		//Thread.sleep(2000);
		
		//driver.findElement(By.partialLinkText("Johann Sebastian Bach")).click();
		//driver.close();
		// //td[contains(text(),'happy one')]/preceding-sibling::td//div//input[@name='id']
	}


	 public static void flashElement (WebElement element, WebDriver driver){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 for( int i=0; i<50; i++) {
			 js.executeScript("arguments[0].style.border='2px dashed black'", element);
			 js.executeScript("arguments[0].style.border='2px dashed white'", element);
			 }
	 }
}
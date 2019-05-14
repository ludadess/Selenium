package tests;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinkTest {



public static void main(String[] args) throws MalformedURLException, IOException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://freecrm.com/");
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	List<WebElement> images = driver.findElements(By.tagName("img"));
	
	System.out.println("number of links ---->"+links.size() );
	System.out.println("number of images ---->"+images.size() );
	
	 links.addAll(images);
	 System.out.println("number of links and images ---->"+links.size() );
	 
	 ArrayList<WebElement> allActiveLinks = new ArrayList<WebElement>();
	 
	 for (int i=0; i<links.size();i++) {
		if( links.get(i).getAttribute("href")!= null) {
			allActiveLinks.add(links.get(i));
		}
	 }
	
	 for(int y=0;y<allActiveLinks.size();y++) {
		HttpURLConnection connection = (HttpURLConnection) new URL(allActiveLinks.get(y).getAttribute("href")).openConnection();
		 connection.connect();
		 String response = connection.getResponseMessage();
		 connection.disconnect();
		 System.out.println(allActiveLinks.get(y).getAttribute("href")+"---->"+response);
		 }
}

}

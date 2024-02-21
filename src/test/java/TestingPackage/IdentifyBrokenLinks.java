package TestingPackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IdentifyBrokenLinks {
	
	@Test
	public void identifyBrokenLinksTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.zlti.com");
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		String url;
		
		for(WebElement link:links)
		{
			 url = link.getAttribute("href");
			 if(url==null||url.isEmpty())
			 {
				 System.out.println("URL is either not configured for anchor tag or it is empty");
				 continue;
			 }
			verifyLink(url);
			
		}
		
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	private void verifyLink(String url) {
		
		try {
		
		URL link = new URL(url);
		HttpURLConnection httpUrlConnection = (HttpURLConnection)link.openConnection();
		httpUrlConnection.connect();
		
		if(httpUrlConnection.getResponseCode()==200)
		{
			System.out.println(url+"-"+httpUrlConnection.getResponseMessage());
		}
		else
		{
			System.out.println(url+"-"+httpUrlConnection.getResponseMessage()+"- is a broken link");
		}
		}
		catch(Exception e)
		{
			System.out.println(url+"- is a broken link");
			e.printStackTrace();
		}
	}

}

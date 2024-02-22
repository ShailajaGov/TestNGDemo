package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//xsadfg
@Listeners(MyListener.class)
public class Login {
	
	WebDriver driver;
	
	
		
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		System.out.println("verifyLoginWithValidCredentials");
		driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
	@Test(priority = 2)
	public void verifyLoginWithValidEmailAndInvalidPwd()
	{
		System.out.println("verifyLoginWithValidEmailAndInvalidPwd");
		
	}
	
	@Test(priority = 3,dependsOnMethods= {"verifyLoginWithValidEmailAndInvalidPwd"})
	public void verifyLoginWithInvalidEmailAndValidPwd()
	{
		System.out.println("verifyLoginWithInvalidEmailAndValidPwd");
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidCredentials() 
	{
		System.out.println("verifyLoginWithInvalidCredentials");
	}
	
	@Test(priority = 1)
	public void verifyLoginWithoutGivingAnyCredentials()
	{
		System.out.println("verifyLoginWithoutGivingAnyCredentials");
	}

}

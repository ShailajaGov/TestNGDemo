package TestingPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Test
public class WishList 
{
	WebDriver driver;
	
	@Test
	public void verifyUserLogin()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("shailaja.sireesh@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test(dependsOnMethods= {"verifyUserLogin"})
	public void addProductToWishListPage()
	{
		
		driver.findElement(By.name("search")).sendKeys("HP",Keys.ENTER);
		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wishListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("wish list")));
	
		wishListElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Assert.assertEquals(driver.getTitle(), "My Wish List");
	}
	
	@Test(dependsOnMethods= {"verifyUserLogin","addProductToWishListPage"})
	public void removeProductFromWishList()
	{
		driver.findElement(By.xpath("//a[@data-original-title = 'Remove']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id= 'content']/p")).getText(),"Your wish list is empty.");
		
	}
	
	
	
}

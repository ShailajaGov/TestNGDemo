package TestingPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataParameterizationDataProvider {

	@Test(dataProvider = "getData")
	public void verifyLogin(String userName,String Password)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(userName);
		driver.findElement(By.id("input-password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}
	
	@Test(dataProvider = "dataSupplier",dataProviderClass=SampleDataProvider.class)
	public void verifyLoginTwo(String[] str)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(str[0]);
		driver.findElement(By.id("input-password")).sendKeys(str[1]);
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}
	
	@Test(dataProvider ="testData")
	public void sampleTest(Object a,Object b,Object c)
	{
		System.out.println(a+"-"+b+"-"+c);
	}
	
	@Test(dataProvider="dataFeed")
	public void sampleTestOne(Object a) {
		System.out.println(a);
	}
	
	@Test(dataProvider = "dataLoad")
	public void sampleTestTwo(Object a,Object b,Object c)
	{
		System.out.println(a+"-"+b+"-"+c);
	}
	
	@Test(dataProvider = "supplier",dataProviderClass =SampleDataProvider.class)
	public void sampleTestThree(Object a)
	{
		System.out.println(a);
	}
	
	@DataProvider(name="getData", parallel=true )
	public String[][] getData()
	{
		String[][] data = {{"shailaja.sireesh@gmail.com","12345"},
				{"abc@gmail.com","12345"},
				{"shailaja.sireesh@gmail.com","12345"},
				{"abc@gmail.com","12345"},
				{"shailaja.sireesh@gmail.com","12345"},
				{"abc@gmail.com","12345"}
		};
		return data;
	}
	
	
	@DataProvider(name="testData")
	public Object[][] dataInput()
	{
		
		Object[][] data= {{"abc",1,true},
					{"bcd",2,false},
					{"def",3,true}};
		
		return data;
	}
	
	@DataProvider
	public Iterator<Object> dataFeed() 
	{
		List<Object> data = new ArrayList<Object>();
		data.add("abc123");
		data.add(1);
		data.add(true);
		
		return data.iterator();
		
	}
	
	@DataProvider
	public Iterator<Object[]> dataLoad()
	{
		List<Object[]> data= new ArrayList<>();
		
		data.add(new Object[]{"Arun","1",true});
		data.add(new Object[] {"Tarun","2",false});
		
		return data.iterator();		
				
	}
}

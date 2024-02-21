package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class MyListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getName()+" onTestSuccess");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getName()+" onTestFailure");
		
		WebDriver driver = null;
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		
		try {
			FileUtils.copyFile(file, new File(destinationFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getName()+" onTestSkipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println(result.getName()+" onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println(context.getName()+" onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println(context.getName()+" onFinish");
	}
	
	

}

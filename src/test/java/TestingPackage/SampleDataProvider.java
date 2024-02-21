package TestingPackage;

import org.testng.annotations.DataProvider;

public class SampleDataProvider {

	@DataProvider
	public String[][] dataSupplier()
	{
		String[][] data = {{"shailaja.sireesh@gmail.com","12345"},{"abc@gmail.com","12345"},{"qwe@gmail.com","12345"}};
		return data;
	}
	
	@DataProvider(name ="supplier",indices= {0,3})
	public Object[] dataSupplierOne()
	{
		Object[] data= {"Arun","Varun","Tarun","Kishore","Ravi"};
		
		return data;
	}
}

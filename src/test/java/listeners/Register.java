package listeners;

import org.testng.annotations.Test;

public class Register {
	
	@Test(priority = 1,groups = {"smoke","sanity","register","All"})
	public void registerByGivingAllFields()
	{
		System.out.println("registerByGivingAllFields");
	}
	
	@Test(priority = 2,groups = {"sanity","All"})
	public void registerByGivingMandatoryFields()
	{
		System.out.println("registerByGivingMandatoryFields");
	}
	
	@Test(priority = 3,groups = {"smoke","register","All"})
	public void registerWithoutGivingAnyFields()
	{
		System.out.println("registerWithoutGivingAnyFields");
	}

}

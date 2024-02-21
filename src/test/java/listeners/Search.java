package listeners;

import org.testng.annotations.Test;

public class Search {
	
	@Test(priority = 1,groups = {"windows.smoke","windows.sanity","windows.search","All"})
	public void searchByGivingSearchText()
	{
		System.out.println("searchByGivingSearchText");
	}
	
	@Test(priority = 1,groups = {"linux.search"})
	public void searchWithoutGivingSearchText()
	{
		System.out.println("searchWithoutGivingSearchText");
	}
	
	@Test(priority = 1,groups = {"windows.search"})
	public void searchByclickingEnterButtion()
	{
		
		System.out.println("searchByclickingEnterButtion");
	
	}

}

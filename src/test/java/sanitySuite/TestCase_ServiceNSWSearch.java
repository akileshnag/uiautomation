package sanitySuite;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Syn_servicensw_search;



public class TestCase_ServiceNSWSearch extends TestBase{
	
	Syn_servicensw_search obj_servicensw_search;
		
	@Test (priority=1, description = "Open servicensw Search URL")	
	public void open_url() {

		log.info("Open servicensw Search URL.");
		driver.get(data.getProperty("base.url"));

		log.info("Get input string from properties file and put it into the search box.");
		obj_servicensw_search = new Syn_servicensw_search (driver);
	
		obj_servicensw_search.search_by_first_option(data.getProperty("TestCase_1.searchString_1"));
		
		//log.info("Assert actual searched string with expected string from properties file.");
		//assertStrings(obj_servicensw_search.get_first_option(),data.getProperty("TestCase_1.assertString_1"));

		//String actualText = obj_servicensw_search.get_first_option();
		//log.info(actualText);
		//Assert.assertTrue(actualText.equalsIgnoreCase(data.getProperty("TestCase_1.assertString_1")));
		//log.info("END OF TEST CASE 1");

	}

	@Test (priority=2, description = "Click on first search option")	
	public void click_first_search_option() {

		log.info("Click on first search option");
		obj_servicensw_search.select_first_option();
		log.info("END OF TEST CASE 2");
	} 
	
	
	  @Test (priority=3, description = "Select from the search results") public
	  void select_from_search_results() {
	  
	  log.info("SEARCH RESULTS ARE DISPLAYED");
	  obj_servicensw_search.click_result_item(data.getProperty("TestCase_1.clickLink_1"));
	  obj_servicensw_search.search_by_suburbpc(data.getProperty("TestCase_3.searchString_1"));
	  obj_servicensw_search.findCentre();
	  log.info("END OF TEST CASE 3");
	  
	  }
	 
	
	@Test (priority=4, description = "Select from the search results")	
	public void search_by_suburb_testData() throws IOException, InterruptedException {

	//	log.info("SEARCH RESULTS ARE DISPLAYED");
	//	obj_servicensw_search.click_result_item(data.getProperty("TestCase_1.clickLink_1"));
		
		log.info("Calling the setup excelData");
		setUpExcelData();
				
		for(int i=0;i <=suburbNames.size();i++) {
			log.info("Searching the suburb using the test data retrieved from excel sheet");
			obj_servicensw_search.findLocation();
			obj_servicensw_search.search_by_suburbpc(suburbNames.get(i));
			wait(2);
			/*
			 * String firstPart = "//*[@id='locatorListView']/div/div/div/div//"; String
			 * middlePart = "a[contains(text(),"; String centerPart = centerNames.get(i);
			 * String lastPart = ")]"; String completeXpath = firstPart + middlePart +
			 * centerPart + lastPart;
			 */
			String linkText = centerNames.get(i);
			log.info(linkText);
			WebElement element = driver.findElement(By.linkText(linkText));
			obj_servicensw_search.findCentreWithTestData(element);
		}
		
		log.info("END OF TEST CASE 4");

	}

}

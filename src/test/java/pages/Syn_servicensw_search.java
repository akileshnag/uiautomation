package pages;

import org.openqa.selenium.JavascriptExecutor;

/*******************************************************************************************
 * Page Factory class Template
 * @author Akilesh Nagarajan
 *******************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;


public class Syn_servicensw_search extends PageBase {
	
		
	public Syn_servicensw_search(WebDriver driver) {
		super(driver);
		
				
	}

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/

	WebDriver driver;
	// Web Element for ServiceNsw Search Box
	@FindBy(css ="#homeAutosuggest input")
	WebElement searchBox;
	
	 //Web Element for ServiceNSW Search first option
	@FindBy(css ="li.autocomplete__option")
	WebElement searchFirstOption;
	
	@FindBy(linkText="Apply to collect number plates from another service centre")
	WebElement searchLinkText;
	
	@FindBy(linkText="Find a service centre")
	WebElement serviceCentreLink;
	
	@FindBy( css ="#locatorTextSearch" )
	WebElement searchBoxSubPC;
	
	@FindBy( css="li.autocomplete__option")
	WebElement searchOption;
	
	@FindBy (linkText="Marrickville Service Centre")
	WebElement serviceCentre;
	
	@FindBy (linkText="Find a location")
	WebElement locationFinder;
	
	
	
	/*******************************************************************************************
	 * All Methods for performing actions
	 * @return 
	 *******************************************************************************************/
		
	public void enter_text(String Search_text){
		
		log.info("Enter text to search: "+Search_text);
		searchBox.click();
		searchBox.sendKeys(Search_text);
		wait(2);
		log.info("Search text has been entered");
		
	}
	
	public String get_first_option(){
		
		 wait(2);
		 return searchFirstOption.getText();
		
	}
	
	public void select_first_option(){
		
		log.info("Selecting option displayed by ServiceNSW autocomplete");
		searchFirstOption.click();
		wait(5);
		
	}
	
	public void click_result_item(String result_text) {
	
		String linkText = searchLinkText.getText();
		log.info(linkText);
		searchLinkText.click();
		serviceCentreLink.click();
		 }
	
	public void search_by_suburbpc(String search_text) {
		
		searchBoxSubPC.click();
		searchBoxSubPC.clear();
		searchBoxSubPC.sendKeys(search_text);
		wait(2);
		searchOption.click();
	    wait(5); 
	}
	
	public void findCentre() {
		serviceCentre.getText();
		log.info(serviceCentre.getText());
		serviceCentre.click();
		wait(2);
				
	}
	
	public void findLocation() {
		locationFinder.click();
	}
	
	public void find_center_using_test_data(WebElement element) {
		log.info(element.getText());
		element.click();
		
		
	}	   
    


	/*******************************************************************************************
	 * This POM method will be exposed in test case
	 * @param 
	 *******************************************************************************************/

	public void search_by_first_option(String text_to_search) {

		this.enter_text(text_to_search);
		
	}
	
	public void click_on_first_search_option () {

		this.select_first_option();
		
	}

	public void findCentreWithTestData(WebElement element) {
		this.find_center_using_test_data(element);
		
	}

	
	
	
	
	
}

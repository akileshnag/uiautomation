#UI Automation
UI Automation for a Service NSW Work Flow

The UI automation for Service NSW work flow of order no plates from the nearest centres is implemented using Selenium, Java, TestNG , Maven. The features available in the framework are logging using Log4J, data driving using Apache POI, Taking Screen Shots on Failures, TestNG reporting. The project can be executed using the Maven Clean and Install Goals. The profiles for local and other envionments as requested in the questionnaire was implemented using Maven POM by creating a profile. Also the framework uses Page Factory as the design pattern.

The following are the key files in the project
PageBase.java - PageFactory Initialization.
TestBase.java - Utilities like taking screen shots, property handling, logging and excel drivers.
TestCase_ServiceNSWSearch - Test cases for searching through the ServiceNSW site and ordering products.
Syn_servicensw_search -Page Objects for all the pages navigated across.

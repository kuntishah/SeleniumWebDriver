package Academy.bin;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

//TestCases
public class LoginQAClick extends base {

	private static Logger log = LogManager.getLogger(LoginQAClick.class.getName());
	@BeforeTest
	public void initialise() throws IOException{
		driver = initializer();
	}
	
	//Test to enter login credentials and login 
	@Test(dataProvider="getLoginData")
	public void basePageNavigation(String username , String password)  throws IOException{
		
		if(driver!=null){
			driver.get(prop.getProperty("url"));
			log.info(" is initialised in HomePage");

			}
		 else{
			log.error("driver value is null");
		}

			LandingPage lp = new LandingPage(driver);
			lp.getLogin().click();
			
			log.info("Into Login page");
			
			LoginPage lpg = new LoginPage(driver);
			lpg.getEmailInputText().sendKeys(username);
			lpg.getPwdInputText().sendKeys(password);
			lpg.getLoginButon().click();
			
			
		log.error("driver value is null");
		
	}//basePageNavigation
	
	@DataProvider
	public Object[][] getLoginData(){
		Object[][] loginDetails = new Object[2][2];
		
		loginDetails[0][0]="nonrestricteduser@abc.com";
		loginDetails[0][1]="qwerty";
		
		loginDetails[1][0]="restricteduser@abc.com";
		loginDetails[1][1]="asdfgh";
		
		return loginDetails;
		
	}

	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
	
}

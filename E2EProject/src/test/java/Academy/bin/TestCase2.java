package Academy.bin;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

//Second test case - random
public class TestCase2 extends base {
private static Logger log = LogManager.getLogger(TestCase2.class.getName());
	LandingPage lp;
	
	@BeforeTest
	public void initialise() throws IOException{
		driver = initializer();

		if(driver!=null){
		driver.get(prop.getProperty("url"));
		log.info(" is initialised in HomePage");

		}
	 else{
		log.error("driver value is null");
	}
	}
	
	@Test
	public void testLandingPage(){
	
		//driver = null;
		log.info(" is initialised in HomePage");
		
			lp = new LandingPage(driver);
			log.info("url opened");
		
	}//basePageNavigation
	
	//This test case purposely fails to demonstrate that listener class will take screenshot when test fails.
	@Test(dependsOnMethods="testLandingPage")
	public void test2(){
		log.info("assert featured courses");
		Assert.assertEquals(lp.getFeaturedCourses().getText(),"FEATURED C99OURSES");
		
	}
	
	@Test(dependsOnMethods="testLandingPage")
	public void test3(){
		log.info("assert nav bas is displayed");

		Assert.assertTrue(lp.getNavBar().isDisplayed());

		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
	
	
	
}

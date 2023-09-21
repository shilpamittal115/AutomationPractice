package POM_Practice_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseRunner {
	
	WebDriver driver;
	TestCase1 TC;
	
	@BeforeTest
	public void Setup() {
		String str= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",str+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tesco.com/");
	}

	@Test
	public void tesco_1st() {
		TC= new TestCase1(driver);
		TC.Tesco_register();
		
	}
}

package Practice_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	WebDriver driver;
	TestCase1 TC;
	
	
	@BeforeTest
	public void Setup() {
		
		String chromePath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", chromePath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tesco.com/groceries/");
		
	}
	
	
	@Test
	public void registationProcess() {
		TC=new TestCase1(driver);
		TC.userRegistation();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBe(null, ""));
		
	}

}

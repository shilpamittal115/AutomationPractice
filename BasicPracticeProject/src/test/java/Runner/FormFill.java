package Runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormFill {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		String chrome_Path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",chrome_Path+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void formData() {
		driver.get("https://interview-test.ui-staging.profinda.com/profiles/me");
		System.out.println("User open the URL");
		driver.findElement(By.xpath("//input[@title='Email address']")).sendKeys("miguel.cabrera+interviewtest@profinda.com");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("MBU5prp-fdn@pcw-mwa");
		driver.findElement(By.xpath("//button/div[text()='Login']")).click();
		System.out.println("User login to the application");
	}
	
	
	@AfterTest
	public void tearDown() {
		
	}

}

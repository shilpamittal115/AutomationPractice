package Runner;

import java.awt.Desktop.Action;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	
	WebDriver driver;
	WebDriverWait wait=null;
	
	@BeforeTest
	public void setup() {
		String str= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", str+"/src/test/resources/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
public void RegisterPage() {
	driver.get("https://www.tesco.com/");
	System.out.println("URL lauched");
	wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Good morning']"), "Good morning"));
	
	
	WebElement acceptCookies= driver.findElement(By.xpath("//*[text()='Accept all cookies']"));
	System.out.println(acceptCookies.getText()+"::::acceptCookies");
	Actions action = new Actions(driver);
	action.moveToElement(acceptCookies).click().perform();
	WebElement ele= driver.findElement(By.xpath("//a/span[text()='Groceries']"));
	System.out.println(ele.getText()+":::Click with Javascript");
	ele.click();
	driver.findElement(By.xpath("//a/span[text()='Shop groceries']")).click();
	//((JavascriptExecutor)driver).executeScript("arguments[0].click", el);
	
	//((JavascriptExecutor)driver).executeScript("argument[0].click",ele);
	
	
	
}
}

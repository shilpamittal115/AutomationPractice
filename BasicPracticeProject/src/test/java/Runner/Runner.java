package Runner;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Runner {
	
	public static void main(String[] args) {
	
		 WebDriverWait wait;

	
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.get("https://www.sainsburys.co.uk/");
	

	WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	WebElement element = driver.findElement(By.id("onetrust-accept-btn-handler"));

	/*Actions actions = new Actions(driver);

	actions.moveToElement(element).click().perform();*/
	
	//https://toolsqa.com/selenium-webdriver/alerts-in-selenium/
	  ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
	  // Alert promptAlert  = driver.switchTo().alert();
	 //  String alertText = promptAlert.getText();
	 //  System.out.println("Alert text is " + alertText);
	  //Send some text to the alert
	  // promptAlert.sendKeys("Test User");
	   //promptAlert.accept();
	  driver.findElement(By.xpath("//a[ text() = 'Groceries']")).click();
	  
	
	}
}

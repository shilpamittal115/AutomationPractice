package Runner;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPractice {
	
	WebDriver driver= null;
	Sample s= new Sample();
	
	@BeforeTest
	public void setupTest() {
		 String chrome_path= System.getProperty("user.dir");
		 System.setProperty("webdriver.chrome.driver", chrome_path+"/src/test/resources/drivers/chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
 
	@Test
	public void registerUser() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".classlocator")));
		driver.get("https://www.tesco.com/groceries/");
		//s.RegisterPage();
		WebElement ele= driver.findElement(By.xpath("//span[text()='Register']"));
		
		ele.click();
		WebElement el= driver.findElement(By.xpath("//*[text()='Accept all cookies']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click", el);

		Actions actions = new Actions(driver);

		actions.moveToElement(el).click().perform();
		
		driver.findElement(By.id("email")).sendKeys("abcmmmm@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Complex@1501");
		driver.findElement(By.xpath("//fieldset//label[3]")).click();
		
		WebElement TitleField = driver.findElement(By.xpath("//select[@name='title']"));
		
		Select select = new Select(TitleField);
		//select.selectByValue("Mrs");
		//select.selectByIndex(2);
		select.selectByVisibleText("Mrs");
		
		driver.findElement(By.id("first-name")).sendKeys("Shilpa");
		driver.findElement(By.id("last-name")).sendKeys("Mittal");
		driver.findElement(By.xpath("//input[@name='phone-number']")).sendKeys("07407433381");
		driver.findElement(By.xpath("//input[@name='search-input-1']")).sendKeys("Silver town");
		WebElement checkBoxElement=driver.findElement(By.cssSelector("input[name='marketing-preferences']"));
		System.out.print(checkBoxElement);
		
		//WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
		boolean isDisplayed = checkBoxElement.isEnabled();

		// performing click operation if element is displayed
		if (isDisplayed == true) {
			checkBoxElement.click();
		}
		
		driver.findElement(By.cssSelector("input[name='marketing-preferences']")).click();
		String str=driver.findElement(By.cssSelector("button[data-testid='form-submit']>span>span")).getText();
		System.out.print(str);
		driver.findElement(By.cssSelector("button[data-testid='form-submit']>span>span")).click();

	}
	
	@AfterTest
	public void tearDown() {
		
		//driver.close();
		
	}
}

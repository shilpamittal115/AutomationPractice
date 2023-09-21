package Runner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TescoPractice {
	
	public static void main(String[] args) throws InterruptedException{
	
		String chrome_path= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", chrome_path+"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.tesco.com/groceries/");
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
		String s=driver.findElement(By.cssSelector("input[name='marketing-preferences']")).getText();
		System.out.print(s);
		
		driver.findElement(By.cssSelector("input[name='marketing-preferences']")).click();
		String str=driver.findElement(By.cssSelector("button[data-testid='form-submit']>span>span")).getText();
		System.out.print(str);
		driver.findElement(By.cssSelector("button[data-testid='form-submit']>span>span")).click();
		
		//button[data-testid='form-submit']>span>span
		  //Send some text to the alert
		  // promptAlert.sendKeys("Test User");
		   //promptAlert.accept();
	}

}

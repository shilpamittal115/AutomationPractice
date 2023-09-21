package Practice_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {
	
	WebDriver driver;
	
	public TestCase1(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	By registerBtn= By.xpath("//span[text()='Register']");
	By cookies_Accept_Btn=By.xpath("//*[text()='Accept all cookies']");
	By email=By.id("email");
	By password=By.xpath("//input[@name='password']");
	By cubBoard=By.xpath("//fieldset//label[3]");
	By title=By.xpath("//select[@name='title']");
	
	
	public void userRegistation() {
	
		WebElement ele= driver.findElement(registerBtn);
		ele.click();
		WebElement accept_box= driver.findElement(cookies_Accept_Btn);
		//((JavascriptExecutor)driver).executeScript("arrgumnet[0].click",accept_box);
		Actions action=new Actions(driver);
		action.moveToElement(accept_box).click().perform();
		driver.findElement(email).sendKeys("abcmmmm@gmail.com");
		driver.findElement(password).sendKeys("Complex@1501");
		driver.findElement(cubBoard).click();
		WebElement TitleDrop= driver.findElement(title);
		Select select =new Select(TitleDrop);
		select.selectByVisibleText("Mrs");
		
	}

}

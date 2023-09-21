package POM_Practice_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1 {
	
	WebDriver driver;
	
	public TestCase1(WebDriver driver) {
		this.driver=driver;	
	} 
	
	
	By reg_btn= By.xpath("//*[text()='Register']");
	
	public void Tesco_register() {
		
		driver.findElement(reg_btn).click();
		
	}

}

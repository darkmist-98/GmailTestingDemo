
# hello





package gmailtesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckCredentialTest {
	
	WebDriver driver ;
	
	@BeforeTest
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test
	public void checkCredentialInvalid() throws InterruptedException {
		driver.get("https://stackoverflow.com/");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button.flex--item.s-btn.s-btn__primary.js-accept-cookies")).click();
		driver.findElement(By.cssSelector("a.s-topbar--item.s-topbar--item__unset.s-btn__filled")).click();
		driver.findElement(By.xpath("(//div[@id='openid-buttons']/button)[1]")).click();
	/*	driver.findElement(By.name("identifier")).sendKeys("testingworld123@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();	*/
		
	}
	
	//@AfterTest
	public void close() {
		driver.close();
		
	}

}

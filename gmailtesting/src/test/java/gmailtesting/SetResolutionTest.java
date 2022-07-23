package gmailtesting;

import java.awt.Toolkit;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetResolutionTest {

	WebDriver driver;

	@Test(priority = 1, description = "Using fullscreen method")
	public void setFullscreen() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//System.out.println(Thread.currentThread().getId());
		
		driver.get("https://gmail.com");
		driver.manage().window().fullscreen();
		
		driver.quit();
	}
	
	
	@Test(priority = 2, description = "Using Dimension")
	public void setResolution(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//System.out.println(Thread.currentThread().getId());
		
		driver.get("https://gmail.com");
		Dimension dimension = new Dimension(1552, 832);
		driver.manage().window().setSize(dimension);
		
		driver.quit();
	}
	
	

}

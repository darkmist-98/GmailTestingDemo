package gmailtesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserInputFromConfigFile {
	
	WebDriver driver;
	Properties prop;
	
	@BeforeClass
	public void init() {
		
		File file = new File("./config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void inputFromConfigTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//System.out.println(Thread.currentThread().getId());
		
		driver.get(prop.getProperty("url"));
		String expText = driver.findElement(By.xpath("//div[@class='Y4dIwd']/span")).getText();
		Assert.assertEquals(expText, "to continue to Gmail");
		
		driver.findElement(By.name("identifier")).sendKeys(prop.getProperty("email"));
		
	}
	
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}

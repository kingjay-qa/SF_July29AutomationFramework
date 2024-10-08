package SF_FrameWork;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import SF_Utilities.SF_WaitUtilities;

public class LaunchApp {
	public static void main(String[] args) throws InterruptedException, AWTException {

		ChromeOptions co = new ChromeOptions();
		WebDriver driver = new ChromeDriver(co);
//		driver.get("https://login.salesforce.com/");
		driver.navigate().to("https://selenium-prd.firebaseapp.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SF_WaitUtilities.explicitlyWaitForVisibility(driver, driver.findElement(By.id("email_field")));
		WebElement userName = driver.findElement(By.id("email_field"));
		js.executeScript("arguments[0].value='admin123@gmail.com';", userName);
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		password.sendKeys(Keys.ENTER);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		js.executeScript("arguments[0].click();", loginButton);
		loginButton.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].setAttribute('id','fullname');", name);
		Thread.sleep(200000);
		js.executeScript("window.scrollBy(0,1000);");
		String url = js.executeScript("return document.domain;").toString();
		System.out.println(url);
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.close();
	}
}

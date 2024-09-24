package com.demo.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demo.utility.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginstepdefinitions{
	private  WebDriver driver;
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching driver
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		//maximize window
		driver.manage().window().maximize();
		driver.navigate().to("https://www.bestbuy.com/");		
		//delete cookies
		driver.manage().deleteAllCookies();
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {	
		WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
		   englishbuttonelement.click();
		   WebElement newuserregisterelement=driver.findElement(By.xpath("//span[.='Account']"));
		   newuserregisterelement.click();
		 WebElement signinbutton=driver.findElement(By.xpath("(//a[normalize-space()='Sign In'])[1]"));
		 signinbutton.click();
		 WebElement signinemail=driver.findElement(By.id("fld-e"));
		 signinemail.sendKeys("thomasphy@gmail.com");
		 WebElement signinpassword=driver.findElement(By.xpath("(//input[@id='fld-p1'])[1]"));
		 signinpassword.sendKeys("Raj@1234 -"); 
		
	
	}

	@Then("user click the login button")
	public void user_click_the_login_button()  {
		 WebElement loginbutton=driver.findElement(By.xpath("//button[.='Sign In']"));
		 loginbutton.click();
//		 File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenshot2, new File("seleniumconceptjat20wd\\demoblaze123.png"));
		 driver.close();
	}
	
}

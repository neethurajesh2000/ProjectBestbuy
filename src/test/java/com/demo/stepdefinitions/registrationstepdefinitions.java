package com.demo.stepdefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class registrationstepdefinitions {
	private  WebDriver driver;
	@Given("user is at sitehome page")
	public void user_is_at_sitehome_page() {
		
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

	@When("user click create account button")
	public void user_click_create_account_button() {
		WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
		englishbuttonelement.click();
		WebElement createaccountbutton=driver.findElement(By.xpath("//a[.='Create Account']"));
		   createaccountbutton .click();
//		   Set<String> windowhandles= driver.getWindowHandles();
//		   List<String> listwindows=new ArrayList<>(windowhandles);
//		   driver.switchTo().window(listwindows.get(1));
	}

	@When("user send first name")
	public void user_send_first_name() {
		WebElement firstname=driver.findElement(By.id("firstName"));
		firstname.sendKeys("neha");
	}

	@When("user send last name")
	public void user_send_last_name() {
		WebElement lastname=driver.findElement(By.id("lastName"));
	    lastname.sendKeys("tom");
	}

	@When("user send email")
	public void user_send_email() {
		 WebElement email=driver.findElement(By.id("email"));
		 email.sendKeys("neha@gmail.com");
	}

	@When("user send password")
	public void user_send_password() {
		 WebElement password=driver.findElement(By.id("fld-p1"));
		 password.sendKeys("Neha@1234 -");
	}

	@When("user send confirm password")
	public void user_send_confirm_password() {
		WebElement confirmpassword=driver.findElement(By.id("reenterPassword"));
		confirmpassword.sendKeys("Neha@1234 -");
	}

	@When("user send mobile number")
	public void user_send_mobile_number() {
		WebElement mobileno=driver.findElement(By.id("phone"));
		mobileno.sendKeys("9580153227");
	}

	@When("user click on recovery button")
	public void user_click_on_recovery_button() {
		 WebElement checkbox=driver.findElement(By.id("is-recovery-phone"));
		 checkbox.click();
	}

	@Then("click on submit button")
	public void click_on_submit_button() {
		WebElement submitbutton=driver.findElement(By.cssSelector("button[type='submit']"));
		   submitbutton.click();
		   driver.close();
	}
}

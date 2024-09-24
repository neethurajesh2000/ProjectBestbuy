package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.demo.utility.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
public class srchbrandandcheckoutstepdefinitions {
	private  WebDriver driver;
	@Given("user is at brandhome page")
	public void user_is_at_brandhome_page() {
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

	@Given("user click on menu button")
	public void user_click_on_menu_button() {
		WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
		englishbuttonelement.click();
		 WebElement brandmenubutton=driver.findElement(By.cssSelector("button[aria-label='Menu']"));
		 brandmenubutton.click();
	}

	@Given("user click on brand button")
	public void user_click_on_brand_button() throws InterruptedException {
		 WebElement brands=driver.findElement(By.xpath("//button[text()='Brands']"));
		 brands.click();
		 Thread.sleep(1000);
	}

	@Given("user click on product button")
	public void user_click_on_product_button() throws InterruptedException {
		 WebElement lgbrand=driver.findElement(By.xpath("//a[.='LG']"));
		 lgbrand.click();		
		 JavascriptExecutor jslgbrand= (JavascriptExecutor) driver;
		 jslgbrand.executeScript("window.scrollBy(0,1500)", "");
		 Thread.sleep(1000);	
	}

	@Given("user click on particular item button")
	public void user_click_on_particular_item_button() {
		 WebElement lgdishwasher=driver.findElement(By.xpath("//a[.='LG washers and dryers']"));
		 lgdishwasher.click();	
	}

	@When("user click on brandadd to cart button")
	public void user_click_on_brandadd_to_cart_button() {
		WebElement lgaddtocart=driver.findElement(By.xpath("(//button[text()='Add to Cart'])[1]"));
		 lgaddtocart.click();
	}

	@Then("user click on brandgo to cart button")
	public void user_click_on_brandgo_to_cart_button() {
		 WebElement GoToCartBrand=driver.findElement(By.xpath("//a[text()='Go to Cart']"));
		 GoToCartBrand.click();		  
	}

	@When("user click on checkout button")
	public void user_click_on_checkout_button() throws InterruptedException {
		WebElement Checkoutbutton=driver.findElement(By.xpath("//button[text()='Checkout']"));
		 Checkoutbutton.click();
		 Thread.sleep(1000);
	}

	@When("user click on continue as a guest")
	public void user_click_on_continue_as_a_guest() {
		WebElement signasguest=driver.findElement(By.xpath("//button[text()='Continue as Guest']"));
		 signasguest.click();
	}

	@When("user enters first name")
	public void user_enters_first_name() {
		 WebElement firstname=driver.findElement(By.xpath("//input[@id='firstName']"));
		 firstname.sendKeys("maya");
	}

	@When("user enters last name")
	public void user_enters_last_name() {
		 WebElement lastname=driver.findElement(By.xpath("//input[@id='lastName']"));
		 lastname.sendKeys("ammu");
	}

	@When("user enters street name")
	public void user_enters_street_name() {
		 WebElement Address=driver.findElement(By.id("street"));
		 Address.sendKeys("Green Villa, Third floor");
	}

	@When("user enters city name")
	public void user_enters_city_name() {
		 WebElement City=driver.findElement(By.id("city"));
		 City.sendKeys("Chennai");
	}

	@When("user select  state name")
	public void user_select_state_name() throws InterruptedException {
		WebElement selectelement=driver.findElement(By.id("state"));
		  Select select=new Select(selectelement);
		  select.selectByIndex(2);
		  Thread.sleep(1000);
	}

	@When("user enters  zip code")
	public void user_enters_zip_code() {
		 WebElement zipcode=driver.findElement(By.id("zipcode"));
		  zipcode.sendKeys("1234");
	}

	@When("user select  billing address checkbox")
	public void user_select_billing_address_checkbox() {
//		WebElement billingaddress=driver.findElement(By.xpath("//span[.='Use as billing address']"));
//		  billingaddress.click();
//		  WebElement SaveInformation=driver.findElement(By.xpath("//span[.='Save this information for next time']"));
//		  SaveInformation.click();
		  WebElement apply=driver.findElement(By.xpath("//button[.='Apply']"));
		  apply.click();
	}

	@Then("user click on apply button")
	public void user_click_on_apply_button() throws InterruptedException {
		 WebElement contactemail=driver.findElement(By.id("user.emailAddress"));
		  contactemail.sendKeys("thomasphy@gmail.com");
		  WebElement contactmobile=driver.findElement(By.id("user.phone"));
		  contactmobile.sendKeys("6282215068");
//		  Alert al=driver.switchTo().alert();
//		  al.accept();
//		  Thread.sleep(2000);
//		  System.out.println("Accept Alert");
		  WebElement serviceandappointmentbutton=driver.findElement(By.xpath("//label[text()='My orders, services and appointments']"));
		  serviceandappointmentbutton.click();
		  WebElement schedulebutton=driver.findElement(By.xpath("//span[text()='Continue to Schedule Delivery']"));
		  schedulebutton.click();
		  driver.close();
	}
}

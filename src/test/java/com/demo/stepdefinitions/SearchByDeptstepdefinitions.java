package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchByDeptstepdefinitions {
	private WebDriver driver;
	
	
	@Given("user is at home page")
	public void user_is_at_home_page() {
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

	@When("user click the menu button")
	public void user_click_the_menu_button() {
		 WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
	       englishbuttonelement.click();
       WebElement deptmenubutton=driver.findElement(By.cssSelector("button[aria-label='Menu']"));
       deptmenubutton.click();
	}

	@When("user click the department button")
	public void user_click_the_department_button() {
		 WebElement tvbutton=driver.findElement(By.xpath("//button[text()='TV & Home Theater']"));
		 tvbutton.click();
	}

	@When("user click brand button")
	public void user_click_brand_button() {
		WebElement tvbrand=driver.findElement(By.xpath("//button[text()='TVs by Brand']"));
		tvbrand.click();
	}

	@When("user click samsung product button")
	public void user_click_samsung_product_button() throws InterruptedException {
		 WebElement samsung=driver.findElement(By.xpath("//a[text()='Samsung TVs']"));
		 samsung.click();
		 Thread.sleep(1000);
	}

	@When("user click addtocart button")
	public void user_click_addtocart_button() {
		WebElement addtocartitem=driver.findElement(By.xpath("(//button[text()='Add to Cart'])[1]"));
		 addtocartitem.click();
	}

	@Then("user click gotocart button")
	public void user_click_gotocart_button() {
		WebElement GoToCartDept=driver.findElement(By.xpath("//a[text()='Go to Cart']"));
		 GoToCartDept.click();
		 driver.close();
	}


}

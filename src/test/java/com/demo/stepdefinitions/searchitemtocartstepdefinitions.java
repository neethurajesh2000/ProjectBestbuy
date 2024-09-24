package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.utility.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
public class searchitemtocartstepdefinitions {
	private  WebDriver driver;
	@Given("user ia at searchhome page")
	public void user_ia_at_searchhome_page() {
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

	@Given("user search the product")
	public void user_search_the_product() throws InterruptedException {
		WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
		englishbuttonelement.click();
		WebElement search=driver.findElement(By.id("gh-search-input"));
		 search.sendKeys("refrigerator");
		 search.click();
		 Thread.sleep(2000);
	}

	@When("user search refrigerator white")
	public void user_search_refrigerator_white() throws InterruptedException {
		 WebElement refrigeratorwhite=driver.findElement(By.xpath("//a[@title='refrigerator white']"));
		 refrigeratorwhite.click();
		 Thread.sleep(1000);
		 JavascriptExecutor js1= (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(0,500)", "");
	}

	@When("user click on add to cart button")
	public void user_click_on_add_to_cart_button() {
		 WebElement addtocart=driver.findElement(By.xpath("(//button[text()='Add to Cart'])[2]"));
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.visibilityOf(addtocart));		  
		 addtocart.click();
	}

	@Then("user click on go to cart button")
	public void user_click_on_go_to_cart_button() {
		 WebElement GoToCart=driver.findElement(By.xpath("//a[text()='Go to Cart']"));
		 GoToCart.click();
		 driver.close();
	}



}

package com.demo.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class navigatetomenustepdefinitions {
	private  WebDriver driver;
	@Given("user is at mainhome page")
	public void user_is_at_mainhome_page() {
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

	@Given("user click on the menu button")
	public void user_click_on_the_menu_button() {
		WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
		englishbuttonelement.click();
			
	}

	@When("user validate menu links by text")
	public void user_validate_menu_links_by_text() {
		
		try {
			 WebElement menu=driver.findElement(By.cssSelector("button[aria-label='Menu']"));
			 menu.click();
			 java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			 System.out.println(links.size());
			 for (int i = 1; i<=links.size(); i=i+1)
			 {
			 System.out.println(links.get(i).getText());
			 }
			}
			catch(Exception e) {
				
			}
		
		driver.close();
	}



}

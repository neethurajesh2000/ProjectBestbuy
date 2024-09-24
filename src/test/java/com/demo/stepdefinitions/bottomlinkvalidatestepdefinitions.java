package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class bottomlinkvalidatestepdefinitions {
	private  WebDriver driver;
	@Given("user is at botomhome page")
	public void user_is_at_botomhome_page() {
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

	@Given("user validate bottom links")
	public void user_validate_bottom_links() {
		try {
			 WebElement footer=driver.findElement(By.id("footer"));
			 List<WebElement> footerlinks = footer.findElements(By.tagName("a"));
			 System.out.println("Footer size is");
			 System.out.println(footerlinks.size());
			 for (int i = 1; i<=footerlinks.size(); i=i+1)
			 {
			 System.out.println(footerlinks.get(i).getText());
			 }
			 }
			 catch(Exception e) {
				 				 
			 }
		driver.close();
	}



}

package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tcbrokenurlstepdefinitions {
	private  WebDriver driver;
	
	@Given("uesr is at websitehome page")
	public void uesr_is_at_websitehome_page() {
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

	@Given("check the url is boken or not")
	public void check_the_url_is_boken_or_not() throws IOException, InterruptedException{
		//create set of url
		  Set<String> brokenlinkurls=new HashSet<String>();
		  List<WebElement>  links=driver.findElements(By.tagName("a"));
		  System.out.println(links.size());	  
		  //iterate through each link
		  for(WebElement link:links) {
			String linkurl= link.getAttribute("href");
//			Proxy proxy=new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("google",80));
			//create url object
			URL url=new URL(linkurl);
			//open connection using url for specifi proxy
//		    URLConnection urlConnection=url.openConnection(proxy);
		    //caste thr url connection to httpurl connection
//		    HttpURLConnection httpURLConnection= (HttpURLConnection)urlConnection;
			HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
		    httpURLConnection.setConnectTimeout(5000);
		    httpURLConnection.connect();//establish connection
		    	    
		    //check if http connection code !=200
		    if(httpURLConnection.getResponseCode()==200) {
		    	System.out.println("Working url :"+httpURLConnection.getResponseMessage());
		    }else {
		    	System.out.println("broken url: "+httpURLConnection.getResponseMessage());
		    }
		    httpURLConnection.disconnect();
		
		  }
		   WebElement englishbuttonelement=driver.findElement(By.xpath("//button[text()='English']"));
		   englishbuttonelement.click();
		   driver.close();
		   	   	  
	}

}

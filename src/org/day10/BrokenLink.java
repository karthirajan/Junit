package org.day10;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	static WebDriver driver;
	static long startTime;
	static String homePage = "https://www.zlti.com/";
	static HttpURLConnection http = null;
	int respcode = 200;
	
	@BeforeClass
	public static void beforeClass() throws InterruptedException {
		 
		
		
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\workspace\\karthi\\Demo\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(homePage);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);

	}
	
	@Before
	public void beforeMethod() {
		
		 startTime = System.currentTimeMillis();

	}
	
	@AfterClass
	public static void afterClass() {
		
		driver.quit();

	}
	
	@After
	public void afterMethod() {
		
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

	}
	
	@Test
	public void m1() throws Throwable {
		
		String url = "";
		
		List<WebElement> links = driver.findElements(By.tagName("link"));
		int size = links.size();
		System.out.println(size);
		
		Iterator<WebElement> iterator = links.iterator();
		
		while (iterator.hasNext()) {
			
			 url = iterator.next().getAttribute("href");
			 
			 if(url == null || url.isEmpty()) {
				 System.out.println("url is empty or not configured");
			 }
			 
			 if(!url.startsWith(homePage)) {
				 
				System.out.println("url belongs to another domain"); 
				 
			 }
			 
			 try {
				 
				http = (HttpURLConnection) (new URL(url).openConnection());
				
				http.setRequestMethod("HEAD");
				http.connect();
				
				respcode = http.getResponseCode();
				
				if(respcode >= 400) {
					System.out.println(url + "is a broken link");
				}else {
					System.out.println(url + "is a valid link");
				}
				 
				 
			 }catch (Exception e) {
				e.printStackTrace();
			}
			 
			 
			
		}

	}
	
}

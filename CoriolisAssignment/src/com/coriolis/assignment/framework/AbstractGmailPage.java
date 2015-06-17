package com.coriolis.assignment.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/***
 * @author Asmita Bhagwat
 * Tester has control of which browser driver he wants to use.
 * He just has to initialize driver and set it into the Page class.
 */
public class AbstractGmailPage {
	private static final String BASE_URL = "http://gmail.com/";
	
	protected WebDriver driver;

	public AbstractGmailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loadWebPage(){
		driver.get(BASE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void closeWebPage(){
		driver.quit();
		driver = null;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}

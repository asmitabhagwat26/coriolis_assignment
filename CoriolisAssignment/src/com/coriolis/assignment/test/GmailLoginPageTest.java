package com.coriolis.assignment.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.coriolis.assignment.framework.GmailLoginPage;

public class GmailLoginPageTest {

	GmailLoginPage gmailLoginPage;

	public GmailLoginPageTest() {
		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.profile", "default");
		
		gmailLoginPage = new GmailLoginPage(driver);
	}

	@Before
	public void loadWebPage() {
		gmailLoginPage.loadWebPage();
	}

	@After 
	public void closeWebPage() {
		gmailLoginPage.closeWebPage();
	}

	@Test
	public void testGmailLoginPageTitle(){
		assertEquals("Gmail",gmailLoginPage.getPageTitle());
	}
	
	@Test
	public void testGmailLoginSuccess() {
		gmailLoginPage.loginGmail("asmitabhagwat52@gmail.com","Sample#2015");
		
		assertEquals("asmitabhagwat52@gmail.com", gmailLoginPage.getSuccessfulLoginUserName());	
		}
	
}


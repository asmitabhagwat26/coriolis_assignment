package com.coriolis.assignment.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.coriolis.assignment.framework.GmailHomePage;
import com.coriolis.assignment.framework.GmailLoginPage;

public class GmailHomePageTest {

	GmailLoginPage gmailLoginPage;
	GmailHomePage gmailHomePage;

	public GmailHomePageTest() {
		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.profile", "default");

		gmailLoginPage = new GmailLoginPage(driver);
		gmailHomePage = new GmailHomePage(driver);
	}

	@Before
	public void loadWebPage() {
		gmailHomePage.loadWebPage();
	}

	@After 
	public void closeWebPage() {
		gmailHomePage.closeWebPage();
	}

	@Test
	//This is the expected Test Case for the Assignment
	public void testComposeMail() {
		gmailLoginPage.loginGmail("asmitabhagwat52@gmail.com","Sample#2015");
		assertEquals("asmitabhagwat52@gmail.com",gmailLoginPage.getSuccessfulLoginUserName());
		
		gmailHomePage.clickComposeButton();
		gmailHomePage.setMailTo("hiring@coriolis.co.in");
		gmailHomePage.setMailCc("shrikant.katkojwar@coriolis.co.in");
		gmailHomePage.setMailSubject("Coriolis Assignment");
		gmailHomePage.setMailBodyText("Name: Asmita Bhagwat \nContact No : 9423755740 \nLink to github : https://github.com/asmitabhagwat26/coriolis_assignment.git");
		gmailHomePage.clickSendMail();
		assertEquals("Your message has been sent. View message", gmailHomePage.getMailSentSuccessMessage());
	}
}

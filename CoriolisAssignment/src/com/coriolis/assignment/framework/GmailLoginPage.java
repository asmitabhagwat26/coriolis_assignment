package com.coriolis.assignment.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * @author Asmita Bhagwat
 * 
 */
public class GmailLoginPage extends AbstractGmailPage{

	public GmailLoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginGmail(String strEmail, String strPassword) {
		WebElement textBoxEmail = driver.findElement(By.id("Email"));
		textBoxEmail.clear();
		textBoxEmail.sendKeys(strEmail);

		WebElement buttonNext = driver.findElement(By.id("next"));
		buttonNext.click();

		WebElement textBoxPassword = driver.findElement(By.id("Passwd"));
		textBoxPassword.clear();
		textBoxPassword.sendKeys(strPassword);

		WebElement checkBoxRememberSignIn = driver.findElement(By.id("PersistentCookie"));
		if(checkBoxRememberSignIn.isSelected()){
			checkBoxRememberSignIn.click();
		}

		WebElement buttonSignIn = driver.findElement(By.id("signIn"));
		buttonSignIn.click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[1]/a[contains(@title,'Google Account:')]")));
	}
	
	public String getSuccessfulLoginUserName() {
		String pageUser = driver.findElement(By.xpath("//div[1]/a[contains(@title,'Google Account:')]")).getText();
		return pageUser;
	}

	
}

package com.coriolis.assignment.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/***
 * @author Asmita Bhagwat
 * This page contains methods for each operation separately.
 * It brings modularity to the framework and full control in hands of tester writing test cases.
 */
public class GmailHomePage extends AbstractGmailPage {
	
	public GmailHomePage(WebDriver driver) {
		super(driver);
	}

	public void clickComposeButton() {
		WebElement composeButton = driver.findElement(By.xpath("//div[contains(@class,'T-I J-J5-Ji T-I-KE L3')]"));
		composeButton.click();
	}

	public void setMailBodyText(String strMailBody) {
		WebElement textBoxMailBody = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		textBoxMailBody.sendKeys(strMailBody);
	}

	public void setMailSubject(String strMailSubject) {
		WebElement textBoxMailSubject = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		textBoxMailSubject.sendKeys(strMailSubject);
	}

	public void setMailCc(String strMailCc) {
		WebElement buttonCc = driver.findElement(By.xpath("//span[@class='aB gQ pE']"));
		buttonCc.click();
				
		WebElement ccField = driver.findElement(By.xpath("//textarea[@name='cc']"));		
		ccField.sendKeys(strMailCc);
	}

	public void setMailTo(String mailTo) {
		WebElement toField = driver.findElement(By.xpath("//textarea[@name='to']"));		
		toField.sendKeys(mailTo);
	}
	
	public void clickSendMail(){
		WebElement buttonSend = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO T-I-atl L3']"));
		buttonSend.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Your message has been sent')]")));
	}

	public String getMailSentSuccessMessage() {
		WebElement labelMailSentSuccessMessage = driver.findElement(By.xpath("//div[contains(text(),'Your message has been sent')]"));
		
		String message = labelMailSentSuccessMessage.getText();
		return message;
	}
	
}

package com.Pages.ibi;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Utilis.ConfigReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class LoginPage extends PageObject {

	
	ConfigReader configReader = new ConfigReader();

	private String usr = configReader.doReadProperties().getProperty("username");
	private String pwd = configReader.doReadProperties().getProperty("password");

	
	@Step
	public void doLaunchIbi() {
		this.open();
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

	}

	@Step
	public void isLandingPageVisible() {

		String title = getDriver().getTitle();
		System.out.print(title);
		Assert.assertEquals("Title did not match", title, "ibi");
	}

	@Step
	public void doClickOnSignInButton() {

		$(By.xpath("//*[contains(text(),'Sign in')]")).click();
	}

	
	// String Manupulation
	public String doManipulateUsername() {

		String manipulatdeUserName = "qwerty" + usr;

		return manipulatdeUserName;
	}

	
	@Step
	public void doEnterCredentials(String scenario) {

		if (scenario.equals("Success")) {
			$(By.xpath("//input[@name='email']")).type(usr);
			$(By.xpath("//input[@name='password']")).type(pwd);
		} else {
			$(By.xpath("//input[@name='email']")).type(this.doManipulateUsername());
			$(By.xpath("//input[@name='password']")).type(pwd);
		}

	}

	@Step
	public void doClickOnContinueButton() throws InterruptedException {
        
		
		$(By.xpath("//*[contains(text(),'Continue')]")).click();
		Thread.sleep(2000);
		Serenity.takeScreenshot();
		Thread.sleep(5000);

	}

	@Step
	public void verifyInnerCirclePage() throws InterruptedException {

		boolean innerCircle = getDriver().getCurrentUrl().contentEquals("https://ibi.sandisk.com/cloud/innercircle");
		Assert.assertTrue("URL Did not Match, Login failed", innerCircle);
		Thread.sleep(2000);
		Serenity.takeScreenshot();

	}

	@Step
	public void verifyErrorWarning() {

		WebElementFacade errorWarning = $(By.xpath("//div[@class='Onboarding__inline-error-wrapper']"));
		String warning = errorWarning.getText();
		boolean verifyWarning = warning.contentEquals("Wrong email or password.");
		Assert.assertTrue("Error Message did not matched since the error message is displayed"+" "+warning, verifyWarning);
	}

	public void verifyForgotLinkIsDisplayed() {

		boolean forgotLink = $(By.xpath("//*[contains(text(),'Forgot your password?')]")).isVisible();
		Assert.assertTrue("ForgotLink is not displayed", forgotLink);
	}

	public void doClickOnForgotLink() {

		$(By.xpath("//*[contains(text(),'Forgot your password?')]")).click();

	}

	public void verifyResetPasswordTextIsDisplayed() throws InterruptedException {

		boolean resetPassword = $(By.xpath("//*[contains(text(),'Reset password')]")).isDisplayed();
		Assert.assertTrue("ResetPassword text is not displayed", resetPassword);
		Serenity.takeScreenshot();

	}

}
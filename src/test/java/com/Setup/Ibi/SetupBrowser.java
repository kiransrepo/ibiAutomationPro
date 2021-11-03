package com.Setup.Ibi;

import org.openqa.selenium.By;

import Utilis.ConfigReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class SetupBrowser extends PageObject{
	
	

	ConfigReader configReader = new ConfigReader();

	private String usr = configReader.doReadProperties().getProperty("username");
	private String pwd = configReader.doReadProperties().getProperty("password");

	@Step
	public void LaunchIbiApp() throws InterruptedException {
		
		getDriver().navigate().to("https://ibi.sandisk.com/sessions/new");
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		$(By.xpath("//input[@name='email']")).type(usr);
		$(By.xpath("//input[@name='password']")).type(pwd);
		$(By.xpath("//*[contains(text(),'Continue')]")).click();
		Thread.sleep(2000);
		Serenity.takeScreenshot();
		Thread.sleep(5000);
		
	}
	
	

}

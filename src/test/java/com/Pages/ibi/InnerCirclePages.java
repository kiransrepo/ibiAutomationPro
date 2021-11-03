package com.Pages.ibi;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import Utilis.ConfigReader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class InnerCirclePages extends PageObject {

	ConfigReader configReader = new ConfigReader();

	private String usr = configReader.doReadProperties().getProperty("username");
	private String pwd = configReader.doReadProperties().getProperty("password");

	@Step
	public void LaunchIbi() throws InterruptedException {

		getDriver().navigate().to("https://ibi.sandisk.com/sessions/new");
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		$(By.xpath("//input[@name='email']")).type(usr);// wdsantest+liveqawdc@gmail.com
		$(By.xpath("//input[@name='password']")).type(pwd);//"Mani1234@"
		$(By.xpath("//*[contains(text(),'Continue')]")).click();
		Thread.sleep(2000);
		Serenity.takeScreenshot();
		Thread.sleep(3000);

	}

	@Step
	public void doClickOnPostToInnerCircleButton() throws InterruptedException {

		$(By.xpath("//div[@class='FloatingActionButton']")).click();
		Thread.sleep(3000);
		boolean select = $(By.xpath("//*[contains(text(),'0 selected')]")).isVisible();
		Assert.assertTrue("Select Is not displayed", select);
	}

	@Step
	public void doSelectContents() throws InterruptedException {

		Actions action = new Actions(getDriver());
		action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
		Thread.sleep(2000);

	}

	@Step
	public void doClickPostToInnerCircle() throws InterruptedException {

		$(By.xpath("//*[@class='FloatingActionButton__text FloatingActionButton__text--no-icon' and contains(text(),'Post to inner circle')]")).waitUntilVisible();
		WebElementFacade postButtton = $(By.xpath("//*[@class='FloatingActionButton__text FloatingActionButton__text--no-icon' and contains(text(),'Post to inner circle')]"));
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", postButtton);

	}

	@Step
	public void verifySuccessToastMessageIsDisplayed() throws InterruptedException {

		WebElementFacade toast = $(
				By.xpath("//div[@class='Informer-global']//ul[@class='Informer-list']//li[@class='Informer-item']"));
		toast.waitUntilVisible();
		Serenity.takeScreenshot();
		boolean toastMsg = $(
				By.xpath("//div[@class='Informer-global']//ul[@class='Informer-list']//li[@class='Informer-item']"))
						.isDisplayed();
		String toastMsgTxt = $(
				By.xpath("//div[@class='Informer-global']//ul[@class='Informer-list']//li[@class='Informer-item']"))
						.getText();
		boolean verifyText = toastMsgTxt
				.contentEquals("Post added. Your post will show up on Inner Circle tab shortly.");
		Assert.assertTrue("Excpeted toast message is not displayed but" + " " + verifyText + " " + "in the toast",
				verifyText);
		System.out.print(toastMsg);
		getDriver().navigate().refresh();

	}

	@Step
	public void addDescriptionToInnerCirclePost() throws InterruptedException {

		WebElementFacade despInput = $(
				By.xpath("//div[@class='AppCaptionInfo__descriptionText AppCaptionInfo__descriptionLabel']"))
						.waitUntilVisible();
		boolean despVisbl = despInput.isVisible();
		Assert.assertTrue(despVisbl);

		// Click on description
		List<WebElementFacade> tabs = findAll(
				"//div[@class='AppCaptionInfo__descriptionText AppCaptionInfo__descriptionLabel']");
		int l = tabs.size();
		for (int i = 0; i <= tabs.size(); i++) {
			if (i == 1) {

				$(By.xpath("//div[@class='AppCaptionInfo__descriptionText AppCaptionInfo__descriptionLabel']")).click();
//				$(By.xpath("//textarea[@class='AutocapitalizeInput AppCaptionEdit__descriptionInput']//..//..//..")).waitUntilVisible();
//				$(By.xpath("//textarea[@class='AutocapitalizeInput AppCaptionEdit__descriptionInput']//..//..//..")).click();
//				$(By.xpath("//textarea[@class='AutocapitalizeInput AppCaptionEdit__descriptionInput']//..//..//..")).type("AutomatedComment");
//				
			}
		}

	}
	
	@Step
	public void doLikeAPost() {
		List<WebElementFacade> like = findAll("//div[@class='icon icon-reaction-love-big']");
		for (int i = 0; i <= like.size(); i++) {
			if (i == 1) {

				$(By.xpath("//div[@class='icon icon-reaction-love-big']")).click();
				String likeVisiable = $(By.xpath("//*[@class='AppCaptionIconCounter AppCaptionIconCounter--black AppCaptionIconCounter--big' and contains(text(),'1')]")).getText();
				boolean likeTrue = likeVisiable.contentEquals(likeVisiable);
				Assert.assertTrue("Lke is not reflected", likeTrue);
				
			}
		}

	}
	
	@Step
	public void doCommentOnPost() {
		String Comment = "This is an automated comment";
		$(By.xpath("//textarea[@class='AutocapitalizeInput  AppCaptionEditCommentInput__input']")).click();
		$(By.xpath("//textarea[@class='AutocapitalizeInput  AppCaptionEditCommentInput__input']")).sendKeys(Comment);
		$(By.xpath("//div[@class='icon icon-send-comment ButtonIcon__icon  ']")).click();
			
	}
	
	@Step
	public void doVerifyComments() throws InterruptedException {
		String Comment = "This is an automated comment";
		String commentVisiable = $(By.xpath("//*[@class='AppCaptionEditComment__text' and contains(text(),'"+Comment+"')]")).getText();
		boolean commentTrue = commentVisiable.contentEquals(Comment);
		Assert.assertTrue("Comments is not reflected", commentTrue);
		Serenity.takeScreenshot();
		Thread.sleep(2000);
	}
	
	@Step
	public void doEditTheCommentOnPost() throws InterruptedException {
		
		String editedComment = "The is an edited comment";
		$(By.xpath("//div[@class='AppCaptionEditComment__actions']//div[@class='ButtonIcon  ButtonIcon--capitalized AppCaptionEditComment__actionsButton']//div[@class='icon icon-dot-horizontal ButtonIcon__icon  ']")).click();
		$(By.xpath("//div[@class='ContextMenuItem ContextMenuItem--notTouch ContextMenuItem--enable']")).click();
		$(By.xpath("//textarea[@class='AutocapitalizeInput  AppCaptionEditCommentInput__input']")).click();
		$(By.xpath("//textarea[@class='AutocapitalizeInput  AppCaptionEditCommentInput__input']")).sendKeys(" "+editedComment);
		$(By.xpath("//div[@class='icon icon-send-comment ButtonIcon__icon  ']")).click();
		Serenity.takeScreenshot();
		Thread.sleep(2000);
		
	
	}
	@Step
	public void doDeleteComment() throws InterruptedException {
		$(By.xpath("//div[@class='AppCaptionEditComment__actions']//div[@class='ButtonIcon  ButtonIcon--capitalized AppCaptionEditComment__actionsButton']//div[@class='icon icon-dot-horizontal ButtonIcon__icon  ']")).click();
		$(By.xpath("//div[@class='ContextMenuItem ContextMenuItem--notTouch ContextMenuItem--enable ContextMenuItem--delete']")).click();
		Serenity.takeScreenshot();
		Thread.sleep(2000);
	}
	
	@Step
	public void doRemovePost() throws InterruptedException {
		
		$(By.xpath("//div[@class='icon icon-dot-horizontal ButtonIcon__icon  ']")).click();
		$(By.xpath("//div[@class='ContextMenuItem ContextMenuItem--notTouch ContextMenuItem--enable ContextMenuItem--delete']")).click();
		Thread.sleep(2000);
		
		
		
		
	}

	
}

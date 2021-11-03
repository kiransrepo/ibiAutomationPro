package com.stepDef.ibi;

import com.Pages.ibi.InnerCirclePage;
import com.Pages.ibi.InnerCirclePages;
import com.Pages.ibi.LoginPage;
import com.Setup.Ibi.SetupBrowser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class innerCirclePageStep {

	@Steps
	LoginPage loginpage;

	@Steps
	InnerCirclePages innerCircle;

	@Steps
	SetupBrowser setup;

	@Given("Login into Ibi webapp")
	public void login_into_ibi_webapp() throws InterruptedException {

		innerCircle.LaunchIbi();

	}

	@Then("User lands on innercircle page")
	public void user_lands_on_innercircle_page() throws InterruptedException {

		loginpage.verifyInnerCirclePage();

	}

	@Then("Clicks on Post to inner cricle button")
	public void clicks_on_post_to_inner_cricle_button() throws InterruptedException {

		innerCircle.doClickOnPostToInnerCircleButton();

	}

	@Then("User selects few contents")
	public void user_selects_few_contents() throws InterruptedException {

		innerCircle.doSelectContents();
	}

	@Then("Clicks on Post to Inner circle")
	public void clicks_on_post_to_inner_circle() throws InterruptedException {

		innerCircle.doClickPostToInnerCircle();

	}

	@Then("Verfiy Post Created toast message is displayed")
	public void verfiy_post_created_toast_message_is_displayed() throws InterruptedException {

		innerCircle.verifySuccessToastMessageIsDisplayed();

	}

	/// Add Description,Like and Comment

	@Then("Click on add description field and enter some random description")
	public void click_on_add_description_field_and_enter_some_random_description() throws InterruptedException {

		innerCircle.addDescriptionToInnerCirclePost();
	}

	@Then("Click on Save")
	public void click_on_save() {

		System.out.print("Pass");

	}

	@Then("Click on Like icon and Verify like is reflected")
	public void click_on_like_icon_and_verify_like_is_reflected() {

		innerCircle.doLikeAPost();
	}

	@Then("Click on comments section and add some comments.")
	public void click_on_comments_section_and_add_some_comments() {
		innerCircle.doCommentOnPost();

	}

	@Then("Verify entered Comments are reflecting")
	public void verify_entered_comments_are_reflecting() throws InterruptedException {
		innerCircle.doVerifyComments();

	}

	@Then("Edit entered comments and do verify they are reflecting")
	public void edit_entered_comments_and_do_verify_they_are_reflecting() throws InterruptedException {
		innerCircle.doEditTheCommentOnPost();

	}

	@Then("Delete the entered comments")
	public void delete_the_entered_comments() throws InterruptedException {
		innerCircle.doDeleteComment();

	}

	@Then("Remove an existing post from innerCircle")
	public void remove_an_existing_post_from_inner_circle() throws InterruptedException {
		
		innerCircle.doRemovePost();
		
	}

}

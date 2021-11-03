package com.stepDef.ibi;

import com.Pages.ibi.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class loginPageStepDef {
	
	@Steps
	LoginPage loginPage;
	
	@Given("Launch the browser and enter the valid Prod URL")
	public void launch_the_browser_and_enter_the_valid_prod_url() {
	    
		loginPage.doLaunchIbi();
		
	}

	@When("User redirects on landing page click on SignIn button")
	public void user_redirects_on_landing_page_click_on_sign_in_button() {
	   
		loginPage.isLandingPageVisible();
		loginPage.doClickOnSignInButton();

		
	}
	
	@Then("Login page is displayed and enter the valid username and password {string} test scenario")
	public void login_page_is_displayed_and_enter_the_valid_username_and_password_test_scenario(String scenario) {
		
		loginPage.doEnterCredentials(scenario);
	}

	

	@Then("click on Continue button")
	public void click_on_continue_button() throws InterruptedException {
	    
		loginPage.doClickOnContinueButton();
		
	}

	@Then("User lands on inner circle page")
	public void user_lands_on_inner_circle_page() throws InterruptedException {
	    
		loginPage.verifyInnerCirclePage();
	}

	

	@Then("Login page is displayed and enter the invalid username and valid password based on {string} test scenario")
	public void login_page_is_displayed_and_enter_the_invalid_username_and_valid_password_based_on_test_scenario(String scenario) {
		
		loginPage.doEnterCredentials(scenario);
	}
	
	@Then("User will be unable to login and error message is displayed")
	public void user_will_be_unable_to_login_and_error_message_is_displayed() {
	    
		loginPage.verifyErrorWarning();
	}
	
	
	
	@Then("Login page is displayed and verify forgot link is visiable")
	public void login_page_is_displayed_and_verify_forgot_link_is_visiable() {
	    
		loginPage.verifyForgotLinkIsDisplayed();
		
	}

	@Then("Click on forgot link")
	public void click_on_forgot_link() {
	    
		loginPage.doClickOnForgotLink();
	}

	@Then("Verify user lands on rest password page")
	public void verify_user_lands_on_rest_password_page() throws InterruptedException {
	    
		loginPage.verifyResetPasswordTextIsDisplayed();
		
		
	}
	
}

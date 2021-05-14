package stepDefinitions;


import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class MyStepDefinitions {

    @Given("^user is on netbanking loginpage$")
    public void user_is_on_netbanking_loginpage() throws Throwable {
      System.out.println("Navigate to login page");
    }

    @When("^user logins with username and password$")
    public void user_logins_with_username_and_password() throws Throwable {
    	System.out.println("Enter User Name and password");
    }

    @Then("^home page is populated$")
    public void home_page_is_populated() throws Throwable {
    	System.out.println("Home page populated");
    }

    @And("^cards are displayed$")
    public void cards_are_displayed() throws Throwable {
    	System.out.println("Cards deisplayed");
    }

}
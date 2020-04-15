package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	@Given("^User is on NetBanking landing page$")
	public void Method1()
	{
		System.out.println("method1");
	}
	
	@When("^User login into application with user name and password$")
	public void Method2()
	{
		System.out.println("method2");
	}
	
	@Then("^Home page is populated$")
	public void Method3()
	{
		System.out.println("method3");
	}
	@And("^Cards are displayed$")
	public void Method4()
	{
		System.out.println("method4");
	}
	
}

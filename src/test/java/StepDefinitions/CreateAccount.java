package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccount {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Open cart home page$")
	public void LaunchOpencart()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	@When("^Create Account$")
	public void CreateAccount()
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Gurunathan");
		driver.findElement(By.id("input-lastname")).sendKeys("N");
		driver.findElement(By.id("input-email")).sendKeys("gurunathan.gn5@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8508128478");
		driver.findElement(By.id("input-password")).sendKeys("guruspartan77");
		driver.findElement(By.id("input-confirm")).sendKeys("guruspartan77");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Boolean flag=false;
		
		try
		{
			driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
			flag=true;
			System.out.println("Account Already Created");
		}
		catch(Exception e)
		{
			flag=false;
		}
		
		if(flag)
		{
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.linkText("Login")).click();	
		driver.findElement(By.id(("input-email"))).sendKeys("gurunathan.gn5@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("guruspartan77");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		}
	}
	@And("^Fill Enquiry$")
	public void FillEnquiry()
	{
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.id("input-enquiry")).sendKeys("looking for fast delivery options.....");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.findElement(By.linkText("Continue")).click();
	}	
	@And("^Review a product$")
	public void ReviewProduct()
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("MacBook Air");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		driver.findElement(By.linkText("MacBook Air")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Reviews')]")).click();
		driver.findElement(By.id("input-review")).sendKeys("Good product from apple.......");
		driver.findElement(By.xpath("//input[@value='5']")).click();
		driver.findElement(By.id("button-review")).click();
		
	}
	@And("^Add the product to wishlist$")
	public void AddProductToWishList()
	{
		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']/i[@class='fa fa-heart']")).click();
	}
	@And("^Retrieve the price for the product in different currencies$")
	public void RetrivePrice() throws Exception
	{
		String arr[]= {"Euro","Pound Sterling","US Dollar"};
		
		for(int i=0;i<arr.length;i++)
		{
			driver.findElement(By.xpath("//span[text()='Currency']")).click();
			driver.findElement(By.xpath("//button[contains(text(),'@@@@')]".replaceAll("@@@@", arr[i]))).click();
			wait=new WebDriverWait(driver,30);
			Thread.sleep(5000);
			String price=driver.findElement(By.xpath("//li[contains(text(),'Availability')]/following::ul/li/h2")).getText();
		System.out.println("Prize in "+arr[i]+" : "+price);
		
		}
		
	}
	@And("^Add product to cart$")
	public void AddProductToCart()
	{
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	}
	
	@Then("^Logout$")
	public void Logout()
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}

}

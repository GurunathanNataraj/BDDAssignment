package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GiftVoucher {
	WebDriver driver;
	@Given("^User is on open cart landing page$")
	public void LauchOpenCart()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@When("^Login$")
	public void Login()
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();	
		driver.findElement(By.id(("input-email"))).sendKeys("gurunathan.gn5@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("guruspartan77");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	@And("^Go to Gift Voucher and fill details$")
	public void FillGiftVoucherDetails()
	{
		driver.findElement(By.linkText("Gift Certificates")).click();
		driver.findElement(By.id("input-to-name")).sendKeys("Guru");
		driver.findElement(By.id("input-to-email")).sendKeys("gurunathannataraj@gmail.com");
		driver.findElement(By.xpath("//label[normalize-space()='@@@@']/input".replaceAll("@@@@","General"))).click();
		driver.findElement(By.id("input-message")).sendKeys("All the best");
		driver.findElement(By.id("input-amount")).clear();
		driver.findElement(By.id("input-amount")).sendKeys("100");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	}
	@And("^Go to shopping cart and remove extra products$")
	public void RemoveExtraProducts() throws Exception
	{
		driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
		int NumberOfProductsinCart=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr")).size();
		for(int i=0;i<NumberOfProductsinCart-1;i++)
		{
			driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
			Thread.sleep(5000);
		}
	}
	@And("^Click on contact us and fill enquiry$")
	public void FillEnquiry()
	{
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.id("input-enquiry")).sendKeys("looking for fast delivery options.....");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.findElement(By.linkText("Continue")).click();
	}
	@And("^Go to wish list and Edit Account information and Telephone number$")
	public void EditAccountInformation()
	{
		driver.findElement(By.id("wishlist-total")).click();
		driver.findElement(By.linkText("Edit Account")).click();
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys("8508128478");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	@And("^Go to order history and view requests$")
	public void OrderHistory()
	{
		driver.findElement(By.linkText("Order History")).click();
		if(driver.findElement(By.xpath("//h1[text()='Order History']")).isDisplayed())
		{
			System.out.println("User is able to see order history");
		}
		else
		{
			System.out.println("User is not able to see order history");
		}
	}
	@And("^Go to modify address book  and edit address$")
	public void EditAddress() throws Exception
	{
		driver.findElement(By.linkText("Address Book")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("input-address-1")).clear();
		driver.findElement(By.id("input-address-1")).sendKeys("Velachery");
//		Select country=new Select(driver.findElement(By.id("input-country")));
//		country.selectByVisibleText("India");
//		Select state=new Select(driver.findElement(By.id("input-zone")));
//		state.selectByValue("1503");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		Thread.sleep(5000);
//		if(driver.findElement(By.xpath("//div[text()=' Your address has been successfully updated']")).isDisplayed())
//		{
//			System.out.println("Edited address updated successfully");
//		}
//		else
//		{
//			System.out.println("Edited address not updated successfully");
//		}
	}
	@Then("^ApplicationLogout$")
	public void Logout()
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}




















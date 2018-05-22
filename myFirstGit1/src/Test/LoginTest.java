package Test;
import org.testng.annotations.Test;


import Pages.LoginPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




public class LoginTest {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
	    System.setProperty("webdriver.firefox.marionette","pathToGeckodriver");
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://twhyderabad.github.io/demo_site/");
	}
	@Test(priority=5)
	public void verify1()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("admin");
	    login.click_button();
	    Assert.assertTrue(driver.getPageSource().contains("Blog"));
	}
	@Test(priority=1)
	public void verify2()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("adm");
	    login.set_password("admin");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	@Test(priority=2)
	public void verify3()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("adm");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	@Test(priority=3)
	public void verify4()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("adm");
	    login.set_password("adm");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	@Test(priority=4)
	public void verify5()
	{
	    LoginPage login=new LoginPage(driver);
	    login.set_username("");
	    login.set_password("");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	@AfterTest
	public void close()
	{
	    driver.close();
	}

}

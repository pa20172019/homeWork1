package addAccount;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewAccount {
	WebDriver driver;

	@Before
	public void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	@Test
	public void CreateAccount() throws InterruptedException {
		
		driver.findElement(By.cssSelector("i[class='fa fa-university']")).click();
		Thread.sleep(3000);
		driver.get("https://techfios.com/billing/?ng=accounts/add/");
		driver.findElement(By.cssSelector("input[type='text'][id='account']")).sendKeys("James2");
		driver.findElement(By.cssSelector("input[type='text'][id='description']")).sendKeys("Checking");
		driver.findElement(By.cssSelector("input[type='text'][id='balance']")).sendKeys("$3000.00");
		driver.findElement(By.cssSelector("input[type='text'][id='account_number']")).sendKeys("22889977");
		driver.findElement(By.cssSelector("input[type='text'][id='contact_person']")).sendKeys("Bond");
		driver.findElement(By.cssSelector("input[type='text'][id='contact_phone']")).sendKeys("2145678765");
		driver.findElement(By.cssSelector("button[type='submit'][class='btn btn-primary']")).click();
		

	}

	/*
	 * @After public void teardown() { driver.close(); driver.quit(); }
	 */
}

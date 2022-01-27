import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniuminterview {

	public WebDriver webdriver;
	public static void main(String[] args) {
		
		ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new ChromeDriver());
		//System.setProperty("WebDriver.chrome.driver", "path of driver.exe");
		//WebDriver driver=new ChromeDriver();
		
		
		//basic configs
		tlDriver.get().manage().window().maximize();
		tlDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tlDriver.get().get("https://www.amazon.in/");
		tlDriver.get().findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("phone");
		tlDriver.get().findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		tlDriver.get().findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]")).click();
		tlDriver.get().close();

	}

}

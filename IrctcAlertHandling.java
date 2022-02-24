package week3.selinium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcAlertHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*driver.findElement(By.xpath("//span[text()='Alert']"));
		Alert alert = driver.switchTo().alert();
		alert.accept();*/
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

}

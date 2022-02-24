package week3.selinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		
		WebElement search = driver.findElement(By.xpath("(//input[@id='brandSearchBox'])"));
		search.sendKeys("L'Oreal Paris");
		
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String title1 ="Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
		
		if(title1.equals(title)) {
			System.out.println("The Page You Gone Is Correct");
		}else {
			System.out.println("The Page You Gone Is Wrong");
		}
		driver.close();
				}
}

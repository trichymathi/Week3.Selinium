package week3.selinium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement mensFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String title2 ="Sports Shoes For Men - Upto 70% OFF on Top Shoe Brands";
		if(title.equals(title2)) {
			System.out.println("Title Is Correct");
		}else {
			System.out.println("Title Is Incorrect");
		}
		
		Thread.sleep(1500);
		WebElement shoesCount = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div"));
		String text = shoesCount.getText();
		System.out.println("ShoesCount="+text);
		
		/*List<WebElement> shoesCount = driver.findElements(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div"));
		int size = shoesCount.size();
		System.out.println(size);*/
		
		driver.close();

	}

}

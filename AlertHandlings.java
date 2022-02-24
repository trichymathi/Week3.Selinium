package week3.selinium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandlings {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//AlertBox Accept
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alertBox = driver.switchTo().alert();
		Thread.sleep(1500);
		alertBox.accept();
		
		//ConfirmBox To Select Weather ok/Cancel
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(1500);
		Alert confirmBox = driver.switchTo().alert();
		confirmBox.dismiss();
		
		//Allow Text In Alert Box Using SendKeys
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert promptBox = driver.switchTo().alert();
		promptBox.sendKeys("Alert Arumugam Company");
		Thread.sleep(2000);
		promptBox.accept();
		
		//To Get The Text In The Alert Box
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert lineBreak = driver.switchTo().alert();
		String text = lineBreak.getText();
		System.out.println(text);
		lineBreak.accept();
		
		//To Directly Click Ok (SWEET ALERT)
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		
		
		driver.close();
	}

}

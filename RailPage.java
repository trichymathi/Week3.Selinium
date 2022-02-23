package week3.selinium;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RailPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MS",Keys.TAB);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MDU",Keys.TAB);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		Thread.sleep(2000);
		List<WebElement> rowSize = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int size = rowSize.size();
		System.out.println(size);
		
		for(int i=1;i<=size;i++) {
			String trainNo = driver.findElement(By.xpath("//div[@id='divTrainsList']//tr["+i+"]//td[1]")).getText();
			String trainName= driver.findElement(By.xpath("//div[@id='divTrainsList']//tr["+i+"]//td[2]")).getText();
            System.out.println("TRAIN NUMBER & TRAIN NAME : "+"("+trainNo+")"+" "+trainName);
		}
		driver.close();
		}
}
package TestPkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;	
	
public class TestClass {

	Path currentRelativePath = Paths.get("");
	String getprojtPath = currentRelativePath.toAbsolutePath().toString();	
	
	public WebDriver driver;

	public String baseUrl = "https://www.chick-fil-a.com/Locations";
	String driverPath = "C:\\Users\\ke291856\\Downloads\\chromedriver_win32/chromedriver.exe";

	String getElement = "";

	@Test
	public void webScraping() throws IOException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		String siteTitle = driver.getTitle();	

//		 WebElement webElement = driver.findElement(By.xpath("//*[@id='js-yl-12103061']/article/div[2]/div[1]/div[1]/h3/a/span/span"));
//		 System.out.println("getElement...."+ webElement.getText());
//		 System.out.println("getElement...."+ webElement.getAttribute("innerHTML"));

//		 String text = driver.findElement(By.cssSelector("span.LocationName-geo")).getText();
//		 System.out.print("text.."+ text);

		FileWriter writer = new FileWriter(getprojtPath+"/OutputFile.csv", false);
		writer.append("Title");
		writer.append(siteTitle);
		writer.append(',');
		writer.append("Location Name");
		writer.append(',');
		writer.append("City");
		writer.append(',');
		writer.append("State");
		writer.append(',');
		writer.append('\n');
		writer.flush();
		writer.close();

		// Reference
		// driver.get("https://en.wikipedia.org/wiki/Main_Page");
		// String str =
		// driver.findElement(By.xpath("//*[@id='mp-tfa']/p")).getText();
		// System.out.println(str);

		// driver.get("https://www.edureka.co/devops");
		// String output =
		// driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[1]/div[2]/div[1]/div")).getText();
		// System.out.print("output"+ output);
		// File DestFile= new File("extractedFilePath");
		// FileUtils.writeStringToFile(DestFile, output);

		driver.close();
	}

}	
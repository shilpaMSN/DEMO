package My_TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import CI_Pageobjects.CI_FB_pageobject;

public class CI_BaseTest {

	public static WebDriver driver;

	public WebDriver browserInitialize() throws IOException {
		Properties property = new Properties();
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Practise\\resources\\Global.properties");
		property.load(stream);
		String browserName = property.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	
	
	
	@BeforeMethod(alwaysRun = true)
	public  CI_FB_pageobject launchApp() throws IOException {
		driver = browserInitialize();
		CI_FB_pageobject pageobject=new CI_FB_pageobject(driver);
		pageobject.goTo();
		return pageobject;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	



	// UTILITY

	public List<HashMap<String, String>> jsonDataReader(String filepath) throws IOException {

		String jsonfile = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String, String>> data = map.readValue(jsonfile,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	// DATA PROVIDER METHOD
	@DataProvider
	public Object[][] jsonData() throws IOException {
		List<HashMap<String, String>> data = jsonDataReader(
				"C:\\Eclipse-workspace\\MYpractice\\src\\test\\java\\My_Data\\data.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	
	public String takeScreenShot(String testname,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenaShot=ts.getScreenshotAs(OutputType.FILE);
		File copyScreenShot=new File("C:\\Eclipse-workspace\\MYpractice"+"\\Reports\\"+testname+".png");
		FileUtils.copyFile(screenaShot, copyScreenShot);
		return "C:\\Eclipse-workspace\\MYpractice"+"\\Reports\\"+testname+".png";
	
	}
}
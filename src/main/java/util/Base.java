package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Base {

	public WebDriver driver = null;
	Properties prop = new Properties();
	public static Logger log=LogManager.getLogger(Base.class.getName());
		public WebDriver initializeDriver() {
		
		loadProperties();

		String browser =System.getProperty("browser");
		//if user does not provide from command line 
		if(browser==null) {
			browser="chrome";
		}
		String driverPath = prop.getProperty("driverPath");
		System.out.println("DriverPath ::"+driverPath);
		// initialize driver according to browser
		if (browser.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if(browser.contains("headless"))
				options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver(options);
			

		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"E:\\SoftwareTestingCode\\WebDriver\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					"E:\\SoftwareTestingCode\\WebDriver\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		// Setting implicit wait of 5 Seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}

	public String getUrl(String key) {

		loadProperties();
		return prop.getProperty(key);

	}

	public void loadProperties() {

		FileInputStream fis = null;
		log.info("Going to load properties");
		try {
			fis = new FileInputStream("data.properties");
			prop.load(fis);
			log.info("properties loaded..");
		} catch (FileNotFoundException e) {
			log.error("File not found exception");
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public String takeScreenShotPath(String testCaseName,WebDriver driver) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") + "\\reports\\" +testCaseName+".png";
		try {
			FileUtils.copyFile(src,new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
}

package com.crm.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\HP\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\Selenium-java\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Downloads\\Selenium-java\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_Load_Time_Out));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_Time_Out));

	}

}

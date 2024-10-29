package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseClass {
    public  static  WebDriver driver;
    public Logger logger;
    public Properties prop;

    @BeforeClass(groups = {"sanity", "Regression" , "WithDataProvider"})
    @Parameters({"os", "Browser"})
    void setup(String os, String br) throws IOException {
        // Loading Properties file
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
        prop = new Properties();
        prop.load(fis);

        logger = LogManager.getLogger(this.getClass());

        // Set capabilities based on environment
        if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities dc = new DesiredCapabilities();

            // OS specific setup
            if (os.equalsIgnoreCase("Windows")) {
                dc.setPlatform(Platform.WINDOWS);
            } else if (os.equalsIgnoreCase("Mac")) {
                dc.setPlatform(Platform.MAC);
            } else if (os.equalsIgnoreCase("Linux")) {
                dc.setPlatform(Platform.LINUX);
            } else {
                System.out.println("Please enter a valid OS.");
                return;
            }

            // Browser specific setup
            switch (br.toLowerCase()) {
                case "chrome":
                    dc.setBrowserName("chrome");
                    break;
                case "edge":
                    dc.setBrowserName("edge");
                    break;
                case "firefox":
                    dc.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Please enter a valid browser.");
                    return;
            }

            // Set the remote WebDriver URL and capabilities
            String huburl="http://192.168.29.251:4444";
            driver = new RemoteWebDriver(new URL(huburl), dc);

        } 
        if(prop.getProperty("execution_env").equalsIgnoreCase("local")){
        	
            // Local execution
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Please enter a valid browser.");
                    return;
            }
        }

        // Common WebDriver setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("appurl"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"sanity", "Regression" ,"WithDataProvider"})
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreenShot(String tmname) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
        Date dt = new Date();
        String timestamp = df.format(dt);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        String targetFilepath = System.getProperty("user.dir") + "\\screenshots\\" + tmname + "_" + timestamp + ".png";
        File targetFile = new File(targetFilepath);
        sourceFile.renameTo(targetFile);
        return targetFilepath;
    }
    public String  randomString() {
		String name = RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	public String randomPhoneno() {
		String phone = RandomStringUtils.randomNumeric(10);
		return phone;
	}
	
	public String randomPassword() {
		String password = RandomStringUtils.randomAlphanumeric(8);
		return password;
	}
}

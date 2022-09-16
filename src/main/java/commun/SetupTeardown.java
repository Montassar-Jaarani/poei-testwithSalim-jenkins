package main.java.commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class SetupTeardown {

    public WebDriver driver;
    //ChromeOptions options = new ChromeOptions();
   // FirefoxOptions optionss =new FirefoxOptions();
    //EdgeOptions options3 = new EdgeOptions();

    String browser ="chrome";
    @BeforeMethod
    public void setup() throws MalformedURLException {


        switch (browser){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                //options.addArguments("--headless");
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                //options.addArguments("--headless");
                driver = new FirefoxDriver();
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                //options.addArguments("--headless");
                driver = new EdgeDriver();
                break;
        }


        //WebDriverManager.edgedriver().setup();
        //WebDriverManager.firefoxdriver().setup();



        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
        //options.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        // optionss.setCapability(CapabilityType.BROWSER_NAME,"firefox");
        // options3.setCapability(CapabilityType.BROWSER_NAME,"microsoft edge");
        //driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.17:4444"),options); //pour passer les test avec selenium grid protégé avec mdp
        //driver = new RemoteWebDriver(new URL("http://192.168.121.17:4444"),optionss);
        //driver = new RemoteWebDriver(new URL("http://192.168.121.17:4444/"),options3);
        //driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
        driver.quit();

        ImportResultsToXray importResultsToXray =new ImportResultsToXray();

        if(result.getStatus() == ITestResult.SUCCESS)
        {
            System.out.println("passed **");
            importResultsToXray.generateJsonResults("PASSED");

        }
        else if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed **");
            importResultsToXray.generateJsonResults("Failed");

        }
        else if(result.getStatus() == ITestResult.SKIP ){

            System.out.println("Skiped**");
            importResultsToXray.generateJsonResults("Skiped");
        }
        importResultsToXray.RemonteResultats();
    }


}

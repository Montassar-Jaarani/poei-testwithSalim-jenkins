import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Tp1Test {

    WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }


    /*
    @Test
    public void test1() throws InterruptedException {
        System.out.println("Test Monta");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.4.0");
        driver.manage().window().maximize();
        sleep(5000);

        driver.quit();
    }
    @Test
    public void testAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("Playstation 5");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
    */
    /*
    //find elements using XPath
    @Test
    public void testAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
        WebElement cookies = driver.findElement(By.xpath("//input[@class='a-button-input celwidget']"));

        cookies.click();

        WebElement coque13 = driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        coque13.sendKeys("coque iphone 13");

        WebElement clickcoque13 = driver.findElement(By.xpath("//input[@value='Go']"));
        clickcoque13.click();

        WebElement firstcoque13 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        firstcoque13.click();

        WebElement ajoutcoque13 = driver.findElement(By.xpath("//input[@title='Ajouter au panier']"));
        ajoutcoque13.click();

        WebElement paniercoque13 = driver.findElement(By.xpath("(//span[@class='nav-line-2'])[2]"));
        paniercoque13.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
    */

    //find elements using CSS avec implicit wait  puis avec eplicit wait
    /*
    @Test
    public void testCss() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
        //final int IMPLICITTIMEOUT =10;
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITTIMEOUT));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement buttonCookie =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));




        //WebElement buttonCookie = driver.findElement(By.cssSelector("[data-cel-widget=sp-cc-accept]"));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();



        WebElement premierResultat = driver.findElement(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]"));
        premierResultat.click();





        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();




        WebElement panierButton = driver.findElement(By.cssSelector("#nav-cart"));
        panierButton.click();



        driver.quit();
    }
    */

    @Test
    public void testExplicitWait() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();

        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        premierResultat.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.id("nav-cart"));
        panierButton.click();


    }










}

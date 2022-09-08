import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TP3 {


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
    public void BestSeller() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement buttonToutes = driver.findElement(By.cssSelector(".hm-icon.nav-sprite"));
        buttonToutes.click();

        //WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        //loupeButton.click();

        WebElement meilleuresventes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='hmenu-item'][1]")));
        meilleuresventes.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-mini _p13n-zg-list-carousel-desktop_maskStyle_noop__3Xbw5'])[3]"));
        ajouterAuPanierButton.click();

        //WebElement panierButton = driver.findElement(By.id("nav-cart"));
        //panierButton.click();


    }


     */

    //tp3 en utilisant findelements pas juste findelement en selectant une liste à partir de cette liste on va choisir l'element dont on a besoin

    @Test
    public void BestSeller() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement buttonToutes = driver.findElement(By.cssSelector(".hm-icon.nav-sprite"));
        buttonToutes.click();

        //WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        //loupeButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));

        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(1).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ol.a-carousel>li.a-carousel-card")));

        List<WebElement> meilleuresventeslist = driver.findElements(By.cssSelector("ol.a-carousel>li.a-carousel-card"));
        meilleuresventeslist.get(2).click();

        //WebElement panierButton = driver.findElement(By.id("nav-cart"));
        //panierButton.click();


    }

    @Test
    public void testAsserts() {
        // Arrange
        final String expectedToutes = "Toutes";
        final String expectedMeilleuresVentes = "Meilleures ventes";
        final String expectedAmazonBasics = "Amazon Basics";
        final String expectedVentesLivres = "Meilleures ventes dans Livres";

        // Act
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
        WebElement barreRecherche = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        WebElement meilleuresVentes = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
        WebElement amazonBasics = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_amazonbasics]"));
        WebElement meilleuresVentesLivres = driver.findElement(By.cssSelector("[data-csa-c-slot-id=desktop-5] h2.as-title-block-left"));

        // Asserts
        Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
        Assert.assertTrue(barreRecherche.isDisplayed());
        Assert.assertEquals(toutesMenu.getText(), expectedToutes);

        Assert.assertTrue(meilleuresVentes.isDisplayed());
        Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

        Assert.assertTrue(amazonBasics.isDisplayed());
        Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

        Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
        Assert.assertEquals(meilleuresVentesLivres.getText(), expectedVentesLivres);
    }



}

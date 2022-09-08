import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class TP4_ASSERT_Select {


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





    @Test
    public void BestSeller() {

        // Arrange
        final String expectedIphone13ProMaxVA = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        final String expectedSousTotal2 = "Sous-total (2 articles)";
        final String expectedTaille256 = "Taille: 256Go";
        final String expectedVertAlpin = "Couleur: Vert alpin";
        final String expectedSansAppleCare = "configuration: Sans AppleCare+";



//////////////////////////////////////////////////////ACTTTTTTTTTTTTTTTTT//////////////////////////////////////////////////////////////////////////////
        //fermer cookies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        //chercher iphone 13 pro max vert Alpin
        WebElement Iphone13PM256VertA = driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        Iphone13PM256VertA.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        //lancer la recherche
        WebElement clickIphone13ProM256 = driver.findElement(By.xpath("//input[@value='Go']"));
        clickIphone13ProM256.click();

        //ouvrir premier resultat
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.a-section.a-spacing-base")));
        List<WebElement> listeIphone13 = driver.findElements(By.cssSelector("div.a-section.a-spacing-base"));
        listeIphone13.get(1).click();

        //selectioner sans applecare
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p.a-text-left.a-size-base")));
        //List<WebElement> buttonsansapplecare = driver.findElements(By.cssSelector("p.a-text-left.a-size-base"));
        //buttonsansapplecare.get(5).click();


        //Ajouter premier resultat au panier
        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("input#add-to-cart-button"));
        ajouterAuPanierButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Selectionner non merci pour l'apple care
        WebElement panierSansAppleCare = driver.findElement(By.cssSelector("#attachSiNoCoverage"));
        panierSansAppleCare.click();


        //ouvrir panier
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#attach-sidesheet-view-cart-button")));
        WebElement ouvrirPanier = driver.findElement(By.cssSelector("#attach-sidesheet-view-cart-button"));
        ouvrirPanier.click();


        //changer quantité à 2
        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByValue("2");

        //verification titre produit
        WebElement Iphone256Vert = driver.findElement(By.cssSelector("span.a-truncate-full.a-offscreen"));
        //verification sous total 2 articles
        WebElement SousTot2 = driver.findElement(By.cssSelector("#sc-subtotal-label-activecart"));
        //Verification taille 256go
        List<WebElement> taille256 = driver.findElements(By.cssSelector(".a-list-item"));
        taille256.get(9).getText();
        //Verification couleur Vert Alpin
        List<WebElement> VertAlpin = driver.findElements(By.cssSelector(".a-list-item"));
        VertAlpin.get(10).getText();
        //Verification sans apple care
        List<WebElement> SansAppleCare = driver.findElements(By.cssSelector(".a-list-item"));
        VertAlpin.get(11).getText();

        //////////////////////////////////////////////// Asserts/////////////////////////////////////////////////////////

        Assert.assertEquals(Iphone256Vert.getText(), expectedIphone13ProMaxVA);
        Assert.assertEquals(SousTot2.getText(), expectedSousTotal2);
        Assert.assertEquals(taille256.get(9).getText(), expectedTaille256);
        Assert.assertEquals(VertAlpin.get(10).getText(), expectedVertAlpin);
        Assert.assertEquals(SansAppleCare.get(11).getText(), expectedSansAppleCare);

    }

    @Test
    public void testAsserts() {
        // Arrange
        final String expectedToutes = "Toutes";
        final String expectedMeilleuresVentes = "Meilleures ventes";
        final String expectedAmazonBasics = "Amazon Basics";
        final String expectedVentesLivres = "Meilleures ventes dans Livres";

        // Act

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

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

    ////////////////////////////////////////////nesrine's code////////////////////////////////
    @Test
    public void testAmazon() {
        final String expectedTaille  = "256Go";
        final String expectedCouleur  = "Vert alpin";
        final String expectedConfiguration  = "Sans AppleCare+";
        final String expectedTotale  = "Sous-total (2 articles):";
        final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys(searchKeyword);

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();

        List<WebElement> resultatList = driver.findElements(By.cssSelector("img.s-image"));
        resultatList.get(0).click();

        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']")));
        ajouterAuPanierButton.click();

        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
        nonmerci.click();

        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attach-sidesheet-view-cart-button")));
        panierButton.click();

        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select quantiteDropdown = new Select(dropdown);
        quantiteDropdown.selectByIndex(2);

        List<WebElement> informations = driver.findElements(By.cssSelector(".a-text-bold + span"));
        WebElement taille = informations.get(0);
        WebElement couleur = informations.get(1);
        WebElement configuration = informations.get(2);
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));

        Assert.assertEquals(taille.getText(),expectedTaille,"Taille pas bon");
        Assert.assertEquals(couleur.getText(),expectedCouleur ,"couleur pas bon");
        Assert.assertEquals(configuration.getText(),expectedConfiguration ,"config pas bon");
        Assert.assertEquals(soustotale.getText(),expectedTotale,"sous total pa bon");
    }

}

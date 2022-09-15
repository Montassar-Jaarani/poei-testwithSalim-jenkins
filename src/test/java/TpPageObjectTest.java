package test.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.amazon.CartPage;
import main.java.amazon.HomePage;
import main.java.amazon.ProductPage;
import main.java.amazon.SearchResultPage;
import main.java.commun.SetupTeardown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TpPageObjectTest extends SetupTeardown {

    @Test
    public void testPO() {
        // Arrange/////////////////////
        String keywordHomePgae="Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        int indexSearchResult = 0;
        int indexSelectQuantity = 2;

        final String expectedTaille  = "256Go";
        final String expectedCouleur  = "Vert alpin";
        final String expectedConfiguration  = "Sans AppleCare+";
        final String expectedTotale  = "Sous-total (2 articles):";
        final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

        ///Act////////////////////////////
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.searchWithButton( keywordHomePgae);


        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openSearchResult(indexSearchResult);


        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.refuseAppleCare();
        productPage.openCart();

        CartPage cartPage =new CartPage(driver);
        cartPage.selectQuantity(indexSelectQuantity);


        cartPage.getFirstProductCapacity();
        cartPage.getFirstProductColor();
        cartPage.getFirstProductConfiguration();
        cartPage.getSubtotalCart();


        ///////////////////////////////ASSERT///////////////////////////

        Assert.assertEquals(cartPage.getFirstProductCapacity(),expectedTaille,"Taille pas bon");
        Assert.assertEquals(cartPage.getFirstProductColor(),expectedCouleur ,"couleur pas bon");
        //Assert.assertEquals(cartPage.getFirstProductConfiguration(),"config pas bon");
        //Assert.assertEquals(cartPage.getSubtotalCart(),expectedTotale,"sous total pa bon");

    }

   @Test
    public void testPOSurVol_hover()
    {
        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton);
        actions.perform();
    }


}

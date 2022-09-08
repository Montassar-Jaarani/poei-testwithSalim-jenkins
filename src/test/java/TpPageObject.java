import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

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
}

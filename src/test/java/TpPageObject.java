import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.searchWithButton( "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");


        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openSearchResult(0);


        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.refuseAppleCare();
        productPage.openCart();

    }
}

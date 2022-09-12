import carrefour.BestSellerPage;
import carrefour.HomePageCarrefour;
import carrefour.ProductPageCarre;
import carrefour.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefourTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }
    @Test
    public void testCarrefour(){
        ////////////////////////Arrange////////////////////



        ////////////////////Act///////////////////////////
        HomePageCarrefour homePageCarrefour = new HomePageCarrefour(driver);
        homePageCarrefour.acceptCookie();
        homePageCarrefour.maisonloisirsClick();

        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.openRayons();
        shoppingPage.openSportLoisirsMoburb();
        shoppingPage.openMeilleuresVentes();

        BestSellerPage bestSellerPage = new BestSellerPage(driver);
        bestSellerPage.voirButtonSportsLoisir();

        ProductPageCarre productPageCarre = new ProductPageCarre(driver);
        productPageCarre.getSubtotalCart();


    }
}

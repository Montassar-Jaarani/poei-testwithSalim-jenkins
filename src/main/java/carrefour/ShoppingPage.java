package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingPage {

    private WebDriver driver;
    private By openRayonsSelector = By.cssSelector(".mainbar__nav-toggle-icon");
    private By openSportLoisirMobSelector = By.xpath("(//span[@class='nav-item__content__name'])[14]");
    private By openMeilleuresVentesSelector = By.xpath("(//a[@data-testid='nav-item-link'])[13]");

    private final int TIMEOUT_COOKIE = 6;

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRayons() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement openRayons = wait.until(ExpectedConditions.visibilityOfElementLocated(openRayonsSelector));
        openRayons.click();
    }


    public void openSportLoisirsMoburb()
    {
        WebElement clickmotcleSL = driver.findElement(openSportLoisirMobSelector);

        Actions actions = new Actions(driver);
        actions.moveToElement(clickmotcleSL);
        actions.perform();
    }


    public void openMeilleuresVentes()
    {
        WebElement clickmotcleMV = driver.findElement(openMeilleuresVentesSelector);

        Actions actions = new Actions(driver);
        actions.moveToElement(clickmotcleMV);
        actions.perform();
    }

}

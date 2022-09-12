package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPageCarre {

    private WebDriver driver;
    private By getNameProductSelector = By.cssSelector(".ds-title.pdp-card__title.ds-title--light.ds-title--l");


    private final int TIMEOUT_COOKIE = 6;

    public ProductPageCarre(WebDriver driver) {
        this.driver = driver;
    }


    public String  getSubtotalCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(getNameProductSelector));
        return soustotale.getText();
    }
}

package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BestSellerPage {

    private WebDriver driver;
    private By voirButtonSelector = By.xpath("((//a[@class='ds-button ds-button--secondary show-options-cta'])[1]");

    private final int TIMEOUT_COOKIE = 6;

    public BestSellerPage(WebDriver driver) {
        this.driver = driver;
    }


    public void voirButtonSportsLoisir(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement voir = wait.until(ExpectedConditions.visibilityOfElementLocated(voirButtonSelector));
        voir.click();
    }

}

package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageCarrefour {

    private WebDriver driver;
    private By acceptCookieSelector = By.xpath("//button[@id='onetrust-reject-all-handler']");
    private By maisonloisirsSelector = By.xpath("//label[@for='header-tab-non-food']");
    private final int TIMEOUT_COOKIE = 6;

    public HomePageCarrefour(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }
    public void maisonloisirsClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement maisonloisirs = wait.until(ExpectedConditions.visibilityOfElementLocated(maisonloisirsSelector));
        maisonloisirs.click();
    }

}

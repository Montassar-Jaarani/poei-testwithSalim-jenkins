package amazon;

import java.time.Duration;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private By searchBarSelector = By.cssSelector("[aria-label=Rechercher]");
    private By loupeButtonSelector = By.cssSelector("[type=submit]");

    private final int TIMEOUT_COOKIE = 6;

    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {

        log.info("J'accepte les cookies");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }

    public void searchWithButton(String keyword){

        log.info("recherche avec boutton");
        WebElement searchBar = driver.findElement(searchBarSelector);
        searchBar.sendKeys(keyword);

        WebElement loupeButton = driver.findElement(loupeButtonSelector);
        loupeButton.click();
    }



}
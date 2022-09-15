package main.java.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {


    private WebDriver driver;
    private By addToCartSelector = By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");
    private By refuseAppleCareSelector = By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']");
    private By openCartSelector = By.cssSelector("#attach-sidesheet-view-cart-button");


    private final int TIMEOUT_COOKIE = 6;
    private static final Logger log = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {

        log.info("Ajouter à la carte");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelector));
        ajouterAuPanierButton.click();
    }

    public void refuseAppleCare(){

        log.info("refuser Apple Care");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(refuseAppleCareSelector));
        nonmerci.click();
    }

    public void openCart() {

        log.info("ouvrir panier");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(openCartSelector));
        panierButton.click();
    }

}

package main.java.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private By dropDownSelector = By.cssSelector("#quantity");
    private By firstProdColorSelector = By.cssSelector(".a-text-bold + span");
    private By firstProductCapSelector = By.cssSelector(".a-text-bold + span");
    private By firstProdConfigSelector = By.cssSelector(".a-text-bold + span");
    private By subTotalCartSelector = By.cssSelector("#sc-subtotal-label-activecart");


    private final int TIMEOUT_COOKIE = 6;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectQuantity(int quantity) {
        WebElement dropdown = driver.findElement(dropDownSelector);
        Select quantiteDropdown = new Select(dropdown);
        quantiteDropdown.selectByIndex(2);
    }

    public String getFirstProductCapacity(){
        List<WebElement> informations = driver.findElements(firstProductCapSelector);
        WebElement taille = informations.get(0);
        return taille.getText();
    }

    public String  getFirstProductColor() {
        List<WebElement> informations = driver.findElements(firstProdColorSelector);

        WebElement couleur = informations.get(1);
        return couleur.getText();
    }

    /**
     * une méthode qui retourne
     * @return
     */
    public String  getFirstProductConfiguration() {
        List<WebElement> informations = driver.findElements(firstProdConfigSelector);
        WebElement configuration = informations.get(2);
        return configuration.getText();
    }

    public String  getSubtotalCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(subTotalCartSelector));
        return soustotale.getText();
    }

}

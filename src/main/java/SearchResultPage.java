import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {


    private WebDriver driver;
    private By resultatProductSelector = By.cssSelector("img.s-image");
    private By searchBarSelector = By.cssSelector("[aria-label=Rechercher]");
    private By loupeButtonSelector = By.cssSelector("[type=submit]");

    private final int TIMEOUT_COOKIE = 6;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSearchResult(int index) {
        List<WebElement> resultatList = driver.findElements(resultatProductSelector);
        resultatList.get(0).click();
    }




}

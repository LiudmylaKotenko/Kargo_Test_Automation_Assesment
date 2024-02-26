package Shop_Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Shop_01 {
    @Test
    public void PriceFilterFunctionality() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/liudmylakotenko/Downloads/chromedriver-mac-x64/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the browser and navigate to the URL
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();

        // Click on the consent button
        WebElement consentButton = driver.findElement(By.cssSelector("p.fc-button-label"));
        consentButton.click();

        // Click on the Shop Menu
        WebElement shopMenu = driver.findElement(By.linkText("Shop"));
        shopMenu.click();

        // Locate the minPriceSlider and perform the drag and drop action
        WebElement minPriceSlider = driver.findElement(By.xpath("//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[1]"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(minPriceSlider, 0, 0).perform();

        // Locate the maxPriceSlider and perform the drag and drop action
        WebElement maxPriceSlider = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
        action.dragAndDropBy(maxPriceSlider, -28, 0).perform();

        //Click on Filter button
        WebElement button = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/button"));
        button.click() ;

        // Verify if the URL contains the specified price range
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("min_price=150&max_price=451")) {
            System.out.println("Price filter applied successfully.");
        } else {
            System.out.println("Price filter not applied.");
        }


        // Close the browser
        driver.quit();
    }
}

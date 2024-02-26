package Shop_Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shop_09 {
    @Test
    public void SaleProductFunctionality() {
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


        // Find the Sale product link based on the provided XPath
        WebElement saleProductLink = driver.findElement(By.xpath("//*[@id='content']/ul/li[1]/a[1]/span[1]"));

        // Click on the Sale product link
        saleProductLink.click();


        // Locate the old price element
        WebElement oldPriceElement = driver.findElement(By.cssSelector("p.price del span.amount"));

        // Locate the actual price element
        WebElement actualPriceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/span[2]/ins/span"));

        // Check if the actual price and old price are displayed
        boolean isActualPriceDisplayed = actualPriceElement.isDisplayed();
        boolean isOldPriceDisplayed = oldPriceElement.isDisplayed();



        // Close the browser
        driver.quit();
    }

}

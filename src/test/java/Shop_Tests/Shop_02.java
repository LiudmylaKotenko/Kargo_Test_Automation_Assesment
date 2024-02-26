package Shop_Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import static java.lang.System.setProperty;

public class Shop_02 {
    @Test
    public void ProductCathegoriesFunctionality() {
        // Set the path to the ChromeDriver executable
        setProperty("webdriver.chrome.driver", "/Users/liudmylakotenko/Downloads/chromedriver-mac-x64/chromedriver");

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

        // Click on the Android product category button
        WebElement androidButton = driver.findElement(By.xpath("//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", androidButton);

        // Refresh the page
        driver.navigate().refresh();

        // Check if the Android product is displayed
        WebElement androidProduct = driver.findElement(By.xpath("//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]/a"));
        if(androidProduct.isDisplayed()) {
            System.out.println("Android product is displayed.");
        } else {
            System.out.println("Android product is not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}

package Shop_Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shop_08 {
    @Test
    public void ReadMoreOptions() {
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

        // Click on the Home page button
        WebElement HomePageButton = driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", HomePageButton);

        // Find the Read more button by its name attribute
        WebElement ReadMorebutton = driver.findElement(By.name("Read more"));

        // Click on the Read more button
        ReadMorebutton.click();

        // Close the browser
        driver.quit();
    }

}

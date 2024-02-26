package Shop_Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Shop_05 {
    @Test
    public void SortingNewness() {
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

        // Locate the sorting dropdown and select "Sort by Newness ratings" by index
        WebElement sortingDropdown = driver.findElement(By.className("orderby"));
        Select select = new Select(sortingDropdown);
        select.selectByIndex(3);


        // Refresh the page to ensure the dropdown is still accessible
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }
}
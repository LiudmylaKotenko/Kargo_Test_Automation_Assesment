package Shop_Tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;


//import static org.junit.Assert.assertEquals;

public class Shop_12 {
    private static Object wait;

    @Test
    public void TaxesComparing() throws TimeoutException {
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

        // Click on the Add To Basket button
        WebElement addToBasketButton = driver.findElement(By.xpath("//a[contains(@class,'add_to_cart_button')]"));
        addToBasketButton.click();


        // Click on the view basket button
        WebElement viewBasketButton = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[3]"));
        viewBasketButton.click();

        // Verify subtotal and total values
        driver.navigate().refresh();
        WebElement subtotalValue = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span"));
        WebElement finalTotalPrice = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span"));
        Assert.assertTrue(subtotalValue.isDisplayed() && finalTotalPrice.isDisplayed());

        // Verify total is greater than subtotal
        double subtotal = Double.parseDouble(subtotalValue.getText().substring(1));
        double totalPrice = Double.parseDouble(finalTotalPrice.getText().substring(1));
        Assert.assertTrue(totalPrice > subtotal);

        //Click on Proceed to Check out button
        WebElement ProceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a"));
        ProceedToCheckoutButton.click();

        // Verify tax rate for India
        WebElement SubTotalElement = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span"));
        WebElement taxForIndiaElement = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[2]/td/span"));
        WebElement totalPriceForIndiaElement = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[3]/td/strong/span"));


        // Get the text from the SubTotalElement, taxForIndiaElement, and totalPriceForIndiaElement
        String subTotalText = SubTotalElement.getText().replaceAll("[^\\d.]", "");
        String taxForIndiaText = taxForIndiaElement.getText().replaceAll("[^\\d.]", "");
        String totalPriceForIndiaText = totalPriceForIndiaElement.getText().replaceAll("[^\\d.]", "");

        // Convert the text into numerical values
        double subTotalValue = Double.parseDouble(subTotalText);
        double taxForIndiaValue = Double.parseDouble(taxForIndiaText);
        double totalPriceForIndiaValue = Double.parseDouble(totalPriceForIndiaText);

        // Calculate the total price for India
        double calculatedTotalPriceForIndia = subTotalValue + taxForIndiaValue;

        // Print the calculated and extracted total prices for India
        System.out.println("Calculated Total Price for India: " + calculatedTotalPriceForIndia);
        System.out.println("Extracted Total Price for India: " + totalPriceForIndiaValue);

        // Compare the calculated total price with the value extracted from totalPriceForIndiaElement
        if (Math.abs(calculatedTotalPriceForIndia - totalPriceForIndiaValue) < 0.01) {
            System.out.println("Total price for India calculation is correct.");
        } else {
            System.out.println("Total price for India calculation is incorrect.");
        }

        // Calculate 2% of totalPriceForIndiaElement
        double expectedTaxForIndia = 0.02 * totalPriceForIndiaValue;

        // Print the calculated and expected tax for India
        System.out.println("Calculated Tax for India: " + taxForIndiaValue);
        System.out.println("Expected Tax for India (2% of Total Price): " + expectedTaxForIndia);

        // Compare the calculated tax with the expected tax
        if (Math.abs(taxForIndiaValue - expectedTaxForIndia) < 0.01) {
            System.out.println("Tax for India calculation is correct.");
        } else {
            System.out.println("Tax for India calculation is incorrect.");
        }


        // Verify tax rate for Other Country

        // Locate the Country dropdown and select Algeria
        // Locate the dropdown element using id
        WebElement CountryDropdown = driver.findElement(By.id("s2id_billing_country"));

        // Click on the dropdown to open the options
        CountryDropdown.click();

        WebElement name = driver.findElement(By.id("s2id_autogen1_search"));
        name.click();
        name.sendKeys("Algeria");
        name.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement SubTotal2Element = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span"));
        WebElement RoamingTaxElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/form[3]/div[2]/table/tfoot/tr[2]/td/span"));
        WebElement totalPriceForAlgeriaElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/form[3]/div[2]/table/tfoot/tr[3]/td/strong/span"));

        // Wait for the text "₹22.50" to be present in the RoamingTaxElement

        wait.until(ExpectedConditions.textToBePresentInElementValue(RoamingTaxElement, "22.50"));


        // Get the text from the elements
        String subTotal2Text = SubTotal2Element.getText().replaceAll("[^\\d.]", "");
        String roamingTaxText = RoamingTaxElement.getText().replaceAll("[^\\d.]", "");
        String totalPriceForAlgeriaText = totalPriceForAlgeriaElement.getText().replaceAll("[^\\d.]", "");

        // Convert the text into numerical values
        double subTotal2Value = Double.parseDouble(subTotal2Text);
        double roamingTaxValue = Double.parseDouble(roamingTaxText);
        double totalPriceForAlgeriaValue = Double.parseDouble(totalPriceForAlgeriaText);

        // Calculate the sum of SubTotal2Element and RoamingtaxElement
        double calculatedTotalPriceForAlgeria = subTotal2Value + roamingTaxValue;

        // Print the calculated and extracted total prices for Algeria
        System.out.println("Calculated Total Price for Algeria: " + calculatedTotalPriceForAlgeria);
        System.out.println("Extracted Total Price for Algeria: " + totalPriceForAlgeriaValue);

        // Compare the calculated total price with the value extracted from totalPriceForAlgeriaElement
        if (Math.abs(calculatedTotalPriceForAlgeria - totalPriceForAlgeriaValue) < 0.01) {
            System.out.println("Total price for Algeria calculation is correct.");
        } else {
            System.out.println("Total price for Algeria calculation is incorrect.");
        }

        // Calculate 5% of totalPriceForAlgeriaElement
        double expectedRoamingTax = 0.05 * totalPriceForAlgeriaValue;

        // Print the calculated and expected tax for Algeria
        System.out.println("Calculated Roaming Tax for Algeria: " + roamingTaxValue);
        System.out.println("Expected Roaming Tax for Algeria (5% of Total Price): " + expectedRoamingTax);

        // Compare the calculated tax with the expected tax
        if (Math.abs(roamingTaxValue - expectedRoamingTax) < 0.01) {
            System.out.println("Roaming Tax for Algeria calculation is correct.");
        } else {
            System.out.println("Roaming Tax for Algeria calculation is incorrect.");
        }

// Close the browser
        driver.quit();

    }
}
package Shop_Tests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shop_11 {
    @Test


    public void OrderConfirmation() {
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

        // 4) Click on the Add To Basket button
        WebElement addToBasketButton = driver.findElement(By.xpath("//a[contains(@class,'add_to_cart_button')]"));
        addToBasketButton.click();


        // View that Book in the Menu item with price
        // Locate the item text element
        WebElement itemText = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[1]"));

        // Locate the price text element
        WebElement priceText = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[2]"));

        // Get the text of the elements
        String actualItemText = itemText.getText();
        String actualPriceText = priceText.getText();

        // Assertion for item text
        Assert.assertEquals("1 Item", actualItemText);


        // Assertion for price text (This part depends on webapp settings, there is different sign now)
        Assert.assertEquals("₹450.00", actualPriceText);


        // Click on the view basket button
        WebElement viewBasketButton = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[1]"));
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

        // Click on Proceed to Check out button
        WebElement ProceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a"));
        ProceedToCheckoutButton.click();

        // View Billing Details,Order Details,Additional details and Payment gateway details

        //View Billing Details
        WebElement FirstNameField = driver.findElement(By.xpath("//*[@id=\"billing_first_name_field\"]"));
        WebElement LastNameField = driver.findElement(By.xpath("//*[@id=\"billing_last_name_field\"]"));
        WebElement CompanyNameField = driver.findElement(By.xpath("//*[@id=\"billing_company_field\"]"));
        WebElement EmailAddressField = driver.findElement(By.xpath("//*[@id=\"billing_email_field\"]"));
        WebElement PhoneField = driver.findElement(By.xpath("//*[@id=\"billing_phone_field\"]"));
        WebElement CountryField = driver.findElement(By.xpath("//*[@id=\"billing_country_field\"]"));
        WebElement AddressField = driver.findElement(By.xpath("//*[@id=\"billing_address_1_field\"]"));
        WebElement TownCityField = driver.findElement(By.xpath("//*[@id=\"billing_city_field\"]"));
        WebElement StateCountryField = driver.findElement(By.xpath("//*[@id=\"billing_state_field\"]"));
        WebElement PostcodeField = driver.findElement(By.xpath("//*[@id=\"billing_postcode_field\"]"));
        WebElement CreateAccountField = driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div/p[12]"));

        //View Order Details
        WebElement YourOrderField = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table"));

        //Additional details
        WebElement AdditionalInformationField = driver.findElement(By.xpath("//*[@id=\"order_comments_field\"]"));

        //Payment gateway details
        WebElement PaymentGatewayField = driver.findElement(By.xpath("//*[@id=\"payment\"]"));

        // Filling  billing details form and opt in
        WebElement name = driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]"));
        name.click();
        name.sendKeys("Liuda");

        WebElement Lastname = driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]"));
        Lastname.click();
        Lastname.sendKeys("Kotenko");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"billing_email\"]"));
        email.click();
        email.sendKeys("liudmyla.kotenko.qa@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//*[@id=\"billing_phone\"]"));
        phone.click();
        phone.sendKeys("099 29 870938");

        WebElement addressStreet = driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]"));
        addressStreet.click();
        addressStreet.sendKeys("Byepass Chouraha Jhilai, Road Niwai");

        WebElement city = driver.findElement(By.xpath("//*[@id=\"billing_city\"]"));
        city.click();
        city.sendKeys("Niwai");

        WebElement zip = driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]"));
        zip.click();
        zip.sendKeys("304021");

        WebElement cash = driver.findElement(By.xpath("//*[@id=\"payment_method_cod\"]"));
        cash.click();

        // Click on Place Order button to complete process
        WebElement PlaceOrder = driver.findElement(By.xpath("//*[@id=\"place_order\"]"));
        PlaceOrder.click();


        // Close the browser
        driver.quit();

    }
}


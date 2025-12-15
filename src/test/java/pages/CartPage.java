package pages;

import framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class CartPage {

    private final WebDriver driver;
    private final Waits waits;

    private final By cartContents = By.id("cart_contents_container");
    private final By cartItemNames = By.cssSelector(".cart_item .inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public boolean isLoaded() {
        waits.visible(cartContents);
        return true;
    }

    public boolean containsItem(String itemName) {
        return driver.findElements(cartItemNames).stream()
                .anyMatch(e -> e.getText().trim().equalsIgnoreCase(itemName));
    }
}

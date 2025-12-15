package pages;

import framework.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class InventoryPage {

    private final WebDriver driver;
    private final Waits waits;

    private final By inventoryContainer = By.id("inventory_container");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public boolean isLoaded() {
        waits.visible(inventoryContainer);
        return true;
    }

    public void addBackpackToCart() {
        waits.click(addBackpackButton);
    }

    public String getCartCount() {
        return waits.visible(cartBadge).getText();
    }

    public void goToCart() {
        waits.click(cartLink);
        waits.urlContains(driver, "cart");
    }
}

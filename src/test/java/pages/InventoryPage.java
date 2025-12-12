package pages;

import framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class InventoryPage {

    private final WebDriver driver;
    private final Waits waits;

    // Elemento "ancla" de la página
    private final By inventoryContainer = By.id("inventory_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public boolean isLoaded() {
        return waits.urlContains(driver, "inventory")
                && driver.findElements(inventoryContainer).size() == 1;
    }
}

package pages;

import framework.Waits;
import org.openqa.selenium.WebDriver;

public final class InventoryPage {

    private final WebDriver driver;
    private final Waits waits;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public boolean isLoaded() {
        return waits.urlContains(driver, "inventory");
    }
}

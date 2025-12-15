package tests;

import framework.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public final class CartTests extends BaseTest {

    @Test
    void addItemToCart_shouldAppearInCart() {
        LoginPage login = new LoginPage(driver).open(config.getProperty("baseUrl"));
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        Assertions.assertTrue(inventory.isLoaded(), "Inventory page should be loaded before adding items");

        inventory.addBackpackToCart();
        Assertions.assertEquals("1", inventory.getCartCount(), "Cart badge should show 1 item");

        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        Assertions.assertTrue(cart.isLoaded(), "Cart page should be loaded");
        Assertions.assertTrue(cart.containsItem("Sauce Labs Backpack"),
                "Cart should contain 'Sauce Labs Backpack'");
    }
}

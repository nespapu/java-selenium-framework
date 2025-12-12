package tests;

import framework.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.LoginPage;

public final class LoginTests extends BaseTest {

    @Test
    void validLogin_shouldReachInventory() {
        LoginPage login = new LoginPage(driver).open(config.getProperty("baseUrl"));
        login.login("standard_user", "secret_sauce");
    }

    @Test
    void invalidLogin_shouldShowError() {
        LoginPage login = new LoginPage(driver).open(config.getProperty("baseUrl"));
        login.login("standard_user", "wrong_password");

        String error = login.getError();
        Assertions.assertTrue(error.toLowerCase().contains("username and password"),
                "Error message should mention username/password mismatch. Actual: " + error);
    }
}

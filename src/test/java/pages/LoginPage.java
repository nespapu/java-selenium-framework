package pages;

import framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage {
    private final WebDriver driver;
    private final Waits waits;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorBox = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        waits.visible(username);
        return this;
    }

    public void login(String user, String pass) {
        waits.visible(username).sendKeys(user);
        waits.visible(password).sendKeys(pass);
        waits.click(loginBtn);
    }

    public String getError() {
        return waits.visible(errorBox).getText();
    }
}

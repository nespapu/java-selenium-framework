package framework;

import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Properties config;

    @BeforeEach
    void setUp() throws Exception {
        config = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new IllegalStateException("config.properties not found in src/test/resources");
            }
            config.load(is);
        }

        boolean headless = Boolean.parseBoolean(config.getProperty("headless", "true"));
        String browser = config.getProperty("browser", "chrome");

        if (!browser.equalsIgnoreCase("chrome")) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver = DriverFactory.createChrome(headless);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

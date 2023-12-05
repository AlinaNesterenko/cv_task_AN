import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
  @BeforeAll
  static void setUp() {

    // Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = System.getProperty("baseUrl", "https://www.priorbank.by/");
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserVersion = System.getProperty("version", "100");
    Configuration.browserSize = System.getProperty("size", "1920X1280");
    Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");


    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
    Configuration.browserCapabilities = capabilities;

  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last state");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();

    closeWebDriver();
  }
}

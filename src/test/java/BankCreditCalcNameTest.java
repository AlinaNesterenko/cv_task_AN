import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import pages.CalcPage;

import static io.qameta.allure.Allure.step;

public class BankCreditCalcNameTest extends TestBase {


  CalcPage calcPage = new CalcPage();
  TestData testData = new TestData();

  @Test
  @Tag("bankTest")
  @DisplayName("Credit calculator name")
  void openFormTest() {

    step("Открывыем страницу калькулятора", () -> {
      calcPage.openPage();
    });
    step("Проверяем что заголовок Расчитай... ", () -> {
      calcPage.verifyTitle(testData.titleText);
    });

  }
}

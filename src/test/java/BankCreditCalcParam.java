import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import pages.CalcPage;

import static io.qameta.allure.Allure.step;

public class BankCreditCalcParam extends TestBase {


  CalcPage calcPage = new CalcPage();
  TestData testData = new TestData();

  @CsvFileSource(resources = "/paramForCalc.csv")
  @ParameterizedTest
  @Tag("bankTest")
  void openFormTest(String typeCr, String typeCalc, String crSum, String crPayment) {

    step("Открывыем страницу калькулятора", () -> {
      calcPage.openPage();
    });
    step("Проверяем что заголовок Расчитай... ", () -> {
      calcPage.verifyTitle(testData.titleText);
    });
    step("Выбираем тип кредита", () -> {
      calcPage.setCreditType(typeCr);
    });
    step("Выбираем тип расчета кредита", () -> {
      calcPage.setLoanType(typeCalc);
    });
    step("Устанавливаем ежемесячный доход или сумму", () -> {
      switch (testData.userLoanType) {
        case ("от суммы кредита    "):
          calcPage.setSum(testData.income);
        case ("от размера дохода"):
          calcPage.setIncome(testData.income);
      }
    });
    step("Устанавливаем срок кредита", () -> {
      calcPage.setTerm(testData.term);
    });
    step("Нажимаем кнопку Расчитать", () -> {
      calcPage.submitAction();
    });
    step("Проверяем сумму кредита", () -> {
              calcPage.verifyLoanSum(crSum);

    });

    step("Проверяем платеж по кредиту", () -> {
              calcPage.verifyLoanPayment(crPayment);
    });

  }
}

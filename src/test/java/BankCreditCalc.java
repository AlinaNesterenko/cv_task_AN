import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import pages.CalcPage;

import static io.qameta.allure.Allure.step;

public class BankCreditCalc extends TestBase {


  CalcPage calcPage = new CalcPage();
  TestData testData = new TestData();

  @Test
  @Tag("bankTest")
  @DisplayName("Credit calculator")
  void openFormTest() {

    step("Открывыем страницу калькулятора", () -> {
      calcPage.openPage();
      calcPage.waitPage();
    });
    step("Проверяем что заголовок Расчитай... ", () -> {
      calcPage.verifyTitle(testData.titleText);
    });
    step("Выбираем тип кредита", () -> {
      calcPage.setCreditType(testData.userCrType);
    });
    step("Выбираем тип расчета кредита", () -> {
      calcPage.setLoanType(testData.userLoanType);
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
      calcPage.waitPage();
    });
    step("Проверяем сумму кредита", () -> {
      switch (testData.userLoanType) {
        case ("от суммы кредита    "):

          switch (testData.userCrType) {
            case ("Возобновляемая кредитная карточка"):
              calcPage.verifyLoanSum(testData.resultArray[0]);
            case ("Потребительский кредит на карточку"):
              calcPage.verifyLoanSum(testData.resultArray[0]);
            case ("ПростоАвто"):
              calcPage.verifyLoanSum(testData.resultArray[0]);

          }
        case ("от размера дохода"):
        case ("Возобновляемая кредитная карточка"):
          calcPage.verifyLoanSum(testData.resultArray[2]);
        case ("Потребительский кредит на карточку"):
          calcPage.verifyLoanSum(testData.resultArray[5]);
        case ("ПростоАвто"):
          calcPage.verifyLoanSum(testData.resultArray[8]);
      }
    });

    step("Проверяем платеж по кредиту", () -> {
      switch (testData.userLoanType) {
        case ("от суммы кредита    "):

          switch (testData.userCrType) {
            case ("Возобновляемая кредитная карточка"):
              calcPage.verifyLoanPayment(testData.resultArray[1]);
            case ("Потребительский кредит на карточку"):
              calcPage.verifyLoanPayment(testData.resultArray[4]);
            case ("ПростоАвто"):
              calcPage.verifyLoanPayment(testData.resultArray[7]);

          }
        case ("от размера дохода"):
        case ("Возобновляемая кредитная карточка"):
          calcPage.verifyLoanPayment(testData.resultArray[3]);
        case ("Потребительский кредит на карточку"):
          calcPage.verifyLoanPayment(testData.resultArray[6]);
        case ("ПростоАвто"):
          calcPage.verifyLoanPayment(testData.resultArray[6]);
      }
    });
    step("Закрываем страницу", () -> {
      calcPage.closePage();
    });
  }
}

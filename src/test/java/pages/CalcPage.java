package pages;

import org.w3c.dom.html.HTMLInputElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class CalcPage {
  //create objects
  SelenideElement titleText = $(".sm-calculate__title"),

      creditType = $("[id='MB_CREDIT_TYPE']"),

      loanType = $(".sm-calculate__radio-wrapper"),
      loanRangeSum = $("[id='LOAN_RANGE_OUTPUT']"),
      loanRangeIncome = $("[id='LOAN_SAL_RANGE_OUTPUT']"),
      creditTerm = $("[id='CREDIT_TERM']"),

      loanSum = $(".sm-calculate__value-result"),

      loanPayment = $(".sm-calculate__value-result"),

      submitButton = $(".sm-calculate__button");


  //Open page
  public CalcPage openPage() {
    open("калькулятор");

    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }


  // create methods for test
  public CalcPage setCreditType(String value) {
    creditType.click();
    creditType.$(byText(value)).click();
    return this;
  }

  public CalcPage setLoanType(String value) {
    //  loanType.click();
    loanType.$(withText(value)).click();
    return this;
  }

  public CalcPage setIncome(String value) {
    loanRangeIncome.clear();
    loanRangeIncome.setValue(value);
    return this;
  }

  public CalcPage setSum(String value) {
    loanRangeSum.clear();
    loanRangeSum.setValue(value);
    return this;
  }

  public CalcPage setTerm(String value) {
    creditTerm.click();
    creditTerm.$(byText(value)).click();

    return this;
  }

  public CalcPage verifyTitle(String value) {

    titleText.equals(value);
    return this;
  }

  public CalcPage verifyLoanSum(String value) {

    loanSum.equals(value);
    return this;
  }

  public CalcPage verifyLoanPayment(String value) {

    loanPayment.equals(value);
    return this;
  }

  public CalcPage submitAction() {

    submitButton.click();
    return this;
  }


}

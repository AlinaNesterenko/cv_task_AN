import java.util.Locale;

import com.github.javafaker.Faker;


public class TestData {
  Faker faker = new Faker(new Locale("en-GB"));
  String[] crTypes = {"Возобновляемая кредитная карточка", "Потребительский кредит на карточку", "ПростоАвто"};
  String userCrType = faker.options().option(crTypes);
  String[] loanTypes = {"от суммы кредита", "от размера дохода"};
  String userLoanType = faker.options().option(loanTypes);
  String income = "1000";

  String term = "24";

  String titleText = "Рассчитайте ваш кредит";

  String[] resultArray = new String[] {"1000,00", "36,50", "6000,00", "219,00", "48,39", "10352,65", "500,00", "50,80", "9842,88"};

}

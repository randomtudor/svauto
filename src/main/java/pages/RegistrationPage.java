package pages;

import helpers.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.*;

public class RegistrationPage extends BasePage {
  private static final String URL =
      "http://automationpractice.com/index.php?controller=authentication";

  @FindBy(css = "h1.page-heading")
  private WebElement registrationPageHeading;

  @FindBy(id = "account-creation_form")
  private WebElement accountCreationForm;

  @FindBy(id = "id_gender1")
  private WebElement mrGenderField;

  @FindBy(id = "id_gender2")
  private WebElement mrsGenderField;

  @FindBy(id = "customer_firstname")
  private WebElement firstNameField;

  @FindBy(id = "customer_lastname")
  private WebElement lastNameField;

  @FindBy(id = "email")
  private WebElement email;

  @FindBy(id = "passwd")
  private WebElement password;

  @FindBy(id = "days")
  private WebElement day;

  @FindBy(id = "months")
  private WebElement month;

  @FindBy(id = "years")
  private WebElement year;

  @FindBy(id = "firstname")
  private WebElement firstNameAdress;

  @FindBy(id = "lastname")
  private WebElement lastNameAdress;

  @FindBy(id = "address1")
  private WebElement adress;

  @FindBy(id = "city")
  private WebElement city;

  @FindBy(id = "id_state")
  private WebElement state;

  @FindBy(id = "postcode")
  private WebElement postalcode;

  @FindBy(id = "id_country")
  private WebElement country;

  @FindBy(id = "phone_mobile")
  private WebElement mobilePhone;

  @FindBy(id = "alias")
  private WebElement alias;

  @FindBy(id = "submitAccount")
  private WebElement createAccountButton;

  public RegistrationPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.accountCreationForm);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.accountCreationForm, this.createAccountButton);
  }

  public void fillAccountData(final AccountData accountData) {
    final String firstName = accountData.getFirstName();
    final String lastName = accountData.getLastName();

    selectRadioField(this.mrGenderField);
    setFieldValue(this.firstNameField, firstName);
    setFieldValue(this.lastNameField, lastName);
    setFieldValue(this.password, accountData.getPassword());
    selectFieldValue(this.day, accountData.getDayOfBirth());
    selectFieldValue(this.month, accountData.getMonthOfBirth());
    selectFieldValue(this.year, accountData.getYearOfBirth());
    setFieldValue(this.firstNameAdress, firstName);
    setFieldValue(this.lastNameAdress, lastName);
    setFieldValue(this.adress, accountData.getAdress());
    setFieldValue(this.city, accountData.getCity());
    selectFieldValue(this.state, accountData.getState());
    setFieldValue(this.postalcode, accountData.getPostcode());
    selectFieldValue(this.country, "21");
    setFieldValue(this.mobilePhone, accountData.getMobilePhone());
    setFieldValue(this.alias, accountData.getAlias());
    this.createAccountButton.click();
  }

  public void accountRegistrationWithEmptyValues() {
    this.createAccountButton.click();
  }

  public String getPageHeadingText() {
    return this.registrationPageHeading.getText();
  }

  public void open() {
    openUrl(URL);
  }
}

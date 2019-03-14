package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class LoginPage extends BasePage {
  private static final String URL =
      "http://automationpractice.com/index.php?controller=authentication";

  @FindBy(id = "email")
  private WebElement emailField;

  @FindBy(id = "passwd")
  private WebElement passField;

  @FindBy(id = "SubmitLogin")
  private WebElement logInButton;

  @FindBy(id = "email_create")
  private WebElement createAccountEmail;

  @FindBy(id = "SubmitCreate")
  private WebElement createAccountButton;

  public LoginPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.emailField);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.emailField, this.passField, this.logInButton);
  }

  public void login(final String email, final String password) {
    fillInEmail(email);
    fillInPassword(password);
    this.logInButton.click();
  }

  public void newAccountRegistration(final String email) {
    setFieldValue(this.createAccountEmail, email);
    clickAccountButton();
  }

  public void clickAccountButton() {
    this.createAccountButton.click();
  }

  private void fillInEmail(final String email) {
    setFieldValue(this.emailField, email);
  }

  private void fillInPassword(final String password) {
    setFieldValue(this.passField, password);
  }

  public void open() {
    openUrl(URL);
  }
}

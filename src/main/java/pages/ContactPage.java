package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static helpers.WebElementHelper.*;

public class ContactPage extends BasePage {
  private static final String URL =
          "http://automationpractice.com/index.php?controller=contact";

  @FindBy (css = "h1.page-heading.bottom-indent")
  private WebElement pageHeading;

  @FindBy (css = "select#id_contact.form-control")
  private WebElement subjectHeading;

  @FindBy (id = "email")
  private WebElement email;

  @FindBy (id = "message")
  private WebElement message;

  @FindBy (id = "submitMessage")
  private WebElement submitMessageButton;

  @FindBy (css = "div#center_column p.alert.alert-success")
  private WebElement alertSuccessMessage;

  public ContactPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.pageHeading);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.pageHeading);
  }

  public void fillMessageData() {
    selectFieldValue(this.subjectHeading, "2");
    setFieldValue(this.email, "pampam@email.com");
    setFieldValue(this.message, "no issue, just testing the form.");
    this.submitMessageButton.click();
  }

  public String alertSuccesText() {
    return this.alertSuccessMessage.getText();
  }

  public void open() {
    openUrl(URL);
  }
}

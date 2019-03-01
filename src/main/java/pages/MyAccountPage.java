package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.logOut;

public class MyAccountPage extends BasePage {

  @FindBy(className = "info-account")
  private WebElement accountContainer;

  @FindBy(css = "a[href*='history']")
  private WebElement orderHistoryAdnDetailsButton;

  @FindBy(css = "a[href*='order-slip']")
  private WebElement myCreditSlipsButton;

  @FindBy(css = "a[href*='addresses']")
  private WebElement myAddressesButton;

  @FindBy(css = "a[href*='identity']")
  private WebElement myPersonalInformationButton;

  @FindBy(css = "a[href*='mywishlist']")
  private WebElement myWishlistButton;

  @FindBy(css = "h1.page-heading")
  private WebElement myAccountPageHeading;

  @FindBy(css = "a.logout")
  private WebElement logOutButton;

  public MyAccountPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.accountContainer);
  }

  @Override
  protected boolean isValid() {
    return areVisible(
        this.orderHistoryAdnDetailsButton,
        this.myCreditSlipsButton,
        this.myAddressesButton,
        this.myPersonalInformationButton,
        this.myWishlistButton);
  }

  public String getPageHeadingText() {
    return this.myAccountPageHeading.getText();
  }

  public void myAccountLogOut() {
    logOut(this.logOutButton);
  }
}

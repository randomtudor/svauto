package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class ShoppingCartSummaryPage extends BasePage {
  private static final String URL = "http://automationpractice.com/index.php?controller=order";

  @FindBy(css = "div#center_column")
  private WebElement shoppingCartContainer;

  @FindBy(css = "div.shopping_cart")
  private WebElement shoppingCart;

  @FindBy(css = "a.bankwire")
  private WebElement payByBankWire;

  @FindBy(css = "h1.page-heading")
  private WebElement pageHeading;

  @FindBy(css = "p.cart_navigation.clearfix button.button-medium")
  private WebElement proceedToCheckout;

  @FindBy(css = "a.standard-checkout")
  private WebElement proceedToCheckoutAtSummary;

  @FindBy(css = "input#cgv")
  private WebElement agreeTermsOfService;

  public ShoppingCartSummaryPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.shoppingCartContainer);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.shoppingCart);
  }

  public void clickProceedToCheckoutAtSummary() {
    this.proceedToCheckoutAtSummary.click();
  }

  public void clickProceedToCheckout() {
    this.proceedToCheckout.click();
  }

  public void clickAgreeTermsOfService() {
    this.agreeTermsOfService.click();
  }

  public void clickPayByBankWire() {
    this.payByBankWire.click();
  }

  public String getPageHeadingText() {
    return this.pageHeading.getText();
  }

  public void open() {
    openUrl(URL);
  }
}

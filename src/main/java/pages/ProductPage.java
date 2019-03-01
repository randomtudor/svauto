package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.WebElementHelper.areVisible;

public class ProductPage extends BasePage {

  private static final String URL =
      "http://automationpractice.com/index.php?id_category=5&controller=category";

  @FindBy(css = "h1.page-heading.product-listing")
  private WebElement productPageHeading;

  @FindBy(css = "div.product-container")
  private WebElement productPageContainer;

  @FindBy(css = "a.button.ajax_add_to_cart_button")
  private WebElement addToCartButton;

  @FindBy(css = "div.button-container span.continue")
  private WebElement continueShoppingButton;

  @FindBy(css = "a[title='Proceed to checkout']")
  private WebElement proceedToCheckoutButton;

  public ProductPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.productPageHeading);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.productPageContainer);
  }

  public void clickAddToCartButton() {
    hoverElement(this.productPageContainer);
    waitFor(ExpectedConditions.visibilityOf(this.addToCartButton), 10);
    this.addToCartButton.click();
  }

  public void clickContinueShopping() {
    waitFor(ExpectedConditions.visibilityOf(this.continueShoppingButton), 10);
    this.continueShoppingButton.click();
  }

  public void clickProceedToCheckout() {
    waitFor(ExpectedConditions.visibilityOf(this.proceedToCheckoutButton), 10);
    this.proceedToCheckoutButton.click();
  }

  public void open() {
    openUrl(URL);
  }
}

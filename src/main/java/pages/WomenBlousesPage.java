package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.WebElementHelper.areVisible;

public class WomenBlousesPage extends BasePage {
  private static final String URL =
      "http://automationpractice.com/index.php?id_category=7&controller=category";

  @FindBy(css = "h1.page-heading.product-listing")
  private WebElement womenTShirtsPageHeading;

  @FindBy(css = "div.product-container")
  private WebElement womenTShirtsProductContainer;

  @FindBy(css = "a.button.ajax_add_to_cart_button")
  private WebElement womenTShirtAddToCartButton;

  @FindBy(css = "div.button-container span.continue")
  private WebElement continueShoppingButton;

  @FindBy(css = "a[title='Proceed to checkout']")
  private WebElement proceedToCheckoutButton;

  public WomenBlousesPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.womenTShirtsPageHeading);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.womenTShirtsProductContainer);
  }

  public void clickAddToCartButton() {
    hoverElement(this.womenTShirtsProductContainer);
    waitFor(ExpectedConditions.visibilityOf(this.womenTShirtAddToCartButton), 10);
    this.womenTShirtAddToCartButton.click();
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

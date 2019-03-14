package pages;

import helpers.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import static helpers.WebElementHelper.areVisible;

public class ProductPage extends BasePage {

  private static final String URL =
      "http://automationpractice.com/index.php?id_category=5&controller=category";

  private BigDecimal computedTotal = new BigDecimal("2");
  private int computedCartNumberOfProducts;

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

  @FindBy(css = "div.shopping_cart a span")
  private WebElement cartNumberOfProducts;

  @FindBy(css = "span.price.product-price")
  private WebElement productPrice;

  // WOMEN DRESSES
  @FindBy(css = "#layered_category_9")
  private WebElement casualDresses;

  @FindBy(css = "#layered_category_10")
  private WebElement eveningDresses;

  @FindBy(css = "#layered_category_11")
  private WebElement summerDresses;

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
    this.computedTotal();
    computedCartNumberOfProducts += 1;
  }

  public void clickContinueShopping() {
    waitFor(ExpectedConditions.visibilityOf(this.continueShoppingButton), 10);
    this.continueShoppingButton.click();
  }

  public void clickProceedToCheckout() {
    waitFor(ExpectedConditions.visibilityOf(this.proceedToCheckoutButton), 10);
    this.proceedToCheckoutButton.click();
  }

  public boolean correctNumberOfProducts() throws Exception {
    Utilities.sleep(3000, true);
    return Integer.parseInt(this.cartNumberOfProducts.getText()) == computedCartNumberOfProducts;
  }

  public void computedTotal() {
    computedTotal = computedTotal.add(new BigDecimal(this.productPrice.getText().substring(1)));
  }

  public void selectEveningDresses() {
    this.eveningDresses.click();
  }

  public String getUrl(String url) {
    Utilities.sleep(5000, true);
    return getDriver().getCurrentUrl();
  }

  public BigDecimal getComputedTotal() {
    return computedTotal;
  }

  public void open() {
    openUrl(URL);
  }

  public void open(String url) {
    openUrl(url);
  }
}
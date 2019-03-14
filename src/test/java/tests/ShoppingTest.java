package tests;
/*
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingCartSummaryPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class ShoppingTest extends BaseTest {
  private final String email;
  private final String password;

  public ShoppingTest() {
    this.email = getPropertyFromAppProp("email");
    this.password = getPropertyFromAppProp("password");
  }

  private LoginPage loginPage = null;
  private ProductPage productPage = null;
  private ShoppingCartSummaryPage shoppingCartSummaryPage = null;

  @BeforeMethod
  void beforeMethod() {
    this.loginPage = new LoginPage(getDriver());
    this.productPage = new ProductPage(getDriver());
    this.shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
  }

  @Test(
  description =
  "Purchase two products\n"
  + "Steps:\n"
  + "1. Open Home Page"
  + "2. Hover over Women section and click on T-shirts Page"
  + "3. Click Add to Cart button for Faded Short Sleeve T-shirts product"
  + "4. Click Continue shopping button"
  + "5. Click Add to Cart button for Blouse product"
  + "6. Click Proceed to checkout button"
  + "7. At 01. Summary step click Proceed to checkout button"
  + "8. At 02. Sign in step enter valid credentials and click Sign in button"
  + "9. At 03. Address step click Proceed to checkout"
  + "10. At 04. Shipping step select I agree to the terms of service and then click on Proceed to checkout"
  + "11. At 05. Payment step click on Pay by bank wire button"
  + "12. Click on I confirm my order button")
  public void testShopping() throws Exception{
    this.productPage.open();
    this.productPage.verify();
    this.productPage.clickAddToCartButton();
    this.productPage.clickContinueShopping();

    this.productPage.open("http://automationpractice.com/index.php?id_category=7&controller=category");
    this.productPage.verify();
    this.productPage.clickAddToCartButton();

    Assert.assertTrue(productPage.correctNumberOfProducts(), "The cart doesn't contain the correct number of products");

    this.productPage.clickProceedToCheckout();

    Assert.assertTrue(this.productPage.getComputedTotal().equals(shoppingCartSummaryPage.getCartTotal()),
            "The cart doesn't display the correct Total");

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickProceedToCheckoutAtSummary();

    this.loginPage.verify();
    this.loginPage.login(this.email, this.password);

    this.verifyPageAndProceedToCheckout();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickAgreeTermsOfService();

    this.verifyPageAndProceedToCheckout();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickPayByBankWire();

    this.verifyPageAndProceedToCheckout();

    Assert.assertEquals(
        this.shoppingCartSummaryPage.getPageHeadingText(),
        "ORDER CONFIRMATION",
        "Order confirmation page header is incorrect.");
  }

  public void verifyPageAndProceedToCheckout() {
    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickProceedToCheckout();
  }
}
*/
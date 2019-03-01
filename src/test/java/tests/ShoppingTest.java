package tests;

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

  @Test
  public void testShopping() throws Exception {
    this.productPage.open();
    this.productPage.verify();
    this.productPage.clickAddToCartButton();
    this.productPage.clickContinueShopping();

    this.productPage.open();
    this.productPage.verify();
    this.productPage.clickAddToCartButton();
    this.productPage.clickProceedToCheckout();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickProceedToCheckoutAtSummary();

    this.loginPage.verify();
    this.loginPage.login(this.email, this.password);

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickProceedToCheckout();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickAgreeTermsOfService();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickProceedToCheckout();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickPayByBankWire();

    this.shoppingCartSummaryPage.verify();
    this.shoppingCartSummaryPage.clickProceedToCheckout();

    Assert.assertEquals(
        this.shoppingCartSummaryPage.getPageHeadingText(),
        "ORDER CONFIRMATION",
        "Order confirmation page header is incorrect.");
  }

  public void addProductToCart() {}
}

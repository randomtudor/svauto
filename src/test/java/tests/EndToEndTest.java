
package tests;
/*
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;

public class EndToEndTest extends BaseTest {
  private DashboardPage dashboardPage;
  private LoginPage loginPage;
  private ProductPage productPage;
  private ShoppingCartSummaryPage shoppingCartSummaryPage;


  private final String email;
  private final String password;

  public EndToEndTest() {
    this.email = getPropertyFromAppProp("email");
    this.password = getPropertyFromAppProp("password");
  }

  @BeforeMethod
  void beforeMethod() {
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.productPage = new ProductPage(getDriver());
    this.shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
  }

  @Test
  public void testEndToEndTest() throws Exception {
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(this.email, this.password);

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
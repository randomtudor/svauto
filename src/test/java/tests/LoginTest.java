package tests;

import helpers.ConfigPropertiesFile;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.Properties.*;

//import static helpers.Utilities.getPropertyFromAppProp;
import static helpers.Utilities.getPropertyValue;

public class LoginTest extends BaseTest {

  private DashboardPage dashboardPage;
  private LoginPage loginPage = null;
  private MyAccountPage myAccountPage = null;

  private final String email;
  private final String password;

  public LoginTest() {
    ConfigPropertiesFile properties = new ConfigPropertiesFile();

    this.email = properties.getEmail();
    this.password = properties.getPassword();

    System.out.println("EMAIL: " + this.email);
    System.out.println("PASSWORD: " + this.password);

    System.exit(0);
  }

  @BeforeMethod
  void beforeMethod() {
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.myAccountPage = new MyAccountPage(getDriver());
  }

  @Test
  public void testLogin() {
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(this.email, this.password);

    this.myAccountPage.verify();
    Assert.assertEquals(
        this.myAccountPage.getPageHeadingText(),
        "MY ACCOUNT",
        "My Account page header is incorrect");
  }
}

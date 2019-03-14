package tests;

import helpers.AccountData;
import helpers.AlertRegistrationPage;
import helpers.TestType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

 public class RegistrationTest extends BaseTest {
   private LoginPage loginPage = null;
   private RegistrationPage registrationPage = null;
   private MyAccountPage myAccountPage = null;

   @DataProvider(name = "create new account")
   public static Object[][] registrationData() {
     return new Object[][] {
       {AccountData.createNewAccountData(TestType.POSITIVE)},
       {AccountData.createNewAccountData(TestType.NEGATIVE)}
     };
   }

   @BeforeMethod
   void beforeMethod() {
     this.loginPage = new LoginPage(getDriver());
     this.registrationPage = new RegistrationPage(getDriver());
     this.myAccountPage = new MyAccountPage(getDriver());
   }

   @Test(
   dataProvider = "create new account",
   description =
   "Test creating a new account using positive and negative account data\n"
   + "Steps:\n"
   + "1. Open Home page and click the Sign In button"
   + "2. Verify the Login page is displayed"
   + "3. Insert valid email into email input"
   + "4. Click the Create an account button"
   + "5. Insert valid and invalid data in the fields"
   + "6. Click the Register button")
   public void testRegistrationWithData(AccountData accountData) throws Exception {
     if (accountData.getType() == TestType.POSITIVE) {
       this.loginPage.open();
       this.loginPage.verify();
       this.loginPage.newAccountRegistration(accountData.getEmail());

       this.registrationPage.verify();
       this.registrationPage.fillAccountData(accountData);

       this.myAccountPage.verify();
       testLogin(accountData.getEmail(), accountData.getPassword());

       Assert.assertEquals(
          this.myAccountPage.getPageHeadingText(),
          "MY ACCOUNT",
          "My Account page header is incorrect.");
     }
     else {
       this.loginPage.open();
       this.loginPage.verify();
       this.loginPage.newAccountRegistration(accountData.getEmail());

       this.registrationPage.verify();
       this.registrationPage.fillAccountData(accountData);

       Assert.assertEquals(
          this.registrationPage.getPageHeadingText(),
          "CREATE AN ACCOUNT",
          "Create an account page header is incorrect.");

       final AlertRegistrationPage alert = new AlertRegistrationPage(getDriver());
       final SoftAssert softAssert = new SoftAssert();

       softAssert.assertTrue(
          alert.getAlertContainerText().contains("phone"),
          "The alert for the phone number in case that the user didn't fill it appears incorrect.");
       softAssert.assertTrue(
          alert.getAlertContainerText().contains("firstname"),
          "The alert for the first name in case that the user didn't fill it appears incorrect.");
       softAssert.assertAll();
     }
   }

    @Test
    public void testLogin(final String mail, final String password) throws Exception {
      this.myAccountPage.myAccountLogOut();
      this.loginPage.verify();

      this.loginPage.login(mail, password);
      this.myAccountPage.verify();
    }

    @Test(
        description =
            "Test creating a new account using empty account data\n"
                + "Steps:\n"
                + "1. Open Home page and click the Sign In button"
                + "2. Verify the Login page is displayed"
                + "3. Insert valid email into email input"
                + "4. Click the Create an account button"
                + "5. Click the Register button")
    public void testRegistrationWithEmptyData() {
      this.loginPage.open();
      this.loginPage.verify();
      this.loginPage.newAccountRegistration(AccountData.randomEmail());

      this.registrationPage.verify();
      this.registrationPage.accountRegistrationWithEmptyValues();

      this.registrationPage.verify();
      Assert.assertEquals(
              this.myAccountPage.getPageHeadingText(),
              "CREATE AN ACCOUNT",
              "Registration page header is incorrect.");

      final AlertRegistrationPage alert = new AlertRegistrationPage(getDriver());
      final SoftAssert softAssert = new SoftAssert();

      softAssert.assertTrue(
          alert.getAlertContainerText().contains("phone"),
          "The alert for the phone number in case that the user didn't fill it appears incorrect.");
      softAssert.assertTrue(
          alert.getAlertContainerText().contains("firstname"),
          "The alert for the first name in case that the user didn't fill it appears incorrect.");
      softAssert.assertAll();
    }
}

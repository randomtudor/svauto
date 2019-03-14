package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.DashboardPage;
import pages.LoginPage;

public class ContactTest extends BaseTest {

  private ContactPage contactPage = null;

  @BeforeMethod
  void beforeMethod() {
    this.contactPage = new ContactPage(getDriver());
  }

  @Test
  public void testContactUs() {
    this.contactPage.open();
    this.contactPage.verify();
    this.contactPage.fillMessageData();
    this.contactPage.verify();

    Assert.assertEquals(
            this.contactPage.alertSuccesText(),
            "Your message has been successfully sent to our team.",
            "The message has not been sent.");
  }
}

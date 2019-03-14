package tests;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;

public class FilterTest extends BaseTest {
  private static final String URL = "http://automationpractice.com/index.php?id_category=8&controller=category";
  private ProductPage productPage;

  @BeforeMethod
  void beforeMethod() {
    this.productPage = new ProductPage(getDriver());
  }

  @Test
  public void testFilterProducts() {
    this.productPage.open(URL);
    this.productPage.verify();

    this.productPage.selectEveningDresses();
    Assert.assertTrue(this.productPage.getUrl(URL).contains("evening_dresses"),
            "The selected filter \"evening_dresses\" it's not displayed in URL.");
  }
}
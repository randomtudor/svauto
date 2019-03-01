package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class DashboardPage extends BasePage {

  private static final String URL = "http://automationpractice.com";

  @FindBy(id = "homeslider")
  private WebElement carousel;

  public DashboardPage(final WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(this.carousel);
  }

  @Override
  protected boolean isValid() {
    return areVisible(this.carousel);
  }

  public void clickLoginButton() {
    this.headerLoginButton.click();
  }

  public void open() {
    openUrl(URL);
  }
}

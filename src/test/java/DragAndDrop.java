import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import utils.WebDriverFactory;

public class DragAndDrop {
  @BeforeMethod
  public void setUp() {
    WebDriverFactory.createInstance("chrome");
  }

  @Test
  public void moveBankToAccountOfDebitSideTest() {
    new DragAndDropPage().navigateToPage();
    new DragAndDropPage().moveBankToAccountOfDebitSide();
    Assert.assertTrue((new DragAndDropPage().findMovedElement()).contains("BANK"));
  }

  @AfterMethod
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }
}
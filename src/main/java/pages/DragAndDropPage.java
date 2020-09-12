package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class DragAndDropPage {

  private By element = By.id("credit2");
  private By toGrid = By.id("bank");
  private By result = By.xpath("//ol[@id='bank']/li");

  public void navigateToPage() {
    WebDriverFactory.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
  }

  public WebElement findFromElement() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
    return (wait.until(ExpectedConditions.elementToBeClickable(element)));
  }

  public WebElement findToElement() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
    return (wait.until(ExpectedConditions.elementToBeClickable(toGrid)));
  }

  public void moveBankToAccountOfDebitSide() {
    Actions act = new Actions(WebDriverFactory.getDriver());
    act.dragAndDrop(findFromElement(), findToElement()).build().perform();
  }

  public String findMovedElement() {
    return (WebDriverFactory.getDriver().findElement(result).getText());
  }
}
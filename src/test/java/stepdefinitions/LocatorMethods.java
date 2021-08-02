package stepdefinitions;

import static stepdefinitions.InitializeTest.driver;
import static stepdefinitions.InitializeTest.elementIds;
import static stepdefinitions.InitializeTest.locatorTypes;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LocatorMethods {

  public static MobileElement elementLocator(String element) {
    String id = elementIds.getProperty(element);
    String type = locatorTypes.getProperty(element);

    MobileElement element1 = null;

    switch (type) {
      case "id":

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element1 = driver.findElement(By.id(id));
        break;
      case "contentdesc":
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait2 = new WebDriverWait(driver,30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(new ByAccessibilityId(id)));
        //new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElementByAccessibilityId(id)));
        element1 = driver.findElementByAccessibilityId(id);
        break;
      case "name":
        element1 = driver.findElement(By.name(id));
        break;
      case "linktext":
        element1 = driver.findElement(By.linkText(id));
        break;
      case "xpath":
        // element = driver.findElement(By.xpath(id));
        element1 = driver.findElement(MobileBy.xpath(id));
        break;

      case "class":
        element1 = driver.findElementByClassName(id);
        break;

      default:
        throw new IllegalStateException("Unexpected value: " + type);
    }
    return element1;
  }

}

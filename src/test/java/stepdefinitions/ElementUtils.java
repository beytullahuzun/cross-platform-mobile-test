package stepdefinitions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidKeyCode;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static stepdefinitions.InitializeTest.driver;
import static stepdefinitions.InitializeTest.elementIds;
import static stepdefinitions.LocatorMethods.elementLocator;
import static stepdefinitions.RandomValueGenerator.randomValues;


public class ElementUtils {

  public static void textInShouldBeHelper(String element, String expected) {

    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    String actualText = elementLocator(element).getText();
    Assert.assertEquals(actualText, expected);
  }

  public static void userCannotLeaveHelper(String element) {
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    isElementDisplayedAndEnabled(element, true);
  }

  public static void userCannotClickSubmitAndProceedToNextViewHelper() {

    boolean state = true;
    try {
      driver.findElementByAccessibilityId("submit button").click();
      driver.findElementByAccessibilityId("open mail app button");
    } catch (NoSuchElementException e) {
      state = false;
    }
    Assert.assertEquals(false, state);
  }

  public static void userClicksHelper(String element) {
    boolean isDisplayed = elementLocator(element).isDisplayed();
    //System.out.println(isDisplayed);
    Assert.assertEquals(isDisplayed, true);
    elementLocator(element).click();

  }

  //Send text from feature file to area
  public static void userEntersToAreaHelper(String value, String element) {
    //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    //boolean isDisplayed = elementLocator(element).isDisplayed();
    //Assert.assertEquals(isDisplayed, true);
    elementLocator(element).sendKeys(value);
  }

  //Send predefined text from properties file
  public static void userEntersToTheAreaHelper(String value, String element) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    String predefinedText = elementIds.getProperty(value);
    boolean isDisplayed = elementLocator(element).isDisplayed();
    Assert.assertEquals(isDisplayed, true);
    elementLocator(element).sendKeys(predefinedText);
  }

  //Sends random keys by using randomValues
  public static void userEntersValuesToAreaHelper(String value, String element) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    String newText = randomValues(value);
    System.out.println("    "+value + " generated is: " + newText);
    boolean isDisplayed = elementLocator(element).isDisplayed();
    Assert.assertEquals(isDisplayed, true);
    elementLocator(element).sendKeys(newText);
  }

  public static void userEntersOTPHelper() {
    driver.findElementByAccessibilityId("otp digit 0").sendKeys("5");
    driver.findElementByAccessibilityId("otp digit 1").sendKeys("2");
    driver.findElementByAccessibilityId("otp digit 2").sendKeys("1");
    driver.findElementByAccessibilityId("otp digit 3").sendKeys("3");
    driver.findElementByAccessibilityId("otp digit 4").sendKeys("5");
    driver.findElementByAccessibilityId("otp digit 5").sendKeys("5");
    driver.findElementById("android:id/content").click();

  }

  public static void isElementDisplayedAndEnabled(String element, boolean expected) {
    boolean isEnabled = elementLocator(element).isEnabled();
    //System.out.println(isEnabled);
    Assert.assertEquals(isEnabled, expected);
  }

  public static void userShouldProceedPaymentDetailsScreenHelper() {
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    String name = "NAME";
    isElementDisplayedAndEnabled(name, true);
  }


  public static void userShouldProceedScreenHelper(String element) {

   new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    boolean actual = elementLocator(element).isEnabled();
    //System.out.println(actual+ " " + elementLocator(element));
    Assert.assertEquals(true,actual);
  }

  public static void userShouldNotProceedScreenHelper(String element) {

    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    boolean actual = elementLocator(element).isEnabled();
    System.out.println(actual);
    Assert.assertEquals(false,actual);
  }


  public static void fieldShouldBeLengthHelper(String element, int expected) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));

    //length assertatio
    int actualLength = elementLocator(element).getText().length();
    System.out.println(
        "Actual length of the " + element + " is :" + actualLength + ". Expected length :"
            + expected);
    boolean result = true;
    if (actualLength <= expected) {
      System.out.println(
          "The actual lenght is: " + actualLength + "The expected length is : " + expected);
    } else {
      result = false;
    }
    Assert.assertEquals(true, result);
  }

  public static void shouldContainHelper(String element, String expected) {
    String sampleTextProp = elementIds.getProperty(expected);
    //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    String actualText = elementLocator(element).getText();
    System.out.println("    Value in the field : " + actualText);
    Assert.assertEquals(sampleTextProp, actualText);
  }

  public static void shouldBeHelper(String element, String expected) {
    String condesc = elementIds.getProperty(element);
    //System.out.println("pre-if :"+condesc);

    if (expected.equals("disabled")) {
      condesc = elementIds.getProperty(element)+"-disabled";
    }
    else {}

    System.out.println("   Actual attribute :"+condesc);
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(new ByAccessibilityId(condesc)));
    driver.findElementsByAccessibilityId(condesc);
  }


  public static void shouldBeEditableHelper(String element) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    boolean isEnabled = elementLocator(element).isEnabled();
    Assert.assertTrue(isEnabled);
    elementLocator(element).clear();
    elementLocator(element).sendKeys("Editing");
  }


  public static void shouldNotBeClickableHelper(String element) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elementLocator(element)));
    boolean isEnabled = elementLocator(element).isEnabled();
    Assert.assertEquals(isEnabled, false);
  }


  public static void userWaitsSecondsHelper(int limit) {
    driver.manage().timeouts().implicitlyWait(limit, TimeUnit.SECONDS);
    driver.findElementById("android:id/content").click();


  }


  public static void userEntersValidValuesToSORT_CODEAreaHelper(){
    WebDriverWait wait2 = new WebDriverWait(driver,30);
    wait2.until(ExpectedConditions.visibilityOfElementLocated(new ByAccessibilityId("sortcode input")));
  //driver.findElementByAccessibilityId("sortcode input").setValue("12-34-56");
   driver.findElementByAccessibilityId("sortcode input").sendKeys("12-34-56");


    //driver.getKeyboard().sendKeys("6");


    //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    //driver.findElementByAccessibilityId("sortcode input").sendKeys(b);
    //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    //driver.findElementByAccessibilityId("sortcode input").sendKeys(c);

  }





  public static void userViewsAddressesAssociatedWithHelper(String arg0) {
    String a = driver.findElementByAccessibilityId("house number input").getText();
    String b = driver.findElementByAccessibilityId("address select link 0").getText();

    System.out.println(arg0);

    System.out.println(a);
    System.out.println(b);

  }

  public static void experimentalStepHelper() {

  }

  public static void userEntersPasscodeHelper()
  {
    WebDriverWait wait2 = new WebDriverWait(driver,30);
    wait2.until(ExpectedConditions.visibilityOfElementLocated(new ByAccessibilityId("button 1")));
    //new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElementByAccessibilityId(id)));
    driver.findElementByAccessibilityId("button 5").click();
    driver.findElementByAccessibilityId("button 4").click();
    driver.findElementByAccessibilityId("button 5").click();
    driver.findElementByAccessibilityId("button 4").click();
    driver.findElementByAccessibilityId("button 5").click();
    driver.findElementByAccessibilityId("button 4").click();

  }



}
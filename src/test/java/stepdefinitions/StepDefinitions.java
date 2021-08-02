package stepdefinitions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static stepdefinitions.ElementUtils.*;
import static stepdefinitions.InitializeTest.driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;


public class StepDefinitions {

  @And("text in {string} should be {string}")
  public void textInShouldBe(String element, String expected) {
    textInShouldBeHelper(element, expected);
  }

  @And("user cannot leave {string}")
  public void userCannotLeave(String element) {
    userCannotLeaveHelper(element);
  }

  @And("user cannot click submit and proceed to next view")
  public void userCannotClickSubmitAndProceedToNextView() {
    userCannotClickSubmitAndProceedToNextViewHelper();
  }

  @Given("user clicks {string}")
  public static void userClicks(String element) {
    userClicksHelper(element);
  }

  @When("user enters {string} to {string} area")
  public static void userEntersToArea(String value, String element) {
    userEntersToAreaHelper(value, element);
  }

  @Given("user enters {string} to the {string} area")
  public void userEntersToTheArea(String value, String element) {
    userEntersToTheAreaHelper(value, element);
  }

  //Enters random values
  @When("user enters {string} values to {string} area")
  public void userEntersValuesToArea(String value, String element) {
    userEntersValuesToAreaHelper(value, element);
  }

  @Given("user launches the application$")
  public void user_launches_the_application() {
  }

  @And("user scanned id")
  public void userScannedId() {
  }

  @Then("user should proceed {string}")
  public void userShouldProceedScreen(String element) {
    userShouldProceedScreenHelper(element);
  }

  @And("user should not proceed {string}")
  public void userShouldNotProceed(String element){
    userShouldNotProceedScreenHelper(element);
  }


  @Then("user should proceed payment details screen")
  public void userShouldProceedPaymentDetailsScreen() {
    userShouldProceedPaymentDetailsScreenHelper();
  }

  @Then("user should see {string}")
  public void userShouldSee(String element) {
    isElementDisplayedAndEnabled(element, true);
  }

  @Given("user views {string} screen")
  public void userViewsScreen(String element) {
    isElementDisplayedAndEnabled(element, true);
  }

  @Given("user views {string}")
  public void userViews(String element) {
    isElementDisplayedAndEnabled(element, true);
  }

  @And("{string} field should be {int} length or less")
  public void fieldShouldBeLength(String element, int expected) {
    fieldShouldBeLengthHelper(element, expected);
  }

  @And("{string} should contain {string}")
  public void shouldContain(String element, String expected) {
    shouldContainHelper(element, expected);
  }

  @Then("{string} should be displayed and enabled")
  public static void shouldBeDisplayedAndEnabled(String element) {
    isElementDisplayedAndEnabled(element, true);
  }

  @And("{string} should be editable")
  public void shouldBeEditable(String element) {
    shouldBeEditableHelper(element);
  }

  @And("{string} should not be clickable until all fields are populated")
  public void shouldNotBeClickableUntilAllFieldsArePopulated(String element) {
    shouldNotBeClickableHelper(element);
  }



  //Bos
  @Then("skipped {string}")
  public void skippedStep(String arg0) {
  }

  @Then("{string} should be {string}")
  public void shouldBe(String element, String expected) {
    shouldBeHelper(element, expected);
  }

  @And("user enters valid values to SORT_CODE area")
  public void userEntersValidValuesToSORT_CODEArea() {
    userEntersValidValuesToSORT_CODEAreaHelper();
  }

  @Then("{string} should {string} checked")
  public void shouldChecked(String arg0, String arg1) {
  }

  @When("user enters OTP")
  public void userEntersOTP() {
    userEntersOTPHelper();
  }

  @When("user enters random OTP")
  public void userEntersRandomOTP() {
    userEntersOTPHelper();
  }

  @When("user waits for {int} seconds")
  public void userWaitsSeconds(int limit) {
    userWaitsSecondsHelper(limit);
  }


  @Then("user views addresses associated with {string}")
  public void userViewsAddressesAssociatedWith(String arg0) {
    userViewsAddressesAssociatedWithHelper(arg0);
  }


  @Given("experimental step def")
  public void experimentalStep() {
    experimentalStepHelper();
  }

  @And("user enters passcode")
  public void userEntersPasscode() {userEntersPasscodeHelper();
  }

  @And("user doesn't view {string}")
  public void userDoesnTView(String arg0) {
    System.out.println("View Screenshot_1.jpg");

  }
}
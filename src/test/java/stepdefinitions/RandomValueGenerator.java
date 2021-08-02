package stepdefinitions;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomValueGenerator {

  public static void main(String[] args) {
    //Test all random generator methods
    System.out.println("Email :" + randomValues("RANDOM_VALID_EMAIL"));
    System.out.println("Password :" + randomValues("RANDOM_VALID_PASSWORD"));
    System.out.println("Full Legal Name :" + randomValues("RANDOM_VALID_FULL_LEGAL_NAME"));
    System.out.println("Phone :" + randomValues("RANDOM_VALID_PHONE"));
    System.out.println("Postcode :" + randomValues("RANDOM_VALID_POSTCODE"));
    System.out.println("Account no :" + randomValues("RANDOM_VALID_ACCOUNT_NUMBER"));
    System.out.println("Sortcode :" + randomValues("RANDOM_VALID_SORT_CODE"));
    System.out.println("Error Message Test :" + randomValues("Wrong param"));
  }

  public static String randomValues(String value) {
    String randomValue1 = "";

    //To generate a valid random email
    if (value.equals("RANDOM_VALID_EMAIL")) {
      String name = RandomStringUtils.random(10, true, true);
      String domain = RandomStringUtils.randomAlphabetic(7);
      String ext = RandomStringUtils.randomAlphabetic(4);
      randomValue1 = name + "@" + domain + "." + ext;
    }
    //To generate a valid random password
    else if (value.equals("RANDOM_VALID_PASSWORD")) {
      randomValue1 = RandomStringUtils.random(8, true, true);
    }
    //To generate a valid name and surname
    else if (value.equals("RANDOM_VALID_FULL_LEGAL_NAME")) {
      String firstName = RandomStringUtils.randomAlphabetic(7);
      String lastName = RandomStringUtils.randomAlphabetic(7);
      randomValue1 = firstName + " " + lastName;
    }
    else if (value.equals("RANDOM_VALID_NAME")) {
      String firstName = RandomStringUtils.randomAlphabetic(7);
      String lastName = RandomStringUtils.randomAlphabetic(7);
      randomValue1 = firstName + " " + lastName;
    }

    //To generate a valid phone number
    else if (value.equals("RANDOM_VALID_PHONE")) {
      randomValue1 = RandomStringUtils.randomNumeric(10);
    }
    //To generate a valid UK post code
    else if (value.equals("RANDOM_VALID_POSTCODE")) {
      String postCode1 = RandomStringUtils.randomAlphabetic(2);
      String postCode2 = RandomStringUtils.randomNumeric(2);
      String postCode3 = RandomStringUtils.randomAlphabetic(2);
      randomValue1 = postCode1 + postCode2 + postCode3;
    }
    else if (value.equals("RANDOM_VALID_ACCOUNT_NUMBER")) {
      randomValue1 = RandomStringUtils.randomNumeric(8);
    }

    else if (value.equals("RANDOM_VALID_SORT_CODE")) {
     String a = RandomStringUtils.randomNumeric(2);
     String b = RandomStringUtils.randomNumeric(2);
     String c = RandomStringUtils.randomNumeric(2);

      randomValue1 = a + "-" + b + "-" + c;
    }

    else {
      randomValue1 = "Check your feature file. You entered an invalid random value type!";
      System.out.println("Check your feature file. You entered an invalid random value type!");
    }
    return randomValue1;
  }

}
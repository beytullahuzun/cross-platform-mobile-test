package stepdefinitions;

import cucumber.api.java.en.Given;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;
import static stepdefinitions.InitializeTest.elementIds;

public class testData {
  @Given("new connection")
  public void userconnected() throws Exception{
    //Registering the Driver
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    //Getting the connection
    //String mysqlUrl = "jdbc:mysql://test.url.com:3306";
    String mysqlUrl = elementIds.getProperty("URL");
    String mysqlUser = elementIds.getProperty("USER");
    String mysqlPw = elementIds.getProperty("PW");


    Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPw);
    System.out.println("Connection established......");
    //Initialize the script runner
    ScriptRunner sr = new ScriptRunner(con);
    //Creating a reader object
    Reader reader = new BufferedReader(new FileReader("resources/sampleScript.sql"));
    //Running the script
    sr.runScript(reader);
  }

  @Given("{string} for test purposes")
  public void forTestPurposes(String sqlScript) throws Exception{
    //Registering the Driver
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    //Getting the connection
    //String mysqlUrl = "jdbc:mysql://test.url.com:3305";
    String mysqlUrl = elementIds.getProperty("URL");
    String mysqlUser = elementIds.getProperty("USER");
    String mysqlPw = elementIds.getProperty("PW");
    String fileName = elementIds.getProperty(sqlScript);


    Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPw);
    System.out.println("Connection established......");
    //Initialize the script runner
    ScriptRunner sr = new ScriptRunner(con);
    //Creating a reader object
    Reader reader = new BufferedReader(new FileReader(fileName));
    //Running the script
    sr.runScript(reader);
  }
}
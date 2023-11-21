package testsuite;
/**
 *  Write down the following test into ‘LoginTest’ class 1. userSholdLoginSuccessfullyWithValidCredentials  * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
     static String baseUrl = "http://the-internet.herokuapp.com/login";

     @Before
         public void setUp(){
         openBrowser(baseUrl);
     }
     @Test
     public void userShouldLoginSuccessfullyWithValidCredentials(){
         //Enter username
     driver.findElement(By.id("username")).sendKeys("tomsmith");
         // Enter password
         driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
         //Click on Login Button
         driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
         //Verify the text 'Secure Area'
         String expectedMessage = "Secure Area";
         String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText();
         Assert.assertEquals(expectedMessage, actualMessage);
     }
     @Test
     public void verifyTheUsernameErrorMessage(){
             //Enter username
            driver.findElement(By.id("username")).sendKeys("tomsmith1");
            // Enter password
         driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
         //Click on Login button
         driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
         //Verify the error message
         String expectedErrorMessage = "Your username is invalid!";
         String actualErrorMessage = driver.findElement(By.id("flash")).getText();
         Assert.assertEquals("Your username is invalid!","Your username is invalid!");
     }
      @Test
      public void verifyThePasswordErrorMessage(){
          //Enter username
          driver.findElement(By.id("username")).sendKeys("tomsmith");
          // Enter password
          driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
          //Click on Login button
          driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
          //Verify the error message
          String expectedErrorMessage = " Your password is invalid!";
          String actualErrorMessage = driver.findElement(By.id("flash")).getText();
          Assert.assertEquals("Your password is invalid!", "Your password is invalid!");
      }


    @After
    public void tearDown(){
         closeBrowser();
     }
}

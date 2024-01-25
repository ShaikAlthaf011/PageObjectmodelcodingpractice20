package EbankAppTestPage;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import EbankAppTest4.LoginPage;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;
    int count;

    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }
    @Test(priority=1)
    public void LoginPageUI(){
    Assert.assertTrue(loginPage.getimage().isDisplayed(),"Login image is not displayed");
    Assert.assertEquals(loginPage.getHeading(),"User ID","User id label text does not match");
    Assert.assertEquals(loginPage.getsecondheading(),"PIN","Pin label text does not match");
    loginPage.Clickloginbutton();
    Assert.assertEquals(loginPage.geterrormessage(),"Invalid user ID","Heading text does not match");
    }
    @Test(priority = 2)
    public void emptyinputfields(){
        loginPage.Clickloginbutton();
        Assert.assertEquals(loginPage.geterrormessage(),"Invalid user ID","Error text with empty input fields does not match");
    }
    @Test(priority = 3)
    public void emptyUserIDfield(){
     loginPage.Enterpin();
     loginPage.Clickloginbutton();
     Assert.assertEquals(loginPage.geterrormessage(),"Invalid user ID","Error text with empty input field do not match");
    }
    @Test(priority = 4)
    public void emptyPINfield(){
    loginPage.EnterId();
    loginPage.Clickloginbutton();
    Assert.assertEquals(loginPage.InvalidPin(),"Invalid PIN","Error text with empty input field do not match");
    }
    @Test(priority = 5)
    public void invalidPIN(){
        loginPage.EnterId();
        loginPage.Duplicatepin();
        loginPage.Clickloginbutton();
        Assert.assertEquals(loginPage.notmatchpaswword(),"User ID and PIN didn't match","Error text with invalid PIN do not match");
    }
    @Test(priority = 6)
     public void Succesfullylogin(){
        loginPage.successuserid();
        loginPage.successpin();
        loginPage.Clickloginbutton();
        Assert.assertEquals(loginPage.geturl(),"https://qaebank.ccbp.tech/","URLs do not match");
    }

    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}

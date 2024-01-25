package JobbyAppTest4Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JobbyAppTest4page.LoginPage;

public class LoginpageTest {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }
    @Test(priority=1)
    public void LoginPageUI() {
        Assert.assertTrue(loginPage.isdisplayedimage(), "App logo is not displayed");
        Assert.assertEquals(loginPage.getlabeltext(),"USERNAME","Username label text does not match");
        Assert.assertEquals(loginPage.getpasswordtext(),"PASSWORD","Password label text does not match");
    }
    @Test(priority = 2)
    public void EmptyField(){
        loginPage.CLICKLOGINBUTTON();
        Assert.assertEquals(loginPage.ErrorMessage(),"*Username or password is invalid");
    }
    @Test(priority = 3)
    public void EmptyUsernameField(){
        loginPage.Enterpassword();
        loginPage.CLICKLOGINBUTTON();
        Assert.assertEquals(loginPage.FindText(),"*Username or password is invalid");
    }
    @Test(priority = 4)
    public void Emptypasswordfield(){
        loginPage.EnterName();
        loginPage.CLICKLOGINBUTTON();
        Assert.assertEquals(loginPage.ErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");
    }
    @Test(priority = 5)
    public void Invalidpassword(){
        loginPage.EnterName();
        loginPage.Anotherpassword();
        loginPage.CLICKLOGINBUTTON();
        Assert.assertEquals(loginPage.ErrorMessage(),"*username and password didn't match","Error text with invalid password do not match");
    }
    @Test(priority = 6)
    public void LoginSuccesfully(){
        loginPage.EnterName();
        loginPage.Password();
        loginPage.CLICKLOGINBUTTON();
        Assert.assertEquals(loginPage.URL(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }
    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}

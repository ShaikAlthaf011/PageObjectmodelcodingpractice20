package JobbyAppTest4Home;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JobbyAppTest4page.Headersectionpage;

public class HeadersectionTest {
    WebDriver driver;
    Headersectionpage headersectionpage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        headersectionpage=new Headersectionpage(driver);
    }
    @Test(priority = 1)
    public void Applogoisdisplayed(){
    headersectionpage.setEnterName();
    headersectionpage.setEnetrPassword();
    headersectionpage.setClickloginbutton();
    headersectionpage.VerifyUrl();
    Assert.assertTrue(headersectionpage.Verifylogo(),"App logo is not displayed");
    }
    @Test(priority = 2)
    public void NavbarLinkjob(){
        headersectionpage.setEnterName();
        headersectionpage.setEnetrPassword();
        headersectionpage.setClickloginbutton();
        headersectionpage.VerifyUrl();
        headersectionpage.Navbarjob();
        Assert.assertEquals(headersectionpage.jobssection(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");
    }
    @Test(priority = 3)
    public void Clickonapplogo(){
        headersectionpage.setEnterName();
        headersectionpage.setEnetrPassword();
        headersectionpage.setClickloginbutton();
        headersectionpage.VerifyUrl();
        headersectionpage.Navbarjob();
        headersectionpage.ClickApplogo();
        Assert.assertEquals(headersectionpage.VerifyUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }
    @Test(priority = 4)
    public void NavbarHomepage(){
        headersectionpage.setEnterName();
        headersectionpage.setEnetrPassword();
        headersectionpage.setClickloginbutton();
        headersectionpage.VerifyUrl();
        headersectionpage.Navbarjob();
        headersectionpage.ClickHomebutton();
        Assert.assertEquals(headersectionpage.VerifyUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }
    @Test(priority = 5)
    public void LogoutFuncationallity(){
        headersectionpage.setEnterName();
        headersectionpage.setEnetrPassword();
        headersectionpage.setClickloginbutton();
        headersectionpage.VerifyUrl();
        headersectionpage.Clickonlogoutbutton();
        Assert.assertEquals(headersectionpage.loginpage(),"https://qajobbyapp.ccbp.tech/login","URLs do not match");
    }
    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}

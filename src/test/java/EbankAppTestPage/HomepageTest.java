package EbankAppTestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import EbankAppTest4.HomePage;

public class HomepageTest {
    WebDriver driver;
    HomePage homePage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
    }
    @Test(priority = 1)
    public void HomepageUI(){
    homePage.ClickUserId();
    homePage.ClickPinId();
    homePage.Clicklogin();
    homePage.geturl();
    Assert.assertTrue(homePage.visibleimage(),"App logo is not displayed");
    Assert.assertEquals(homePage.headineElement(),"Your Flexibility, Our Excellence","Heading text does not match");
    Assert.assertTrue(homePage.cardimage(),"Digital card image is not displayed");
    }
    @Test(priority = 2)
    public void LogoutSuccesfully(){
        homePage.ClickUserId();
        homePage.ClickPinId();
        homePage.Clicklogin();
        homePage.geturl();
        homePage.Logoutbutton();
        Assert.assertEquals(homePage.returnurl(),"https://qaebank.ccbp.tech/ebank/login/","URLs do not match");
    }
    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }

}

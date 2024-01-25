package Page4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page3.LoginPage;

public class HomePage {
    WebDriver driver;
    LoginPage loginPage;
    public Object[][]Dataset={
            {"142420","231225"},
            {"231225","142420"},
            {"152251","145555"},
            {"152444","235464"},
            {"142420","123456"},
            {"231225","142420"},
    };
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }
    @DataProvider
    public Object[][] Addlist(){
        return Dataset;
    }

    @Test(priority = 1,dataProvider = "Addlist")
    public void createdtestcase(String Enteruserid,String Userpin){
        loginPage.userid(Enteruserid);
        loginPage.pin(Userpin);
        loginPage.Setlogin();

    }
    @AfterMethod
    public void Closebrowser(){
       // driver.quit();
    }
}

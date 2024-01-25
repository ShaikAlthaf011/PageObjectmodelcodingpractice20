package JobbyAppTest4Home;

import org.openqa.selenium.WebDriver;
import JobbyAppTest4page.Homepage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;
    Homepage homepage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        homepage=new Homepage(driver);
    }
    @Test(priority = 1)
    public void Homepageheading(){
      homepage.NameEnter();
      homepage.PasswordEnter();
      homepage.ClickLoginbutton();
      homepage.identifyurl();
      Assert.assertEquals(homepage.Verifyheading(),"Find The Job That Fits Your Life","Heading text does not match");
      Assert.assertEquals(homepage.Verifydescription(),"Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.","Description text does not match");
    }
    @Test(priority = 2)
    public void JobButtonFuncationality(){
        homepage.NameEnter();
        homepage.PasswordEnter();
        homepage.ClickLoginbutton();
        homepage.Verifyurl();
        homepage.VerifyButton();
        homepage.Techjobs();
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}

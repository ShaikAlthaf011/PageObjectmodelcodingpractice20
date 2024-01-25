package Html2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Html1.LoginPageTest;

public class HomePageTest {
    WebDriver driver;
    LoginPageTest loginPageTest;
    public Object[][]Dataset={
            {"Althaf","ShaikAlthaf@gmail.com","123456","123456"},
            {"Santhosh","peddireddi@gmail.com","123456","123456"},
            {"Chandra","Chandrareddi@gmail.com","123456","123456"},
            {"Faruk","ShaikFaruk@gmail.com","123456","123456"},
            {"Sai","Anakasalasai@gmail.com","123456","123456"}
    };
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://codeconvey.com/Tutorials/registration-form-in-html-with-validation/");
        driver.manage().window().maximize();
        loginPageTest=new LoginPageTest(driver);
    }
    @DataProvider
    public Object[][]Addlist(){
        return Dataset;
    }
    @Test(dataProvider = "Addlist")
    public void InvalidCredential(String Username,String Email,String Password,String ConfirmPassword){
        loginPageTest.Enterusername(Username);
        loginPageTest.EnterEmail(Email);
        loginPageTest.Enterpassword(Password);
        loginPageTest.EnterConfirmpassword(ConfirmPassword);
        loginPageTest.submitbutton();
    }
    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}

package Html1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
    WebDriver driver;
    By Addusername= By.cssSelector("div[class='wrapInput']:nth-child(1)>input");
    By AddEmail=By.cssSelector("div[class='wrapInput']:nth-child(2)>input");
    By Addpassword=By.cssSelector("div[class='wrapInput']:nth-child(3)>input");
    By AddConfirmpassword=By.cssSelector("div[class='wrapInput']:nth-child(4)>input");
    By Clickonsubmitbutton=By.cssSelector("div[class='wrapInput']:nth-child(5)>input");
    public LoginPageTest(WebDriver driver){
        this.driver=driver;
    }
    public void Enterusername(String Username){
        driver.findElement(Addusername).clear();
        driver.findElement(Addusername).sendKeys(Username);
    }
    public void EnterEmail(String Email){
        driver.findElement(AddEmail).clear();
        driver.findElement(AddEmail).sendKeys(Email);
    }
    public void Enterpassword(String Password){
        driver.findElement(Addpassword).clear();
        driver.findElement(Addpassword).sendKeys(Password);
    }
    public void EnterConfirmpassword(String ConfirmPassword){
        driver.findElement(AddConfirmpassword).clear();
        driver.findElement(AddConfirmpassword).sendKeys(ConfirmPassword);
    }
    public void submitbutton(){
        driver.findElement(Clickonsubmitbutton).click();
    }
}

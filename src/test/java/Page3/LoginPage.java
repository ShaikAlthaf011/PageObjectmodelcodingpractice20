package Page3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By SetEnterUserid=By.cssSelector("div[class='input-container']:nth-child(2)>input");
    By SetEnterpin=By.cssSelector("div[class='input-container']:nth-child(3)>input");
    By login=By.cssSelector("#root > div > div > div > form > button");
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void userid(String Enteruserid){
        driver.findElement(SetEnterUserid).sendKeys(Enteruserid);
    }
    public void pin(String Userpin){
        driver.findElement(SetEnterpin).sendKeys(Userpin);
    }
    public void Setlogin(){
        driver.findElement(login).click();
    }
}


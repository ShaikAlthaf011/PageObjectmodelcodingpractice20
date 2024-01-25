package JobbyAppTest4page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By LogoImagelocater= By.cssSelector("img[class='login-website-logo']");
    By Labelusernamelocater=By.cssSelector("div[class='input-container']:nth-child(2)>label");
    By Labelpasswordlocater=By.cssSelector("div[class='input-container']:nth-child(3)>label");
    By clickloginbutton=By.cssSelector("button[class='login-button']");
    By GetErrorMessage=By.cssSelector("p[class='error-message']");
    By GetPassword=By.cssSelector("input[id='passwordInput']");
    By GetText=By.cssSelector("p[class='error-message']");
    By EnetrUsername=By.cssSelector("input[id='userNameInput']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isdisplayedimage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoImagelocater));
        WebElement l1= driver.findElement(LogoImagelocater);
        return l1.isDisplayed();
    }
    public String getlabeltext(){
        return driver.findElement(Labelusernamelocater).getText();
    }
    public String getpasswordtext(){
        return driver.findElement(Labelpasswordlocater).getText();
    }
    public void CLICKLOGINBUTTON(){
        driver.findElement(clickloginbutton).click();
    }
    public String ErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(GetErrorMessage));
        WebElement l2= driver.findElement(GetErrorMessage);
        return l2.getText();
    }
    public void Enterpassword(){
         driver.findElement(GetPassword).sendKeys("rahul@2021");

    }
    public String FindText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(GetText));
        WebElement l3= driver.findElement(GetText);
        return l3.getText();
    }
    public void EnterName(){
        driver.findElement(EnetrUsername).sendKeys("rahul");
    }
    public void Anotherpassword(){
        driver.findElement(GetPassword).sendKeys("rahul");
    }
    public void Password(){
        driver.findElement(GetPassword).sendKeys("rahul@2021");
    }
    public String URL(){
        String str1="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str1));
        return str1;
    }
}

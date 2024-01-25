package EbankAppTest4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
      WebDriver driver;
      WebDriverWait wait;
     By Findimage=By.className("login-ebank-image");
     By FinduserId=By.cssSelector("div[class='input-container']:nth-child(2)>label");
     By FindPinId=By.cssSelector("div[class='input-container']:nth-child(3)>label");
     By Findlogin=By.className("login-button");
     By FindByErrormessage=By.className("error-message-text");
     By getFindPinId=By.cssSelector("div[class='input-container']:nth-child(3)>input");
     By getFinduserId=By.cssSelector("div[class='input-container']:nth-child(2)>input");
     By GetInvalidpin=By.cssSelector("p[class='error-message-text']");
     By Notmatchpaswword=By.cssSelector("p[class='error-message-text']");
     By SuccesfullyuserId=By.cssSelector("#userIdInput");
     By SucesfullyPin=By.cssSelector("#pinInput");
    public LoginPage(WebDriver driver){
    this.driver=driver;
    this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
   public WebElement getimage(){
        return driver.findElement(Findimage);
    }
    public String getHeading(){
        return driver.findElement(FinduserId).getText();
    }
    public String getsecondheading(){
        return driver.findElement(FindPinId).getText();
    }
    public void Clickloginbutton(){
        driver.findElement(Findlogin).click();
    }
    public String geterrormessage(){
       wait.until(ExpectedConditions.visibilityOfElementLocated( FindByErrormessage));
       WebElement l1=driver.findElement(FindByErrormessage);
       return l1.getText();
    }
    public void Enterpin(){
         driver.findElement(getFindPinId).sendKeys("231225");
    }
    public void EnterId(){
        driver.findElement(getFinduserId).sendKeys("142420");
    }
    public String InvalidPin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(GetInvalidpin));
        WebElement webElement = driver.findElement(GetInvalidpin);
        return webElement.getText();
    }
    public void Duplicatepin(){
        driver.findElement(getFindPinId).sendKeys("123456");
    }
    public String notmatchpaswword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Notmatchpaswword));
        WebElement l3= driver.findElement(Notmatchpaswword);
        return l3.getText();
    }
    public void successuserid(){
        driver.findElement(SuccesfullyuserId).sendKeys("142420");
    }
    public void successpin(){
        driver.findElement(SucesfullyPin).sendKeys("231225");
    }
    public String geturl(){
        String str1="https://qaebank.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));
        return str1;
    }
}

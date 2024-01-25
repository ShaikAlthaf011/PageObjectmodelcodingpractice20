package JobbyAppTest4page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Headersectionpage {
    WebDriver driver;
    WebDriverWait wait;
    By EnterName= By.cssSelector("#userNameInput");
    By EnetrPassword=By.cssSelector("#passwordInput");
    By Clickloginbutton=By.cssSelector("#root > div > form > button");
    By visibileimage=By.cssSelector("#root > div > nav > div > div.nav-bar-large-container > a > img");
    By Clickonnavbarjoblink=By.cssSelector("#root > div > nav > div > div.nav-bar-large-container > ul > li:nth-child(2) > a");
    By Applogoclick=By.cssSelector("#root > div > nav > div > div.nav-bar-large-container > a > img");
    By Homebutton=By.cssSelector("#root > div > nav > div > div.nav-bar-large-container > ul > li:nth-child(1) > a");
    By LogoutButton=By.cssSelector("#root > div > nav > div > div.nav-bar-large-container > button");
    public Headersectionpage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void setEnterName(){
        driver.findElement(EnterName).sendKeys("rahul");
    }
    public void setEnetrPassword(){
        driver.findElement(EnetrPassword).sendKeys("rahul@2021");
    }
    public void setClickloginbutton(){
        driver.findElement(Clickloginbutton).click();
    }
    public String VerifyUrl(){
        String str="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str));
        return str;
    }
    public boolean Verifylogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibileimage));
        WebElement l1=driver.findElement(visibileimage);
        return l1.isDisplayed();
    }
    public void Navbarjob(){
        driver.findElement(Clickonnavbarjoblink).click();
    }
    public String jobssection(){
        String str2="https://qajobbyapp.ccbp.tech/jobs";
        wait.until(ExpectedConditions.urlToBe(str2));
        return str2;
    }
    public void ClickApplogo(){
        driver.findElement(Applogoclick).click();
    }
    public void ClickHomebutton(){
        driver.findElement(Homebutton).click();
    }
    public void Clickonlogoutbutton(){
        driver.findElement(LogoutButton).click();
        Alert ac=driver.switchTo().alert();
        ac.accept();
    }
    public String loginpage(){
        String str5="https://qajobbyapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(str5));
        return str5;
    }
}

package JobbyAppTest4page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;
    By EnterName= By.cssSelector("input[id='userNameInput']");
    By EnetrPassord=By.cssSelector("input[id='passwordInput']");
    By Clicklogin=By.cssSelector("button[class='login-button']");
    By Heading=By.cssSelector("h1[class='home-heading']");
    By Description=By.cssSelector("p[class='home-description']");
    By JobButton=By.cssSelector("#root > div > div > div > a > button");
    public Homepage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void NameEnter(){
        driver.findElement(EnterName).sendKeys("rahul");
    }
    public void PasswordEnter(){
        driver.findElement(EnetrPassord).sendKeys("rahul@2021");
    }
    public void ClickLoginbutton(){
        driver.findElement(Clicklogin).click();
    }
    public String identifyurl(){
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        String str1="URL: https://qajobbyapp.ccbp.tech/";
        return str1;
    }
    public String Verifyheading(){
        return driver.findElement(Heading).getText();
    }
    public String Verifydescription(){
        return driver.findElement(Description).getText();
    }
    public String Verifyurl(){
        String str1="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str1));
        return str1;
    }
    public void VerifyButton(){
        driver.findElement(JobButton).click();
    }
    public String Techjobs(){
        String str2="https://qajobbyapp.ccbp.tech/jobs";
        wait.until(ExpectedConditions.urlToBe(str2));
        return str2;
    }
}

package EbankAppTest4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By EnteruserId= By.cssSelector("div[class='input-container']:nth-child(2)>input");
    By EnterPinId=By.cssSelector("div[class='input-container']:nth-child(3)>input");
    By Clickloginbutton=By.cssSelector("button[class='login-button']");
    By findimage=By.cssSelector("#root > div > div.ebank-logo-container > img");
    By Heading=By.cssSelector("h1[class='heading']");
    By Carddigitial=By.cssSelector("img[class='digital-card-image']");
    By LogoutButton=By.cssSelector("#root > div > div.ebank-logo-container > button");

    public HomePage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void ClickUserId(){
        driver.findElement(EnteruserId).sendKeys("142420");
    }
    public void ClickPinId(){
        driver.findElement(EnterPinId).sendKeys("231225");
    }
    public void Clicklogin(){
        driver.findElement(Clickloginbutton).click();
    }
   public String geturl(){
        String str1="https://qaebank.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str1));
        return str1;
   }
   public boolean visibleimage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(findimage));
        WebElement l5= driver.findElement(findimage);
        return l5.isDisplayed();
    }
    public String headineElement(){
        return driver.findElement(Heading).getText();
    }
    public boolean cardimage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Carddigitial));
        WebElement l8= driver.findElement(Carddigitial);
        return l8.isDisplayed();
    }
    public void Logoutbutton(){
        driver.findElement(LogoutButton).click();
    }
    public String returnurl(){
        String str2="https://qaebank.ccbp.tech/ebank/login/";
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/ebank/login"));
        return str2;
    }
}

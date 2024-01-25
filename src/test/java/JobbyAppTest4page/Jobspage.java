package JobbyAppTest4page;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Jobspage {
    WebDriver driver;
    WebDriverWait wait;
    By Name= By.cssSelector("#userNameInput");
    By Password=By.cssSelector("#passwordInput");
    By Login=By.cssSelector("#root > div > form > button");
    By Findjob=By.cssSelector("#root > div > div > div > a > button");
    By Profile=By.cssSelector("#root > div > div > div > div.profile-and-filters-container > div.profile-container > img");
    By Heading=By.cssSelector("#root > div > div > div > div.profile-and-filters-container > div.profile-container > h1");
    By Description=By.cssSelector("#root > div > div > div > div.profile-and-filters-container > div.profile-container > p");
    By Search=By.cssSelector("#root > div > div > div > div.jobs-list-container > div > div > div > input");
    By clickiconsearch=By.cssSelector("#root > div > div > div > div.jobs-list-container > div > div > div > button");
    By imagedisplayed=By.cssSelector("#root > div > div > div > div.jobs-list-container > div.jobs-not-found-container > img");
    By visibleheading=By.cssSelector("#root > div > div > div > div.jobs-list-container > div.jobs-not-found-container > h1");
    By filterjobtext=By.cssSelector("#root > div > div > div > div.jobs-list-container > div.jobs-not-found-container > p");
    By SearchText=By.cssSelector("#root > div > div > div > div.jobs-list-container > div > div > div > input");
    By Count=By.cssSelector("ul[class='jobs-list']>a>li");
    By search=By.cssSelector("#root > div > div > div > div.jobs-list-container > div > div > div > button");
    public Jobspage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void EnterName(){
        driver.findElement(Name).sendKeys("rahul");
    }
    public void Enterpassword(){
        driver.findElement(Password).sendKeys("rahul@2021");
    }
    public void Click(){
        driver.findElement(Login).click();
    }
    public String GetURl(){
        String str="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str));
        return str;
    }
    public void clickfindjob(){
        driver.findElement(Findjob).click();
    }
    public boolean visibileprofile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile));
        WebElement l1=driver.findElement(Profile);
        return l1.isDisplayed();
    }
    public String heading(){
        return driver.findElement(Heading).getText();
    }
    public String description(){
        return driver.findElement(Description).getText();
    }
   public void textsearch(){
         driver.findElement(Search).sendKeys("Netflix");
   }
   public void searchboxclick(){
         driver.findElement(clickiconsearch).click();
   }
   public boolean imagevisibile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(imagedisplayed));
        WebElement l8= driver.findElement(imagedisplayed);
        return  l8.isDisplayed();
   }
   public String notfoundheading(){
        return driver.findElement(visibleheading).getText();
   }
   public String filter(){
        return driver.findElement(filterjobtext).getText();
   }
   public void Textsearch(String searchText){
        driver.findElement(SearchText).sendKeys(searchText);
   }
    public int Textcount(){
       return  driver.findElements(Count).size();
}
   public void getsearch(){
        driver.findElement(search).click();
   }
}

package Page1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By imageLocator=By.className("image");
    By AppHeading=By.className("app-heading");
    By AppDescription=By.className("form-description");
    By nameinputlocator=By.className("name-input");
    By commnentlocator=By.className("comment-input");
    By Addcommentbutton=By.className("add-button");
    By getcountertheading=By.className("heading");
    By getCounter=By.className("comments-count");
    By initialcharacter=By.className("initial-container");
    By usernamesLocator = By.className("username");
    By commentsLocator = By.className("comment");
    By likeButtonsLocator = By.xpath("//button[text() = 'Like']");
    By likedCommentsLocator = By.className("active");
    By deleteButtonsLocator = By.xpath("//img[@class = 'delete']/parent::button");
    By LikesCount=By.xpath("//button[text() = 'Like']");
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
   public WebElement findimage(){
       return driver.findElement(imageLocator);
    }
    public String getHeading(){
      return   driver.findElement(AppHeading).getText();
    }
    public String getDescription(){
        return driver.findElement(AppDescription).getText();
    }
    public void Entername(String name){
        driver.findElement(nameinputlocator).sendKeys(name);
    }
    public void Entercomment(String comment){
        driver.findElement(commnentlocator).sendKeys(comment);
    }
    public void ClickonAdd(){
        driver.findElement(Addcommentbutton).click();
    }
    public void AddNameComment(String name,String comment){
        Entername(name);
        Entercomment(comment);
        ClickonAdd();
    }
  public String getCountertext(){
        return driver.findElement(getcountertheading).getText();
  }
  public int  getNumbercounter(){
      return Integer.parseInt(driver.findElement(getCounter).getText());
  }
  public char Getinitialchar(){
        return driver.findElement(initialcharacter).getText().charAt(0);
  }
    public String getUsernameAt(int index) {
        return driver.findElements(usernamesLocator).get(index).getText();
    }
    public String getCommentAt(int index) {
        return driver.findElements(commentsLocator).get(index).getText();
    }
    public void clickLikeButtonAt(int index) {
        driver.findElements(likeButtonsLocator).get(index).click();
    }

    public int getLikedCommentsCount() {
        return driver.findElements(likedCommentsLocator).size();
    }

    public int clickFirstDeleteButton() {
        driver.findElements(deleteButtonsLocator).get(0).click();
        return 0;
    }

}

package Page2;

import Page1.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page1.LoginPage;

public class Homepage {
    WebDriver driver;
    LoginPage loginPage;
    int Commentcount;

    public Object[][] DataSet = {
            {"John", "Innovative and interconnected systems."},
            {"Alice", "Smart factories, improved efficiency."},
            {"Robert", "AI-powered automation, limitless potential."},
            {"Harry", "Data-driven decision-making, game-changer."},
            {"Bob", "IoT revolutionizing daily life."}
    };

    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qacommentsapp.ccbp.tech/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        Commentcount = 0;
    }

    @DataProvider
    public Object[][] CommentData() {
        return DataSet;
    }

    public void addCommentsData() {
        for (Object[] data : DataSet) {
            String name = String.valueOf(data[0]);
            String comment = String.valueOf(data[1]);
            loginPage.AddNameComment(name, comment);
            Commentcount++;
        }
    }

    @Test(priority = 1)
    public void CommentsAppUI() {
        Assert.assertTrue(loginPage.findimage().isDisplayed(), "App image is not displayed");
        Assert.assertEquals(loginPage.getHeading(), "Comments", "Heading text does not match");
        Assert.assertEquals(loginPage.getDescription(), "Say something about 4.0 Technologies", "Description text does not match");
        Assert.assertEquals(loginPage.getCountertext(), "0Comments", "Comments count text does not match");
    }

    @Test(priority = 2)
    public void commentcounter() {
        for (Object[] data : DataSet) {
            String name = String.valueOf(data[0]);
            String comment = String.valueOf(data[1]);
            loginPage.AddNameComment(name, comment);
            Commentcount++;
            int actual = loginPage.getNumbercounter();
            Assert.assertEquals(actual, Commentcount, "Comments count do not match");
        }
    }
    @Test(priority = 3,dataProvider = "CommentData")
    public void commentinitials(String name,String comment){
        loginPage.AddNameComment(name,comment);
        char initial=loginPage.Getinitialchar();
        Assert.assertEquals(initial,name.charAt(0),"Initial do not match");
    }
    @Test(priority = 4)
    public void testCommentsAndOrder() {
        addCommentsData();

        for (int i = 0; i < DataSet.length; i++) {
            Object data[] = DataSet[i];
            String name = String.valueOf(data[0]);
            String comment = String.valueOf(data[1]);
            Assert.assertEquals(loginPage.getUsernameAt(i), name, "Order does not match");
            Assert.assertEquals(loginPage.getCommentAt(i), comment, "Comment does not correspond to the username");
        }
    }
    @Test(priority = 5)
    public void testCommentLikes() {
        addCommentsData();

        int likesCount = 0;

        for (int i = 0; i < DataSet.length; i++) {
            loginPage.clickLikeButtonAt(i);

            likesCount++;

            Assert.assertEquals(loginPage.getLikedCommentsCount(), likesCount, "Likes count do not match");
        }
    }

    @Test(priority = 6)
    public void testCommentDeletes() {
        addCommentsData();
        for (int i = 0; i < DataSet.length; i++) {
            loginPage.clickFirstDeleteButton();
            Commentcount--;
            int actualCount = loginPage.getNumbercounter();
            Assert.assertEquals(actualCount, Commentcount, "Comments count do not match");
        }
    }


    @AfterMethod
        public void CloseBrowser () {

        //driver.quit();
        }


    }


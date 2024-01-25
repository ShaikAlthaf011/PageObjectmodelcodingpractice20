package JobbyAppTest4Home;

import JobbyAppTest4page.Jobspage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import JobbyAppTest4page.Jobspage;

public class JobspageTest {
    WebDriver driver;
    Jobspage jobspage;

    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        jobspage=new Jobspage(driver);

    }
    @DataProvider
    public Object[][]Dataset() {
        return new Object[][]{
                {"Devops Engineer", "9"},
                {"Backend Engineer", "11"},
                {"Frontend Engineer", "13"},
                {"Fullstack Developer", "6"},
                {"Data Scientist", "11"},
                {"ML Engineer", "10"}
        };
    }

    @Test(priority = 1)
    public void ProfilecontainerUl(){
        jobspage.EnterName();
        jobspage.Enterpassword();
        jobspage.Click();
        jobspage.GetURl();
        jobspage.clickfindjob();
        Assert.assertTrue(jobspage.visibileprofile(),"Profile image is not displayed");
        Assert.assertEquals(jobspage.heading(),"Rahul Attluri","Profile name does not match");
        Assert.assertEquals(jobspage.description(),"Lead Software Developer and AI-ML expert","Bio does not match");
    }
    @Test(priority = 2,dataProvider = "Dataset")
    public void Sucessfullsearch(String searchText,String expectedCount) throws Exception {
        jobspage.EnterName();
        jobspage.Enterpassword();
        jobspage.Click();
        jobspage.GetURl();
        jobspage.clickfindjob();
        jobspage.Textsearch(searchText);
        jobspage.getsearch();
        Thread.sleep(10000);
        Assert.assertEquals(jobspage.Textcount(),Integer.parseInt(expectedCount),"Jobs count does not match");

    }
    @Test(priority = 3)
    public void Unsucessfullsearch(){
        jobspage.EnterName();
        jobspage.Enterpassword();
        jobspage.Click();
        jobspage.GetURl();
        jobspage.clickfindjob();
        jobspage.textsearch();
        jobspage.searchboxclick();
        Assert.assertTrue(jobspage.imagevisibile(),"Jobs not found image is not displayed");
        Assert.assertEquals(jobspage.notfoundheading(),"No Jobs Found","Jobs not found heading does not match");
        Assert.assertEquals(jobspage.filter(),"We could not find any jobs. Try other filters.","Jobs not found description does not match");
    }
    @AfterMethod
    public void Closebrowser() {
        //driver.quit();
    }
}

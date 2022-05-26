package com.epam;

import com.epam.constants.ApplicationUnderTestConstants;
import com.epam.pagefactory.DocumentationPage;
import com.epam.pagefactory.HomePagePF;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class SeleniumStepDef {
    public WebDriver driver;
    HomePagePF homePagePF;
    DocumentationPage documentationPage;

    @Before
    public void launchBefore(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayush_Pandey\\Desktop\\chrome-101\\chromedriver.exe");
        driver=new ChromeDriver();
        homePagePF=new HomePagePF(driver);

    }
//    @Given("I launch the base url")
//    public void i_launch_the_base_url() {
//    }
    @Given("I launch the base url")
    public void iLaunchTheBaseUrl(){
        homePagePF.openApplicationUnderTest();
    }

    @When("I navigate to the Home page page and click on Documentation link on Home Page")
    public void i_navigate_to_the_home_page_page_and_click_on_documentation_link_on_home_page() {
        documentationPage=homePagePF.navigateToDocumentationPage();
    }

    @Then("I verify the header information of Downloads page")
    public void i_verify_the_header_information_of_downloads_page() {
        Assert.assertEquals(ApplicationUnderTestConstants.DOCUMENTATION,documentationPage.getDocumentationtext());
    }

    @When("i enter {string} in search field")
    public void iEnterInSearchField(String search){
        homePagePF.searchForInput(search);
    }
    @Then("click on search button to verify results")
    public void clickOnSearchButtonToVerifyResults(){

    }
    @When("i enter search data in search field")
    public void iEnterSearchDataInSearchField(List<String> search){
        homePagePF.searchForInput(search.get(0));
    }
}

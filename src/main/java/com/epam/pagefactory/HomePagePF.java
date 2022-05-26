package com.epam.pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.constants.ApplicationUnderTestConstants.APP_URL;

public class HomePagePF {
    WebDriver driver;

    @FindBy(partialLinkText = "Documentation")
    private WebElement documentation;

    @FindBy(xpath = "(//button)[2]")
    private WebElement search;

    @FindBy(id="docsearch-input")
    private WebElement searchVal;

    public HomePagePF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void openApplicationUnderTest(){
        driver.get(APP_URL);
    driver.manage().window().maximize();
    }
    public DocumentationPage navigateToDocumentationPage(){
        documentation.click();
        return new DocumentationPage(driver);
    }
    public HomePagePF searchForInput(String searchInput){
        search.click();
        searchVal.sendKeys(searchInput);
        return this;
    }
    public void clickEnterForSearch(){
        search.sendKeys(Keys.ENTER);
    }
}

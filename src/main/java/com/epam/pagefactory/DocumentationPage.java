package com.epam.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentationPage {
    WebDriver driver;
    @FindBy(xpath = "//li[@class='breadcrumb-item active']/a")
    private WebElement documentationText;

    public DocumentationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public  String getDocumentationtext(){
        return documentationText.getText();
    }
}

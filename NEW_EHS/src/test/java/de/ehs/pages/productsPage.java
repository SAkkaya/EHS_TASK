package de.ehs.pages;

import de.ehs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productsPage extends BasePage {
    public productsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//tbody/tr/th [text()='EHS - Home']")
    public WebElement home;

    @FindBy(xpath = "(//td//input)[3]")
    public WebElement listAllItems;

    @FindBy(xpath = "(//td//input)[2]")
    public WebElement find;

    @FindBy(xpath = "(//td//input)[1]")
    public WebElement searchBox;

    @FindBy(xpath = "((//tbody//tr)[2]//td)[2]//input")
    public WebElement open;

    @FindBy(xpath = "//tbody//tr/th")
    public WebElement ehsAllitems;

    @FindBy(xpath = "//tbody//tr//th")
    public WebElement ehsItem;

    @FindBy(xpath = "(//tbody//input)[1]")
    public WebElement name;

    @FindBy(xpath = "(//tbody//input)[2]")
    public WebElement material;

    @FindBy(xpath = "(//tbody//input)[3]")
    public WebElement manifacturer;

    @FindBy(xpath = "(//tbody//input)[4]")
    public WebElement retailPrice;

    @FindBy(xpath = "//tbody//tr//td//span")
    public WebElement productId;




}




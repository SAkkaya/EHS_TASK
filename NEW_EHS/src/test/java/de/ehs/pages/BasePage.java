package de.ehs.pages;

import de.ehs.utilities.BrowserUtils;
import de.ehs.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;



    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * @return page name:
     */
    public String getPageSubTitle() {

        return pageSubTitle.getText();
    }



    public void navigateToModule(String tab, String module) {

        String tabLocator = "(//a[normalize-space()='"+tab+"' and contains(@class,nav-top-link) ])[1]";
        String moduleLocator = "(//a[normalize-space()='"+module+"' and contains(@class,nav-top-link) ])[1]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }

}

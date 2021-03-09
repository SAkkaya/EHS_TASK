package de.ehs.step_definitions;

import de.ehs.pages.productsPage;
import de.ehs.utilities.BrowserUtils;
import de.ehs.utilities.ConfigurationReader;
import de.ehs.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class products_Step_Defs {

    private static final Logger LOG = LoggerFactory.getLogger(products_Step_Defs.class);

productsPage productsPage=new productsPage();



    @Given("I am landing on main page")
    public void i_am_landing_on_main_page() {
        String url = "file://"+System.getProperty("user.dir")+ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("I click List all Items button")
    public void i_click_List_all_Items_button() {
        productsPage.listAllItems.click();

    }

    @Then("I should be able to see all available products")
    public void i_should_be_able_to_see_all_available_products() {
        String subTitle="EHS - All Items";
        Assert.assertEquals("Verifying of all available products",productsPage.ehsAllitems.getText(),subTitle);

    }

    @When("I click open button of any product")
    public void i_click_open_button_of_any_product() {
        BrowserUtils.waitFor(2);
        productsPage.open.click();
        String expectedValue="EHS - Item";
        String actualValue=productsPage.ehsItem.getText();
        Assert.assertEquals("Verify the product info window is available",expectedValue,actualValue);

    }

    @Then("I should be able to see detailed information")
    public void i_should_be_able_to_see_detailed_information() {
        String expectedName="EHS Item 1";
        String expectedMaterial="Bronze";
        String expectedManufacturer="Boston Item LLC";
        String expectedPrice="$53.50";

        Assert.assertEquals("Verify name:",productsPage.name.getAttribute("value"),expectedName);
        Assert.assertEquals("Verify Material:",productsPage.material.getAttribute("value"),expectedMaterial);
        Assert.assertEquals("Verify Manifacturer:",productsPage.manifacturer.getAttribute("value"),expectedManufacturer);
        Assert.assertEquals("Verify Price:",productsPage.retailPrice.getAttribute("value"),expectedPrice);

    }

    @When("I enter specific product information in the search box")
    public void i_enter_specific_product_information_in_the_search_box() {
       productsPage.searchBox.sendKeys("EHS Item 1");
       BrowserUtils.waitFor(2);

    }

    @When("I click find button")
    public void i_click_find_button() {
        productsPage.find.click();
        BrowserUtils.waitFor(2);
    }

    @Then("I should be able to see detailed information of that product")
    public void i_should_be_able_to_see_detailed_information_of_that_product() {
        String expectedProductId=productsPage.productId.getAttribute("id");
        BrowserUtils.waitFor(2);
        LOG.info("Product is entered");
        Assert.assertFalse("Verify detailed information available:",expectedProductId.contains("Not Found"));


    }

}

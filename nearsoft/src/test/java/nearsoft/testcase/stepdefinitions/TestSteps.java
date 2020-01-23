package nearsoft.testcase.stepdefinitions;

import nearsoft.general.Setup;
import nearsoft.testcase.pageobjects.TestPageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSteps {
    private TestPageObject testPageObject;

    public TestSteps() {
        testPageObject = new TestPageObject();

    }

    public void userOpenSystem() {
        Setup.openUrl("https://www.expedia.com/");
    }

    public void userCreateNewSearch() {
        testPageObject.getElementBy(By.id("tab-flight-tab-hp")).click();
        //flight-type-one-way-hp-flight
        testPageObject.getElementBy(By.id("flight-type-one-way-label-hp-flight")).click();
        //flight-destination-hp-flight
        testPageObject.getElementBy(By.id("flight-origin-hp-flight")).sendKeys("Los Angeles, CA, United States (LAX)");
        testPageObject.getElementBy(By.id("flight-destination-hp-flight")).sendKeys("New York, NY, United States (JFK)");
        Actions actions = new Actions(Setup.getDriver());
        WebElement el = testPageObject.getElementBy(By.xpath("//label/input[@id='flight-departing-single-hp-flight']"));
        el.sendKeys("03/03/2020");
        el.sendKeys(Keys.ENTER);

    }

    public void systemOpenPageSearch() {
        Setup.getWait().waitUntilElementAppear(By.xpath("//li[@data-test-id='offer-listing']"), 5);


    }

    private List<Integer> systemShowPriceList() {
        List<WebElement> listEl = testPageObject.getElementsBy(By.xpath("//span[@data-test-id='listing-price-dollars']"));
        List<Integer> listPrices = new ArrayList<>();
        for (WebElement el : listEl
        ) {
            listPrices.add(Integer.parseInt(el.getText().replace("$", "")));

        }
        return listPrices;
    }

    public void systemShowPrice() {
        Setup.setKeyValueStore("listPrices", systemShowPriceList());
    }

    public void userSortBy(String arg0) {

        testPageObject.getElementBy(By.xpath("//select[@id='sortDropdown']/option[@data-opt-id='sort-PRICE_DECREASING']")).click();
        systemOpenPageSearch();
    }

    public void priceSorting() {
        List<Integer> listPrices = systemShowPriceList();
        List<Integer> listPricesOld = (List<Integer>) Setup.getValueStore("listPrices");
        // Collections.sort(listPricesOld);
        Collections.reverse(listPricesOld);
        if (listPrices.size() != listPricesOld.size()) {
            throw new IllegalArgumentException("The list prices have not the same sizes.");
        }
        Assert.assertTrue("The list price is not sorting.", listPrices.equals(listPricesOld));


    }
}

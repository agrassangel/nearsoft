package nearsoft.testcase.stepdefinitions;

import cucumber.api.java.en.*;

public class TestStepDefinitions {
    private TestSteps testSteps;

    public TestStepDefinitions() {
        testSteps = new TestSteps();

    }

    @Given("User open system")
    public void userOpenSystem() {
        testSteps.userOpenSystem();
    }

    @When("user create a new search")
    public void userCreateNewSearch() {
        testSteps.userCreateNewSearch();
    }
    @When("system show price")
    public void systemShowPrice() {
        testSteps.systemShowPrice();
    }
    @When("system open new page search")
    public void systemOpenPageSearch() {
        testSteps.systemOpenPageSearch();
    }


    @When("The price are correct sorting")
    public void priceSorting() {
        testSteps.priceSorting();
    }
//select[@id='sortDropdown']//
    @And("user sort by {string}")
    public void userSortBy(String arg0) {
        testSteps.userSortBy(arg0);
    }
}

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.junit.Assert;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class FirstTest {
//    private ArrayList<Integer> newArray;
//    ArrayList<Integer> clone=new ArrayList<>();
//
//    public FirstTest() {
//        newArray = new ArrayList<>();
//
//    }
//
//    @Given("Initialize")
//    public void initializeArray() {
//        newArray.add(5);
//        newArray.add(8);
//        newArray.add(1);
//        newArray.add(6);
//        newArray.add(2);
//    }
//
//    @Given("Execute")
//    public void sortArray() {
//        Collections.sort(newArray);
//    }
//
//    @When("system sort")
//    public void systemSort() {
//
//        Collections.copy(clone,newArray);
//        Collections.sort(clone);
//    }
//
//    @Then("array is sorting")
//    public void arrayIsSorting() {
//        Assert.assertTrue(clone.equals(newArray));
//    }
//
//    @Given("User open system")
//    public void userOpenSystem() {
//    }
//}

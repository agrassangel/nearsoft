package nearsoft.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObject {

    protected WebDriver driver;


    public PageObject() {
        this.driver = Setup.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getElementBy(By by) {
        return Setup.getWait().visibilityOfElement(by, "");
    }


    public List<WebElement> getElementsBy(By by) {
        return this.driver.findElements(by);
    }

}

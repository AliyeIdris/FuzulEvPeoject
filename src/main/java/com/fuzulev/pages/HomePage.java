package com.fuzulev.pages;

import com.fuzulev.utilities.FunctionUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

/**
 * @author : user
 * @created : 21.12.2023,00:26
 * @Email :aliyeidiris@gmail.com
 **/
public class HomePage {
    WebDriver driver;
    FunctionUtility functionUtility;
    Logger logger;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionUtility=new FunctionUtility(driver);
        logger=Logger.getLogger(HomePage.class.getName());
    }
    @FindBy(xpath = "//h6[text()='Real Estate']")
    WebElement homepageTitle;
    @FindBy(xpath = "//input[@placeholder='Ara...']")
    WebElement searchField;
    @FindBy(css = "svg[data-testid='ArrowBackSharpIcon']")
    WebElement backwardIcon;
    @FindBy(css = "svg[data-testid='ArrowForwardSharpIcon']")
    WebElement forwardIcon;
    @FindBy(xpath = "//div/label[text()='Minumum']/following-sibling::div/input[@id='outlined-basic']")
    WebElement minimumBoundField;
    @FindBy(xpath = "//div/label[text()='Maximum']/following-sibling::div/input[@id='outlined-basic']")
    WebElement maximumBoundField;
    @FindBy(xpath = "//span[text()='Satılık']/preceding-sibling::span/input[@type='checkbox']")
    WebElement satilikCheckbox;
    @FindBy(xpath = "//span[text()='Kiralık']/preceding-sibling::span/input[@type='checkbox']")
    WebElement kiralikCheckbox;
    @FindBy(xpath = "//span[text()='Günlük']/preceding-sibling::span/input[@type='checkbox']")
    WebElement günlükCheckbox;
    @FindBy(xpath = "//span[text()='Eşyalı']/preceding-sibling::span/input[@type='checkbox']")
    WebElement esyaliCheckbox;
    @FindBy(xpath ="//span[text()='Eşyasız']/preceding-sibling::span/input[@type='checkbox']" )
    WebElement esyasizCheckbox;
    @FindAll(
            @FindBy(xpath = "//span[contains(text(),'+ ')]/preceding-sibling::span/input[@type='checkbox']")
    )
    List<WebElement> roomNumberOptions;
    @FindAll(
            @FindBy(xpath = "//span[contains(text(),' Kat')]/preceding-sibling::span/input[@type='checkbox']")
    )
    List<WebElement> floorNumberOptions;
    @FindAll(
            @FindBy(xpath = "//span[contains(text(),'-') or contains(text(),'> 20') or text()='0' or text()='1' or text()='2' or text()='3' or text()='4' or text()='5']/preceding-sibling::span/input[@type='checkbox']")
    )
    List<WebElement> buildingAgeOptions;

    public boolean verifyHomepage(){
        functionUtility.waitForElementVisible(homepageTitle);
        logger.info("User is on the application homepage");
        return homepageTitle.isDisplayed();
    }
    public void entePropertyName(String name){
        functionUtility.waitForElementVisible(searchField);
        searchField.sendKeys(name);
    }
    public void verifySearchResult(){
        logger.info("Property searched as.....");
    }
    public void applyFiltersToTheSearch(String minimumBound,String maximumBound) {
        functionUtility.waitForElementVisible(forwardIcon);
        for (int i = 0; i < 5; i++) {
            forwardIcon.click();
        }
        functionUtility.waitForElementVisible(backwardIcon);
        for (int i = 0; i < 3; i++) {
            backwardIcon.click();
        }
        functionUtility.waitForElementVisible(minimumBoundField);
        minimumBoundField.sendKeys(minimumBound);
        functionUtility.waitForElementVisible(maximumBoundField);
        maximumBoundField.sendKeys(maximumBound);
        //functionUtility.waitForElementVisible(satilikCheckbox);
        //satilikCheckbox.click();
        kiralikCheckbox.click();
        //günlükCheckbox.click();
        functionUtility.waitForElementVisible(esyaliCheckbox);
        esyaliCheckbox.click();
        for(int i=0;i<3;i++){
        roomNumberOptions.get(new Random().nextInt(roomNumberOptions.size())).click();
        }
        for (int i=0; i<floorNumberOptions.size();i++){
            floorNumberOptions.get(i).click();
        }
        for(int i=0;i<buildingAgeOptions.size();i++){
            buildingAgeOptions.get(new Random().nextInt(roomNumberOptions.size())).click();
            if (i==4)
                break;
        }

    }
    public void verifyFilterAction(){
        logger.info("Filters are applied...");
    }
}

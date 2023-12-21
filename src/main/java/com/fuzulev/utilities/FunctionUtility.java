package com.fuzulev.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * @author : user
 * @created : 21.12.2023,00:33
 * @Email :aliyeidiris@gmail.com
 **/
public class FunctionUtility {
    WebDriver driver;

    public FunctionUtility(WebDriver driver) {
        this.driver = driver;
    }
    int timeout=Integer.parseInt(readConfig("timeout"));
    public static String readConfig(String key){
        final String configPath="config.properties";
        Properties properties =new Properties();
        try {
            properties.load(new FileInputStream(configPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }

    public void waitForElementVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

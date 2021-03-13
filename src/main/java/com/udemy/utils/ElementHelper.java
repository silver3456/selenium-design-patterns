package com.udemy.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementHelper  {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

//    public boolean selectElementWithOffset(WebElement element) {
//        Actions actions = new Actions(driver);
//
//        for (int x = 0; x < element.getSize().getWidth(); x++) {
//            for (int y = 0; y < element.getSize().getHeight(); y++) {
//                actions.moveToElement(element).moveByOffset(x, y).click().build().perform();
//                if (element.isSelected()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static boolean clickOnElementWithOffset(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);

        for (int x = 0; x < element.getSize().getWidth(); x++) {
            for (int y = 0; y < element.getSize().getHeight(); y++) {
            actions.moveToElement(element).moveByOffset(x, y).click().build().perform();
                if (element.isEnabled()) {
                    return true;
                }
            }
        }
        return false;
    }

//    public void waitForElemClickable(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }


}

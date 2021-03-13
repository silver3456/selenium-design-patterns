package com.udemy.seleniumdesign.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DissmissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;
    private final WebDriver driver;
    private final WebDriverWait wait;


    public DissmissalAlertValidator(WebDriver driver, final WebElement element) {
        this.dismissalAlert = element;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        refresh();
    }


    @Override
    public boolean validate() {
        boolean result1 = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean result2 = waitForElementToBeInvisible(this.dismissalAlert);
        return result1 && result2;
    }

        private boolean waitForElementToBeInvisible(WebElement element) {
        try {
            element.isDisplayed();
        }catch (NoSuchElementException ex) {
            return true;
        }
        return false;
    }

    @Override
    public void refresh() {
        waitForAjax(driver);
    }

    public static boolean waitForAjax(WebDriver driver) {
        boolean readyState = false;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 0;
        while (!readyState && i < 2) {

            try {
                readyState = js.executeScript("return document.readyState").equals("complete");
                if (!readyState) Uninterruptibles.sleepUninterruptibly(200, TimeUnit.MILLISECONDS);
                i++;

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
        return readyState;
    }
}

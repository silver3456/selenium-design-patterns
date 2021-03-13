package com.udemy.seleniumdesign.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;
    private final WebDriverWait wait;
    private final WebDriver driver;

    public NotificationValidator(WebDriver driver, final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        refresh();
    }


    @Override
    public boolean validate() {
        waitForElemClickable(this.button);
        this.button.click();
        boolean appearanceState = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean dissapearanceState = this.notification.isDisplayed();
        return appearanceState && (!dissapearanceState);
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

    public void waitForElemClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}

package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DissmissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;


    public DissmissalAlertValidator(final WebElement element) {
        this.dismissalAlert = element;
    }


    @Override
    public boolean validate() {
        boolean result1 = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean result2 = this.dismissalAlert.isDisplayed();
        return result1 && (!result2);
    }
}

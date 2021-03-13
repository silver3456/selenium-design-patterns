package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    @FindBy(css = "button.tst1.btn.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "button.tst2.btn.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "button.tst3.btn.btn-success")
    private WebElement successBtn;

    @FindBy(css = "button.tst4.btn.btn-danger")
    private WebElement dangerBtn;

    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement danderAlert;

    //dismissal alert
    @FindBy(css = "div.col-lg-4.col-md-12:nth-child(2) div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.col-lg-4.col-md-12:nth-child(2) div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.col-lg-4.col-md-12:nth-child(2) div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.col-lg-4.col-md-12:nth-child(2) div.alert-warning")
    private WebElement dismissWarningAlert;


    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");

    }

    public List<ElementValidator> getElementValidators() {

        return Arrays.asList(
                //notification
                new NotificationValidator(driver,infoBtn, infoAlert),
                new NotificationValidator(driver,successBtn, successAlert),
                new NotificationValidator(driver,warnBtn, warnAlert),
                new NotificationValidator(driver,dangerBtn, danderAlert),
                //dismiss
                new DissmissalAlertValidator(driver, dismissInfoAlert),
                new DissmissalAlertValidator(driver, dismissSuccessAlert),
                new DissmissalAlertValidator(driver, dismissWarningAlert),
                new DissmissalAlertValidator(driver, dismissDangerAlert)
        );
    }

}

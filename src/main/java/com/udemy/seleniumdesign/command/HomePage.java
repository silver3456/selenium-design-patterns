package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    @FindBy(css = "button.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "button.button-box button.btn-warning")
    private WebElement warnBtn;

    //buttons
    @FindBy(css = "button.button-box button.success")
    private WebElement successBtn;

    @FindBy(css = "button.button-box button.danger")
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
    @FindBy(css = "div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.alert-warning")
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
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(dangerBtn, danderAlert),
                //dismiss
                new DissmissalAlertValidator(dismissInfoAlert),
                new DissmissalAlertValidator(dismissSuccessAlert),
                new DissmissalAlertValidator(dismissWarningAlert),
                new DissmissalAlertValidator(dismissDangerAlert)
        );
    }

}

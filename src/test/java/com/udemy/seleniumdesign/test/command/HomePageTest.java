package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setPages() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }

//    @Test
//    public void homePageTest() {
//        this.homePage.goTo();
//
//        for (ElementValidator ev : this.homePage.getElementValidators()) {
//            boolean result = ev.validate();
//            Assert.assertTrue(result);
//        }
//    }
}


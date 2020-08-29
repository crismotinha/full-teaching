package com.fullteaching.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Teacher {
    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="log-in-btn")
    private WebElement loginButtonPopUp;

    @FindBy(xpath = "/html/body/app/div/header/navbar/div/nav/div/ul/li[2]/a")
    private WebElement loginButtonPage;



    public void logIn() throws InterruptedException {
        loginButtonPage.click();

        email.sendKeys("teacher@gmail.com");
        password.sendKeys("pass");

        loginButtonPopUp.click();
    }

}

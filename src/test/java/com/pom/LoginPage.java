package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebElement userName(WebDriver driver) {
		return driver.findElement(By.id("user-name"));
	}
	
	public WebElement password(WebDriver driver) {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.name("login-button"));
	}

}

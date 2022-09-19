package com.utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.base.BaseClass;

public class SeleniumWaitUtils {

	public WebElement doWaitForElement(WebElement element, WebDriver driver) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofMillis(5L))
				.ignoring(NoSuchElementException.class);;
        WebElement selectorObj = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
        return selectorObj;
	}
	
	
	
	public By getByElement(WebElement we) {
		    // By format = "[foundFrom] -> locator: term"
		    // see RemoteWebElement toString() implementation
		    String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
		    String locator = data[0];
		    String term = data[1];

		    switch (locator) {
		    case "xpath":
		        return By.xpath(term);
		    case "css selector":
		        return By.cssSelector(term);
		    case "id":
		        return By.id(term);
		    case "tag name":
		        return By.tagName(term);
		    case "name":
		        return By.name(term);
		    case "link text":
		        return By.linkText(term);
		    case "class name":
		        return By.className(term);
		    }
		    return (By) we;
		
	}

}

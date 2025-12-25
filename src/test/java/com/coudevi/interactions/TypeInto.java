package com.coudevi.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TypeInto implements Interaction {
    private final By locator;
    private final String value;

    public TypeInto(By locator, String value) {
        this.locator = locator;
        this.value = value;
    }

    public static TypeInto element(By locator, String value) {
        return new TypeInto(locator, value);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        var element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}

package com.buildtrack.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class WaitTime {


    public    String GetCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        return sdf.format(new Date());
    }


    public FluentWait<WebDriver> createFluentWait(WebDriver driver,Duration timeout, Duration pollingInterval) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(pollingInterval)
                .ignoring(StaleElementReferenceException.class).ignoring(ElementClickInterceptedException.class)
                .ignoring(NoSuchElementException.class).ignoring(TimeoutException.class).ignoring(JsonException.class);

    }
}

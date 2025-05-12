package com.saucedemo.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverFactory {
//    public static WebDriver getDriver() {
//
//        String driverPath = ConfigReader.getProperty("webdriver.chrome.driver");
//        System.setProperty("webdriver.chrome.driver", driverPath.replace("\\", File.separator));
//        return new ChromeDriver();
//    }

    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
//            String driverPath = ConfigReader.getProperty("webdriver.chrome.driver");
//            System.setProperty("webdriver.chrome.driver", driverPath.replace("\\", File.separator));
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static String takeScreenshot(String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/target/screenshots/" + screenshotName + dateName + ".png";
        File destination = new File(destinationPath);
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationPath;
    }

}

package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.FileUtil;

public class TestChrome {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:/chromedriver.exe");
        final ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }

    @After
    public final void tearDown() {
        this.driver.close();
        this.driver.quit();
    }

    @Test
    public void test() {
        System.out.println("hello");
        this.driver.get("http://www.google.com");
        final WebElement element = this.driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        final File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        FileUtil.I.safeFile("D:/test.png", srcFile);

        System.out.println("Page title is: " + this.driver.getTitle());
        (new WebDriverWait(this.driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page title is: " + this.driver.getTitle());
    }

    //    @Ignore
    @Test
    public void test1() {
        System.out.println("hello2");
        this.driver.get("http://www.google.com");
        final WebElement element = this.driver.findElement(By.name("q"));
        element.sendKeys("baha");
        element.submit();
        System.out.println("Page title is: " + this.driver.getTitle());

        final File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        //        (new WebDriverWait(this.driver, 10)).until(new ExpectedCondition<Boolean>() {
        //            public Boolean apply(final WebDriver d) {
        //                return d.getTitle().toLowerCase().startsWith("cheese!");
        //            }
        //        });

        FileUtil.I.safeFile("D:/test1.png", srcFile);
        System.out.println("Page title is: " + this.driver.getTitle());
    }

}

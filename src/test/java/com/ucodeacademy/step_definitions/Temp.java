package com.ucodeacademy.step_definitions;

import com.ucodeacademy.utilities.ConfigReader;
import com.ucodeacademy.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Temp {

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get("https://www.demoblaze.com/index.html");

        WebElement samsung = Driver.getDriver().findElement(By.xpath("//div//a[text()='Samsung galaxy s6']"));
        samsung.click();

        WebElement addToCart = Driver.getDriver().findElement(By.xpath("//div//a[text()='Add to cart']"));
        addToCart.click();
        Thread.sleep(2000);

        Driver.getDriver().switchTo().alert().accept();

        Thread.sleep(2000);

        WebElement cart = Driver.getDriver().findElement(By.xpath("//a[@id='cartur']"));
        cart.click();

        Thread.sleep(5000);
        Driver.quitDriver();

    }
}

package com.ucodeacademy.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver(){

    }

//    private static WebDriver driver;
//
//    public static WebDriver getDriver(){
//
//        if (driver == null){
//
//
//            String browserName = ConfigReader.getProperty("browser");
//            browserName = browserName.toLowerCase();
//
//            switch (browserName){
//
//                case "chrome":
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    driver = new FirefoxDriver();
//                    break;
//                case "safari":
//                    driver = new SafariDriver();
//                    break;
//                case "chrome-headless":
//
//                   ChromeOptions options = new ChromeOptions();
//                   options.addArguments("--headless");
//
//                   driver = new ChromeDriver(options);
//                   break;
//                case "edge":
//                    driver = new EdgeDriver();
//                    break;
//                default:
//                    System.out.println("Invalid browser name");
//
//
//            }
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        }
//        return driver;
//
//    }
//
//
//    public static void quitDriver(){
//        if (driver !=null){
//            driver.quit();
//            driver = null;
//        }
//    }


    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (threadLocalDriver.get() == null){

            String browserName = ConfigReader.getProperty("browser");

            switch (browserName){
                case "chrome":
                    threadLocalDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    threadLocalDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadLocalDriver.set(new EdgeDriver());
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    threadLocalDriver.set(new ChromeDriver(options));
                    break;
                case "remote":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome"); // to change choose which browser to run tests in
                    capabilities.setPlatform(Platform.MAC);

                    try {
                        URL url = new URL("http://localhost:4444/wd/hub");
                        threadLocalDriver.set(new RemoteWebDriver(url, capabilities));

                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        throw new RuntimeException("Remote URL was not found");
                    }
                    break;

                default:
                   throw new RuntimeException("Invalid browser name");
            }


        }

        WebDriver driver = threadLocalDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        return driver;

    }

    public static void quitDriver(){
        WebDriver driver = threadLocalDriver.get();

        if (driver !=null){
            driver.quit();

            threadLocalDriver.remove();
        }
    }


}

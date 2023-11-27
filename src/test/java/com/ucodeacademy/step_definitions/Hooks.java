package com.ucodeacademy.step_definitions;


import com.ucodeacademy.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

//    @Before(order = 2)
//    public void beforeEachScenario(){
//        System.out.println("Before each scenario from hooks class 1");
//    }
//
//    @Before(order = 1)
//    public void beforeEachScenario2(){
//        System.out.println("Before each scenario from hooks class 2 ");
//    }
//
//    @Before(value = "@abc")
//    public void specificScenario(){
//        System.out.println("I run only for scenario that has @abc tag");
//    }
//
//
//
//    @After
//    public void afterEachScenario(){
//        System.out.println("After each scenario from hooks class");
//    }
//
//
//    @BeforeStep
//    public void beforeEachStep(){
//        System.out.println("Before each step in scenario");
//    }
//
//    @AfterStep
//    public void afterEachStep(){
//        System.out.println("After each step in scenario");
//    }



    @After // Take a screenshot of failed scenarios only
    public void failedScreenshot(Scenario scenario){

        if (scenario.isFailed()){
            byte [] screenshot = ( (TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());

        }
  }

  @Before
    public void screenshots(Scenario scenario){
        byte [] s = ( (TakesScreenshot) Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
        scenario.attach(s, "image/png",scenario.getName());
  }



}

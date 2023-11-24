package com.ucodeacademy.utilities;

import org.junit.Test;

public class Temp {

    @Test
    public void simpleTest(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Driver.quitDriver();
    }
}

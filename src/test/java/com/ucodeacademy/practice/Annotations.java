package com.ucodeacademy.practice;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Annotations {

            // JUnit 4 vs JUnit 5 Annotations:

    // @Test: Denotes a method as a test method -> JUnit 4
    // @Test: Denotes a method as a test method -> JUnit 5

    // @Before: Executes/runs before each test method -> JUnit 4
    // @BeforeEach: Executes/runs before each test method -> JUnit 5

    // @After: Executes/runs after each test method -> JUnit 4
    // @AfterEach: Executes/runs after each test method -> JUnit 5

    // @BeforeClass: Executes/runs once before all test methods in the class -> JUnit 4
    // @BeforeAll: Executes/runs once before all test methods in the class -> JUnit 5

    // @AfterClass: Executes/runs once after all test methods in the class -> JUnit 4
    // @AfterAll: Executes/runs once after all test methods in the test class -> JUnit 5

    // @Ignore: Marks a test method or class as ignored. The test runner will not execute them -> JUnit 4
    // @Disabled: Marks a test method or class as disabled. The test runner will not execute them -> JUnit 5




    @Test
    public void test1(){
        System.out.println("Test 1");
    }



    @Before
    public void test2(){
        System.out.println("Test 2");
        Assert.assertTrue(true);
    }






}

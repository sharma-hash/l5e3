package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        /*WebDriverManager.chromedriver().setup(); //Set up chrome driver
        WebDriver driver = new ChromeDriver(); //Get a handle of Chrome Driver

        driver.get("http://localhost:8080/animal");*/
        /*WebElement animalTextElement = driver.findElement(By.id("animalText"));
        animalTextElement.sendKeys("Dog");
        WebElement adjectiveElement = driver.findElement(By.id("adjective"));
        adjectiveElement.sendKeys("Barking");

        for(int i =0; i < 5; i++) {
            driver.findElement(By.tagName("input")).click();
        }*/

        /*WebElement inputField = driver.findElement(By.id("animalText"));
        inputField.sendKeys("Dog");
        inputField = driver.findElement(By.id("adjective"));
        inputField.sendKeys("Barking");
        for(int i =0; i < 5; i++) {
            inputField.submit();
        }

        driver.wait(5000);
        driver.quit();*/

        //start the driver, open chrome to our target url
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");

        //find the fields we want by id and fill them in
        WebElement inputField = driver.findElement(By.id("animalText"));
        inputField.sendKeys("Manatee");

        inputField = driver.findElement(By.id("adjective"));
        inputField.sendKeys("Whirling");

        //the fields don’t clear on submit for our simple app, so just submit it 5 times
        for(int i = 0; i < 5; i++) {
            inputField.submit();

            List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
            System.out.println("trainingResults.size() = " + trainingResults.size());
        }

        // then get the element by the class conclusionMessage and print it
        WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
        System.out.println("conclusionResult.getText() = " + conclusionResult.getText());

        Thread.sleep(5000);
        driver.quit();


    }
}

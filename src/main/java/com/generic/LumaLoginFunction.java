package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LumaLoginFunction {
	
	public void getLogin(){
		//open a browser
		WebDriver driver= DriverManager.getBrowser("edge");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver,3);
		driver.navigate().to(Constants.URL);
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver,  pf.getSigninBtn().get(0), 3);
		Highlighter.getColor(driver, pf.getSigninBtn().get(0), "red");
		pf.getSigninBtn().get(0).click();
		Highlighter.getColor(driver, pf.getEmail(), "green");

		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		Highlighter.getColor(driver, pf.getPassword(), "blue");

		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		Highlighter.getColor(driver, pf.getSecondSigninBtn(), "yellow");

		pf.getSecondSigninBtn().click();
		
		
		//validation
		Highlighter.getColor(driver, pf.getWelcome().get(0), "orange");
		boolean status =pf.getWelcome().get(0).isDisplayed();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		

	}	
	}	
		
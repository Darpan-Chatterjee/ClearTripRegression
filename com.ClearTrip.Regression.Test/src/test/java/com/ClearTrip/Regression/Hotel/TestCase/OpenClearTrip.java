package com.ClearTrip.Regression.Hotel.TestCase;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ClearTrip.Regression.UtilityMethods.GlobalVariable;
import com.ClearTrip.Regression.UtilityMethods.UtilityMethod;

public class OpenClearTrip {

	public String url,screenshotPath;
	public String AutomationConfigPath="..\\com.ClearTrip.Regression.Test\\src\\test\\resources\\AutomationConfig.Properties";
	UtilityMethod util=new UtilityMethod();

	public OpenClearTrip() throws Exception
	{
		Properties prop=util.LoadProperty(AutomationConfigPath);
		url=prop.getProperty("url");
		screenshotPath=prop.getProperty("screenshotPath");
	}

	@BeforeMethod
	public void Setup()
	{
		GlobalVariable.driver=util.openURL("Chrome", url);
	}

	@Test
	public void OpenClearTripPage() throws IOException, InterruptedException
	{
		String CurrTitle=GlobalVariable.driver.getTitle();
		if(CurrTitle.contains("Cleartrip"))
		{
			System.out.println("ClearTrip Page is Opened");
			util.Screenshot(screenshotPath,"OpenClearTripSite");
		}
	}
	
	@AfterMethod
	public void Teardown()
	{
		GlobalVariable.driver.close();
	}

}

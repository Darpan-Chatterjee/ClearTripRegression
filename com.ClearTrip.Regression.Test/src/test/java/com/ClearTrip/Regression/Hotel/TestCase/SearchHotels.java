package com.ClearTrip.Regression.Hotel.TestCase;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ClearTrip.Regression.Hotel.Page.ClearTripLandingPage;
import com.ClearTrip.Regression.Hotel.Page.HotelSearchPage;
import com.ClearTrip.Regression.UtilityMethods.GlobalVariable;
import com.ClearTrip.Regression.UtilityMethods.UtilityMethod;

public class SearchHotels {
	
	public String url,screenshotPath,TestDataPath;
	public String AutomationConfigPath="..\\com.ClearTrip.Regression.Test\\src\\test\\resources\\AutomationConfig.Properties";
	UtilityMethod util=new UtilityMethod();

	public SearchHotels() throws Exception
	{
		Properties prop=util.LoadProperty(AutomationConfigPath);
		url=prop.getProperty("url");
		screenshotPath=prop.getProperty("screenshotPath");
		TestDataPath=prop.getProperty("TestDataPath");
	}
	
	@BeforeMethod
	public void Setup()
	{
		GlobalVariable.driver=util.openURL("Chrome", url);
	}

	@Test
	public void SearchHotelPage() throws Exception
	{
		String loc1,loc2,startDt,endDt,personName,child,age;
		loc1=util.SearchExcel(TestDataPath,"SearchHotels","Location part 1");
		loc2=util.SearchExcel(TestDataPath,"SearchHotels","Location part 2");
		startDt=util.SearchExcel(TestDataPath,"SearchHotels","From Date");
		endDt=util.SearchExcel(TestDataPath,"SearchHotels","To Date");
		personName=util.SearchExcel(TestDataPath,"SearchHotels","Person Detail");
		child=util.SearchExcel(TestDataPath,"SearchHotels","Child");
		age=util.SearchExcel(TestDataPath,"SearchHotels","Age");
		
		String CurrTitle1=GlobalVariable.driver.getTitle();
		if(CurrTitle1.contains("Cleartrip"))
		{
			ClearTripLandingPage ClearTripLandingPageObj = new ClearTripLandingPage();
			ClearTripLandingPageObj.clickHotel();
			String CurrTitle2=GlobalVariable.driver.getTitle();
			if(CurrTitle2.contains("Book Cheap Hotels"))
			{
				System.out.println("Search Hotel Page is Opened");
				util.Screenshot(screenshotPath,"SearchHotelSite");
				util.waitInSecond(2);
				HotelSearchPage srchObj = new HotelSearchPage();
				srchObj.HotelLocation(loc1, loc2);
				srchObj.datePicker(startDt, endDt);
				srchObj.personDetails(personName,child,age);
				srchObj.ClickSearch();

				List<WebElement> wb = GlobalVariable.driver.findElements(By.xpath("//h2[@class='truncate span span24']/a[@class='hotelDetails']"));
				System.out.println("Hotels Name Are :");
				for(WebElement el : wb)
				{
					System.out.println(el.getText());
				}
			}
		}
		
	}
	
	@AfterMethod
	public void Teardown()
	{
		GlobalVariable.driver.close();
	}

}

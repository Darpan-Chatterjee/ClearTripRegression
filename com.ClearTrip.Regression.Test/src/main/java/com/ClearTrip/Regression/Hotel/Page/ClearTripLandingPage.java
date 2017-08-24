package com.ClearTrip.Regression.Hotel.Page;

import java.util.Properties;

import com.ClearTrip.Regression.UtilityMethods.UtilityMethod;

public class ClearTripLandingPage {
	
	public String hotelLink;
	public String ConfigPath="..\\com.ClearTrip.Regression.Test\\src\\main\\resources\\Page Map\\LandingPage.Properties";
	UtilityMethod util=new UtilityMethod();
	
	public ClearTripLandingPage() throws Exception
	{
		Properties prop=util.LoadProperty(ConfigPath);
		hotelLink=prop.getProperty("hotelLink");
	}
	
	public void clickHotel() throws InterruptedException
	{
		try 
		{
			util.getLocator(hotelLink).click();
			util.waitInSecond(2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

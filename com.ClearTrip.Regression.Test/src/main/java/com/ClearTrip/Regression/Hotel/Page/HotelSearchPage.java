package com.ClearTrip.Regression.Hotel.Page;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.ClearTrip.Regression.UtilityMethods.UtilityMethod;

public class HotelSearchPage {
	
	public String LocationField,LocationValue,datePickerctrl,dtSelect,PersonDrp,childDrp,ageDrp,searchBtn,hotelsLink;
	public String ConfigPath="..\\com.ClearTrip.Regression.Test\\src\\main\\resources\\Page Map\\SearchPage.Properties";
	UtilityMethod util=new UtilityMethod();
	
	public HotelSearchPage() throws Exception
	{
		Properties prop=util.LoadProperty(ConfigPath);
		LocationField=prop.getProperty("LocationField");
		LocationValue=prop.getProperty("LocationValue");
		datePickerctrl=prop.getProperty("datePickerctrl");
		dtSelect=prop.getProperty("dtSelect");
		PersonDrp=prop.getProperty("PersonDrp");
		childDrp=prop.getProperty("childDrp");
		ageDrp=prop.getProperty("ageDrp");
		searchBtn=prop.getProperty("searchBtn");
		hotelsLink=prop.getProperty("hotelsLink");
	}
	
	public void HotelLocation(String loc1,String loc2) throws InterruptedException
	{
		try 
		{
			util.getLocator(LocationField).sendKeys(loc1);
			util.waitInSecond(2);
			util.getLocator(LocationValue+loc2+"')]").click();
			util.waitInSecond(1);
			util.getLocator(LocationField).click();
			util.waitInSecond(1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void datePicker(String startDt,String endDt) throws InterruptedException
	{
		try 
		{
			util.getLocator(datePickerctrl).click();
			util.waitInSecond(1);
			util.getLocator(dtSelect+startDt+"']").click();
			util.waitInSecond(1);
			util.getLocator(dtSelect+endDt+"']").click();
			util.waitInSecond(1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void personDetails(String personName,String child,String age) throws InterruptedException
	{
		try 
		{
			Select drpdwn1 = new Select(util.getLocator(PersonDrp));
			drpdwn1.selectByValue(personName);
			util.waitInSecond(1);
			Select drpdwn2 = new Select(util.getLocator(childDrp));
			drpdwn2.selectByVisibleText(child);
			util.waitInSecond(1);
			Select drpdwn3 = new Select(util.getLocator(ageDrp));
			drpdwn3.selectByVisibleText(age);
			util.waitInSecond(1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<WebElement> ClickSearch() throws InterruptedException
	{
		List<WebElement> wb=null;
		try 
		{
			util.getLocator(searchBtn).click();
			util.waitInSecond(2);
			
			wb = util.getLocators(hotelsLink);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return wb;
	}

}

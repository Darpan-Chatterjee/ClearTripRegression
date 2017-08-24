package com.ClearTrip.Regression.Hotel.Page;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.ClearTrip.Regression.UtilityMethods.GlobalVariable;
import com.ClearTrip.Regression.UtilityMethods.UtilityMethod;

public class HotelSearchPage {
	
	public String LocationField,LocationValue,datePickerctrl,dtSelect,PersonDrp,childDrp,ageDrp,searchBtn;
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
	}
	
	public void HotelLocation(String loc1,String loc2) throws InterruptedException
	{
		try 
		{
			GlobalVariable.driver.findElement(By.xpath(LocationField)).sendKeys(loc1);
			util.waitInSecond(2);
			GlobalVariable.driver.findElement(By.xpath(LocationValue+loc2+"')]")).click();
			util.waitInSecond(1);
			GlobalVariable.driver.findElement(By.xpath(LocationField)).click();
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
			GlobalVariable.driver.findElement(By.xpath(datePickerctrl)).click();
			util.waitInSecond(1);
			GlobalVariable.driver.findElement(By.xpath(dtSelect+startDt+"']")).click();
			util.waitInSecond(1);
			GlobalVariable.driver.findElement(By.xpath(dtSelect+endDt+"']")).click();
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
			Select drpdwn1 = new Select(GlobalVariable.driver.findElement(By.xpath(PersonDrp)));
			drpdwn1.selectByVisibleText(personName);
			util.waitInSecond(1);
			Select drpdwn2 = new Select(GlobalVariable.driver.findElement(By.xpath(childDrp)));
			drpdwn2.selectByVisibleText(child);
			util.waitInSecond(1);
			Select drpdwn3 = new Select(GlobalVariable.driver.findElement(By.xpath(ageDrp)));
			drpdwn3.selectByVisibleText(age);
			util.waitInSecond(1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void ClickSearch() throws InterruptedException
	{
		try 
		{
			GlobalVariable.driver.findElement(By.xpath(searchBtn)).click();
			util.waitInSecond(2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

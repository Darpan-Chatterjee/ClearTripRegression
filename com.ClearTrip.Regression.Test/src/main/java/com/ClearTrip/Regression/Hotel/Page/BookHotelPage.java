package com.ClearTrip.Regression.Hotel.Page;

import java.util.Properties;
import com.ClearTrip.Regression.UtilityMethods.UtilityMethod;

public class BookHotelPage {
	
	public String SelectRoom,BookRoom,Comment;
	public String ConfigPath="..\\com.ClearTrip.Regression.Test\\src\\main\\resources\\Page Map\\BookPage.Properties";
	UtilityMethod util=new UtilityMethod();
	
	public BookHotelPage() throws Exception
	{
		Properties prop=util.LoadProperty(ConfigPath);
		SelectRoom=prop.getProperty("SelectRoom");
		BookRoom=prop.getProperty("BookRoom");
		Comment=prop.getProperty("Comment");
	}
	
	public String BookHotel() throws InterruptedException
	{
		String Message="";
		try 
		{
			util.getLocator(SelectRoom).click();
			util.waitInSecond(2);
			util.getLocator(BookRoom).click();
			util.waitInSecond(1);
			Message=util.getLocator(Comment).getText();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return Message;
	}

}

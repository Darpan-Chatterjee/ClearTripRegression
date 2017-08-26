package com.ClearTrip.Regression.UtilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilityMethod 
{
	public WebDriver openURL(String browserName,String URL)
	{
		if(browserName.equals("Firefox"))
		{
			GlobalVariable.driver = new FirefoxDriver();
		}
		else if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "..\\com.ClearTrip.Regression.Test\\src\\test\\resources\\Browser Driver\\chromedriver.exe");
			GlobalVariable.driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "..\\com.ClearTrip.Regression.Test\\src\\test\\resources\\Browser Driver\\IEDriverServer.exe");
			GlobalVariable.driver = new InternetExplorerDriver();
		}
		GlobalVariable.driver.manage().window().maximize();
		GlobalVariable.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		GlobalVariable.driver.get(URL);
		return GlobalVariable.driver;
	}
	
	public Properties LoadProperty(String path) throws Exception
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
	public String SearchExcel(String path,String TCName, String ColName) throws Exception
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		GlobalVariable.wb = new XSSFWorkbook(fis);
		int lastRowNum=GlobalVariable.wb.getSheetAt(0).getLastRowNum();
		String rowTempVal,colTempVal="";
		String cellValue=null;
		int tcRowNum=-1;
		int colNum=-1;
		for(int i=0;i<=lastRowNum;i++)
		{
			rowTempVal=GlobalVariable.wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();
			if(rowTempVal.equals(TCName))
			{
				tcRowNum=i;
				break;
			}
		}
		int lastColNum=GlobalVariable.wb.getSheetAt(0).getRow(0).getLastCellNum();
		for(int i=0;i<lastColNum;i++)
		{
			colTempVal=GlobalVariable.wb.getSheetAt(0).getRow(0).getCell(i).getStringCellValue();
			if(colTempVal.equals(ColName))
			{
				colNum=i;
				break;
			}
		}
		if(tcRowNum==-1||colNum==-1)
		{
			GlobalVariable.wb.close();
			return null;
		}
		cellValue=GlobalVariable.wb.getSheetAt(0).getRow(tcRowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}
	
	public void Screenshot(String path,String name) throws IOException
	{
		//GlobalVariable.screenshotNum=GlobalVariable.screenshotNum+1;
		File src = ((TakesScreenshot)GlobalVariable.driver).getScreenshotAs(OutputType.FILE);
		String copyScreenshotPath = path+"\\"+name+".png";
		File copyScreenshot = new File(copyScreenshotPath);
		FileUtils.copyFile(src, copyScreenshot);
	}
	
	public void waitInSecond(int time) throws InterruptedException
	{
		Thread.sleep(time*1000);
	}
	
	public WebElement getLocator(String xpath){
		WebDriverWait myWait = new WebDriverWait(GlobalVariable.driver, 10);
		WebElement getElementXpath = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return getElementXpath;
	}
		
	public List<WebElement> getLocators(String xpath)
	{
		List<WebElement> getElementXpath = GlobalVariable.driver.findElements(By.xpath(xpath));
		return getElementXpath;
	}

}

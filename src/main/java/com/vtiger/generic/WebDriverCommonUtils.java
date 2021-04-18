package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.mysql.cj.jdbc.Driver;

public class WebDriverCommonUtils implements ITestResult {
	/**
	 * @author Shital
	 *Switch to alert and capture msg of alert
	 *@param driver
	 
	 *return alert massage 
	 
	 */
	public String switchToAlertCapturemsg(WebDriver driver)
	{
		
		String altmsg=driver.switchTo().alert().getText();
		System.out.println("Alert Message of "+":- " +altmsg);
		return altmsg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @author Shital
	 *To fetch the data from proerties file
	 *@param path of property file
	 *@param pass key for which u want to read data
	 *return string value of key 
	 *throws IOException
	 */
	
		FileInputStream fis;
		public  String getDataFromProperty(String path,String key) throws IOException
				{
				
					fis =new FileInputStream(path);
					Properties pobj=new Properties();
					pobj.load(fis);
					return pobj.getProperty(key);
					
				}

		/**
		 * @author Shital
		 *To fetch the data from Excel file
		 *@param path of property file
		 *@param pass Sheetname,rowno,cellno for which u want to read data
		 *return string value of Sheetname,rowno,cellno 
		 *throws IOException
		 */
				public  String getDataFromExcel(String path,String SheetName, int RowNum,int cellnum)throws IOException
				{                                 
					fis =new FileInputStream(path);
					//FileInputStream fis =new FileInputStream("E:\\. SHITAL\\DataForDDT\\TestScriptDataExcel\\Lead.xlsx");
					Workbook book = WorkbookFactory.create(fis);
					
					return book.getSheet(SheetName).getRow(RowNum).getCell(cellnum).getStringCellValue();
				

			}
				/**
				 * @author Shital
				 *To get row count
				 *@param path of Excel file
				 *@param pass Sheetname,rowno,cellno for which u want to read data
				 *return int count
				 *throws IOException
				 * */
				 public  int getExcelRowCount(String path,String SheetName)throws IOException
				{                                 
					fis =new FileInputStream(path);
					
					Workbook book = WorkbookFactory.create(fis);
					
					return book.getSheet(SheetName).getLastRowNum();
				}
				
				
				
				
				public  void updateCellDataInExcel(String SheetName, int RowNum,int cellnum,String newData)throws IOException
				{
				       fis =new FileInputStream("C:\\Users\\Sandy\\Desktop\\DataBucket\\spicejetdata.xlsx");
					Workbook book = WorkbookFactory.create(fis);
					
					Cell cel= book.getSheet(SheetName).getRow(RowNum).getCell(cellnum);//for update @get@
					cel.setCellValue(newData);
					FileOutputStream fos=new FileOutputStream("");
					book.write(fos);
					fos.flush();
				
				}
				public  void addNewCellDataInExcel(String SheetName, int RowNum,int cellnum,String newData)throws IOException
				{
					fis =new FileInputStream("C:\\Users\\Sandy\\Desktop\\DataBucket\\spicejetdata.xlsx");
					Workbook book = WorkbookFactory.create(fis);
					/*Sheet s=book.getSheet(SheetName);
					Row row=s.getRow(RowNum);
					Cell cel=row.getCell(cellnum);*/
					Cell cel= book.createSheet(SheetName).createRow(RowNum).createCell(cellnum);//for new @create@
					cel.setCellValue(newData);
					FileOutputStream fos=new FileOutputStream("");
					book.write(fos);
					fos.flush();
				
				}
				
				
/**
 * @throws SQLException 
 * @author Shital
 *To fetch data from Database
 *@param pass  Show databases Query
 *@param pass  use databases Query
 *@param pass  eQuery
 * */				
public void fetchDataFromDataBaseExecuteQuery(String Showdbquery ,String usedbquery,String equery) throws SQLException
{
	Connection con=null;
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTable","root","root");
	
	Statement stat=con.createStatement();
	ResultSet result2= stat.executeQuery(Showdbquery ); //2
	while(result2.next())
	{System.out.println( result2.getString(1));
     }
	 ResultSet result3= stat.executeQuery(usedbquery);//3
	//crete table
	//int crttable= stat.executeUpdate("create table MyNameIdAgeTable(name varchar (20),id Integer ,age Integer);");
	System.out.println("---------Table to use----------");
	 ResultSet result=stat.executeQuery(equery);
	 while(result.next())
	{
		System.out.println(result.getString(1)+"\t"+result.getString(2));
	}
}


/*
 * pickItemFromList 
 */

public void  pickItemFromList(WebElement list ,String item)
{

	Select s=new Select(list);
	List<WebElement>alllist=s.getOptions();
	for(WebElement wb:alllist)
	{
		if(wb.getText().equals(item))
		{
			s.selectByVisibleText(item);
		}
	}
}






/**
 * Maximize the browser
 */

	 
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	
	
/**
	 * Wait until Page is loaded
	 */
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Iconstant.implicitwaittime, TimeUnit.SECONDS);
	}
	/**
	 * Wait until Given element is clickable
	 * @param element
	 */
	public void elementisclickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Iconstant.explicitwaittime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Select elemet from dd by visible text
	 * @param element
	 * @param visibletext
	 */

	public void selectbyvisisbletextdd(WebElement element,String visibletext)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	/**
	 * Select elemet from dd by index 
	 * @param element
	 * @param index
	 */
	public void selectbyindexdd(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * Select elemet from dd by value
	 * @param element
	 * @param value
	 */

	public void selectbyvaluedd(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * Refresh the given page
	 */
	public void refresh(WebDriver driver) 
	{
		driver.navigate().refresh();
	}
	/**
	 * Switch frame by index
	 * @param index
	 */
	public void switchframebyindex(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}

	public void switchbyelement(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchframebynameorid(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}

	public void movetoelement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void draganddrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
				
	

	}
	
	
	
	
	/**
	 * Wait for elemet until it is displayed
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitforElement(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<40) 
			try{

				element.isDisplayed();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(500);
			count++;
		}
	}
	
	
	
	
	
	/**
	 * Wait for element and once availabel click on it.
	 * @param driver
	 * @param xpath
	 * @throws InterruptedException
	 */
	public void waitandclick(WebDriver driver,String xpath) throws InterruptedException 
	{
		int count=0;
		while(count<40) 
			try{
				driver.findElement(By.xpath(xpath)).click();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(500);
			count++;
		}
	}
	
	
	/**
	 * Switch tom desired windows
	 * @param driver
	 * @param windowtitleexp
	 */
	public void switchtodwindow(WebDriver driver, String windowtitleexp) 
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while(it.hasNext()) 
		{
			String winid = it.next();
			driver.switchTo().window(winid);
			String acttitle = driver.getTitle();
			if(acttitle.contains(windowtitleexp)) 
			{
				break;
			}
		}
	}
	
	/**
	 * Switch to child window
	 * @param 
	 * @throws 
	 */
	String mainid;
	String childid;
	public void childWindowHanlde(WebDriver driver)
	{
	//String mainid=driver.getWindowHandle();
	Set<String> allid=driver.getWindowHandles();
	 Iterator<String> itr=   allid.iterator();
	   
	   mainid=itr.next();
	   childid =itr.next();
	   driver.switchTo().window(childid);

	
	}
	public void mainWindowHandle(WebDriver driver)
	{
		driver.switchTo().window(mainid);
	}

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(ITestResult arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ITestNGMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameters(Object[] parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IClass getTestClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Throwable getThrowable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setThrowable(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getStartMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getEndMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEndMillis(long millis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstanceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestContext getTestContext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	}
	   
	
	
	



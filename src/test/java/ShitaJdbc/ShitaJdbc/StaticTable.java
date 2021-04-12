package ShitaJdbc.ShitaJdbc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticTable {

	public static void main(String[] args) {
		  WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.selenium.dev/downloads/");

			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			List<WebElement>text= driver.findElements(By.xpath("//table[@class='data-list']/tbody//tr/td[1]"));
			List<WebElement>l1= driver.findElements(By.xpath  ("//table[@class='data-list']/tbody//tr/td[1]"));
			for(WebElement wb:text)
			{
				 String s=wb.getText();
				 System.out.println(s);
				 if(s.equals("Python"))
			     {
					 
					 WebElement v=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[3]/td[1]/following-sibling::td"));
					 System.out.println(v.getText());
				 }
			}
			
			
			
		/*	
			for(int i=0;i<l1.size();i++)
			{
				System.out.println(l1.get(i).getText());
				
				if(l1.get(i).getText().equals("Python"))
			     {
					  
	 WebElement v=driver.findElement(By.xpath("//table[@class='data-list']/tbody//tr/td[1]/following-sibling::td"));
	              //table[@class='data-list']/tbody/tr/td[@data-label='Stable Version']
	                //table[@class='data-list']/tbody//tr/td[2]
					 System.out.println(v.getText());
				 }
			}*/

	}

}

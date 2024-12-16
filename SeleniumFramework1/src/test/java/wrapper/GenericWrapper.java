package wrapper;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericWrapper implements Wrapper {
	
	RemoteWebDriver driver;

	
	public void invokeApp(String browser,String url) {
		
		
		try{
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
		        driver=new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				
                //System.setProperty("webdriver.gecko.driver","C:\\Users\\sjapa\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("edge")) {
				//System.setProperty("webdriver.edge.driver","C:\\Users\\sjapa\\Downloads\\edgedriver_win64\\msedgedriver.exe");
				//RemoteWebDriver driver = new EdgeDriver();
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}
		
		    driver.get(url);
		    driver.manage().window().maximize();
		    System.out.println(browser +" was launched successfully");
		
		}
		catch(SessionNotCreatedException e) {
			System.err.println("Session not created due to Sessionnot created error");
		}catch(NoSuchMethodError e) {
			System.err.println("NoSuchMethodError error");
		}

  }
	
	public void findByName(String name, String data) {
		
		try {
			driver.findElement(By.name(name)).sendKeys(data);
			System.out.println(name + "is entered with " +data);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator by name not found");
		}
	}
	
	public void findById(String id ,String data) {
		
		try {
			driver.findElement(By.id(id)).sendKeys(data);
			System.out.println(id +"is entered with data " + data);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator id not found");
		}
	}
	
	public void findByXpath(String xpath,String data) {
		try {
			driver.findElement(By.xpath(xpath)).sendKeys(data);
			System.out.println(data + "is entered in XPath >> "+ xpath);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator id not found");
		}
	}
	
	public void findByNameClick(String name) {
		
		try {
			driver.findElement(By.name(name)).click();
			System.out.println(name +" <<weblocator  found");
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator " +name +" not found");
		}
		
	}
	
	public void findByIdClick(String id) {
		
		try {
			driver.findElement(By.id(id)).click();
			System.out.println(id +" <<weblocator  found");
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator " +id +" not found");
		}
	}
	
	public void findByXpathClick(String xpath) {
		try {
			driver.findElement(By.xpath(xpath)).click();
			System.out.println(xpath +" <<weblocator  found");
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator " +xpath +" not found");
		}
			
		
	}
	
	public void selectIndexById(String id, int index) {
		
		try {
			
			WebElement web_obj = driver.findElement(By.id(id));
			
			Select sel= new Select(web_obj);
			
			sel.selectByIndex(index);
			System.out.println("the id weblocator" +id +" successfully selected the option with index" +index);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator id>>" +id +" not found");
		}
	}
	
	public void selectIndexByName(String name, int index) {
       
		try {
			
			WebElement web_obj = driver.findElement(By.name(name));
			
			Select sel= new Select(web_obj);
			
			sel.selectByIndex(index);
			System.out.println("the name weblocator" +name +" successfully selected the option with index" +index);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator name>>" +name +" not found");
		}
		
	}
	
	public void selectIndexByXpath(String xpath,int index) {
		
		try {
			
			WebElement web_obj = driver.findElement(By.xpath(xpath));
			
			Select sel= new Select(web_obj);
			
			sel.selectByIndex(index);
			System.out.println("the xpath weblocator" +xpath +" successfully selected the option with index" +index);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator xpath>>" +xpath +" not found");
		}
		
	}
	
	public void selectbyVisibleTextById(String id ,String text) {
	
		try {
			WebElement web_obj = driver.findElement(By.id(id));
			
			Select sel= new Select(web_obj);
			
			sel.selectByVisibleText(text);
			System.out.println("the id weblocator" +id +" successfully selected the option with visible text" +text);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator id>>" +id +" not found");
		}
			
			
	}
	
	public void selectbyVisibleTextByName(String name ,String text) {
		try {
		WebElement web_obj = driver.findElement(By.name(name));
		
		Select sel= new Select(web_obj);
		//text= text.equalsIgnoreCase(text);
		sel.selectByVisibleText(text);
		System.out.println("the name weblocator" +name +" successfully selected the option with visible text" +text);
	}
	catch(NoSuchElementException e) {
		System.err.println("web locator name>>" +name +" not found");
	}
	}
	
	public void selectbyVisibleTextByXpath(String xpath ,String text) {
		
		try {
			WebElement web_obj = driver.findElement(By.xpath(xpath));
			
			Select sel= new Select(web_obj);
			
			sel.selectByVisibleText(text);
			System.out.println("the xpath weblocator" +xpath +" successfully selected the option with visible text" +text);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator name>>" +xpath +" not found");
		}
		
	}
	
	public void selectValueById(String id ,String value) {
		
		try {
			WebElement web_obj = driver.findElement(By.id(id));
			
			Select sel= new Select(web_obj);
			
			sel.selectByValue(value);;
			System.out.println("the id weblocator" +id +" successfully selected the option with value" +value);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator id>>" +id +" not found");
		}
		
		
	}
	
	public void selectValueByName(String name ,String value) {
		
		try {
			WebElement web_obj = driver.findElement(By.name(name));
			
			Select sel= new Select(web_obj);
			
			sel.selectByValue(value);;
			System.out.println("the name weblocator" +name +" successfully selected the option with value" +value);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator name>>" +name +" not found");
		}
	}
	
	public void selectValueByXpath(String xpath ,String value) {
		try {
			WebElement web_obj = driver.findElement(By.xpath(xpath));
			
			Select sel= new Select(web_obj);
			
			sel.selectByValue(value);;
			System.out.println("the xpath weblocator" +xpath +" successfully selected the option with value" +value);
		}
		catch(NoSuchElementException e) {
			System.err.println("web locator xpath>>" +xpath +" not found");
		}
	}
	
	public void sleep(long time) {

		try {
			 Thread.sleep(time);
	
			System.out.println("Driver Wait is performing with "+ time);
		} catch (WebDriverException e) {
			
			System.err.println("Something went wrong while waitngdriver.");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			System.err.println("Thread is interupted.");

		}
	}


	public void closeBrowser() {
		
		try {
			driver.close();
			System.out.println("Driver closed Succefully.");
		} catch (WebDriverException e) {
		
			System.err.println("Unknow error while closing driver.");
		}
	}
	
	public void closeAllbrowsers() {
		
		try {
			driver.quit();
			System.out.println("all Drivers closed Succefully.");
		} catch (WebDriverException e) {
		
			System.err.println("Unknow error while quiting driver.");
		}
	}
	

}//end of class GenericWrapper	

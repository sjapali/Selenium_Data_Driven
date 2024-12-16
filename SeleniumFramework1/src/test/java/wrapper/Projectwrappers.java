package wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Projectwrappers extends GenericWrapper {
	
	@BeforeMethod
	public void beforemethod(){
		invokeApp("chrome","https://www.facebook.com/r.php");
	}
	/*
    @AfterMethod
    public void aftermethod() {
    	closeAllbrowsers();
    	
    }
    */
}

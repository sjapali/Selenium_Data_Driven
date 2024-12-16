package testcases;

import org.testng.annotations.Test;

import utils.DP001;
import wrapper.GenericWrapper;
import wrapper.Projectwrappers;

public class FbSigupTC001 extends GenericWrapper {
	
	@Test(dataProvider="fbreg", dataProviderClass= DP001.class)
	
	public void fbRegistration(String firstname, String lastname) {
		
		invokeApp("firefox", "https://www.facebook.com/r.php");
		//sleep(3000);
		findByName("firstname",firstname);
		sleep(3000);
		findByName("lastname",lastname);
		sleep(3000);
		closeAllbrowsers();
		
		
		
		
	}
	
	

}

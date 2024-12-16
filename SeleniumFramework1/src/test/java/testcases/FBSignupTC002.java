package testcases;

import org.testng.annotations.Test;

import utils.DP002;
import wrapper.GenericWrapper;

public class FBSignupTC002 extends GenericWrapper{
	
	
	@Test(dataProvider="fbreg2", dataProviderClass= DP002.class)
	
	public void fbregister(String firstname,String lastname,String month,String day,String year,String gender,String email,String pwd)
	{
		sleep(1000);
		invokeApp("firefox","https://www.facebook.com/r.php");
		sleep(1000);
		findByName("firstname",firstname);
		findByName("lastname",lastname);
		selectbyVisibleTextByName("birthday_month" ,month);
		selectbyVisibleTextByName("birthday_day" ,day);
		selectbyVisibleTextByName("birthday_year" ,year);
		

		if (gender.equalsIgnoreCase("Female")) {
			findByXpathClick("//label[text()='Female']");
		} else if (gender.equalsIgnoreCase("Male")) {
			findByXpathClick("//label[text()='Male']");
		} else if (gender.equalsIgnoreCase("Custom")){
			findByXpathClick("//label[text()='custom']");
		}
			
		findByName("reg_email__",email);
		findByName("reg_passwd__",pwd);
		
		sleep(3000);
		findByNameClick("websubmit");
		
		closeAllbrowsers();
		
		
	}
	
	

}

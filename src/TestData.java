import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class TestData {

	
	
	
	String URL  = "https://www.clevelandclinicabudhabi.ae"; 
    WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

   
    //Test001
	String ExpectedLang_001 = "en"; 

	//Test002
	String SearchKeyInput = "cancer"; 
	boolean ExpectedResult_002 = true;
	
	//Test003 
	
	String Email = "layanomar417@gmail.com"; 
	String FirstName = "layan"; 
	String LastName = "Omar"; 
	String Country_Sign = "+962";
	String PhoneNumber = "799646707" ; 
	
	String Gender = "female" ; 
	Boolean  Emirates_Id = false; 
	String Country = "Jordan"; 
	Boolean FirstVisit = true; 
	String BirthDay = "3"; 
	String BirthMonth = "12" ; 
	String BirthYear="001998" ; 
	String Service = "Digestive Diseases";
	Boolean HealthInsurance = false; 
	String WhyVisit = "I have many gut problems";
	//Test 004 
	double Height_cm = 164; 
	double  Weight_kg = 57; 


    JavascriptExecutor js = (JavascriptExecutor) driver;

	
	public double  BMI(double height, double weight) {
		
		  double heightM = height / 100.0;  // convert cm to meters
		    double bmi = weight / (heightM * heightM);
		    bmi = Math.round(bmi * 10.0) / 10.0; 
		    return bmi;
	}
	double ExpectedResult_004 = BMI(Height_cm , Weight_kg) ; 
}

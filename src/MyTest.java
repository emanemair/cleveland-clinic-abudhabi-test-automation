import java.net.HttpURLConnection;
import java.net.URI;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;
import java.net.URL;


public class MyTest extends TestData {


    
	 @BeforeTest
	 public void Mysetup() {
	    	
	  driver.get(URL);
	  driver.manage().window().maximize(); 
	        	
	 }
	 
	 @Test(priority = 1 , enabled = true)
	    public void HomePageLoaded() {
		 
		 driver.get(URL);
		 // Navigation Bar
		 WebElement NavBar = driver.findElement(By.className("MainNavigation")); 
		 Assert.assertTrue(NavBar.isDisplayed() , "Navigation bar should be visible");
		 
		 //Banner 
		 List <WebElement> Banners = driver.findElements(By.cssSelector("section.HeroSection , section.PatientStories , section.AboutSection , section.InsurancePartnerSection"));
		 

		 for (WebElement banner : Banners)
		 {
			 if(!banner.isDisplayed()) {
				 
				 bannerIsVisible = false; 
				 break; 
			 }
			 
		 }
		 
		 Assert.assertTrue(bannerIsVisible , "All Banners Should be Visible");
		 
		 //Footer 
		 WebElement Footer = driver.findElement(By.tagName("footer")); 
		 Assert.assertTrue(Footer.isDisplayed() , "Footer Should be Visible");
				 
		 
	    }
	 
	 @Test(priority = 2 , enabled =true) 
	 public void NavigationFunctionality() {
	
		 driver.get(URL);
		 for (String  linkText : navItems.keySet() ) {
			 
			 String expectedURLpart = navItems.get(linkText);
	         driver.get("https://www.clevelandclinicabudhabi.ae/en");
	         
	         WebElement navLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
	            navLink.click();
	         
	            wait.until(ExpectedConditions.urlContains(expectedURLpart));
	            String currentUrl = driver.getCurrentUrl();

	            Assert.assertTrue(currentUrl.contains(expectedURLpart), "❌ Navigation to "  + linkText + " failed. URL was: " + currentUrl );
		 }
		 
		 driver.get(URL);
	 }
	 
	 
    @Test(priority = 3 , enabled = true)
    public void T003_WebsiteLang_en() {
    	
    	
    	driver.get(URL);
    	String ActualLang_003 = driver.findElement(By.tagName("html")).getDomAttribute("lang"); 
    	
    	Assert.assertEquals(ActualLang_003, ExpectedLang_003);
    	
   
    }
    
   
    
    
    @Test(priority = 4, enabled = true) 
    public void T004_SearchFunctionality() {
    	
    	driver.get(URL) ;
    	WebElement SearchLink = driver.findElement(By.className("StripNav")).findElements(By.tagName("li")).get(0);  
    	SearchLink.click(); 
    	
    	
    	WebElement SearchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtGlobalSearch")));
    	
    	SearchInput.sendKeys(SearchKeyInput + Keys.ENTER);
    	
    	WebElement SearchResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtResult"))); 
    	String SearchResultText = SearchResultElement.getText(); 
    	
    	boolean ActualResult_004 = SearchResultText.toLowerCase().contains(SearchKeyInput); 
    	
    	Assert.assertEquals(ActualResult_004, ExpectedResult_004);
    }
    
    @Test(priority = 5 , enabled = true)
    public void T003_ReqAppointment() throws InterruptedException {
    	
    	driver.get(URL);
    	driver.findElement(By.linkText("Request an Appointment")).click(); 
    	WebElement AppointmentForm =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("online-forms"))); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AppointmentForm);
        
        WebElement FirstNameInput = AppointmentForm.findElement
        (By.id
        		("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_f9299103-b3d3-47e0-a64d-ef989e20b1f0__Value")); 
        WebElement LastNameInput = AppointmentForm.findElement
        		(By.id
        				("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_a90b41b2-7e51-4198-93e7-a11def3c1fb1__Value")); 
        
        
        FirstNameInput.sendKeys(FirstName); 
        LastNameInput.sendKeys(LastName);
        
        WebElement DateOfBirth = AppointmentForm.findElement
        		(By.id("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_841fa6ea-d1c2-44aa-a298-59259448e651__Value")); 
        DateOfBirth.sendKeys(BirthMonth);
        DateOfBirth.sendKeys(BirthDay);
        DateOfBirth.sendKeys(BirthYear + Keys.ENTER);
        
        //gender input 
  
       String GenderValue = Gender.substring(0,1).toUpperCase() + Gender.substring(1);
       
       WebElement GenderButton = AppointmentForm.findElement
    		    (By.xpath("//input[@value='" + GenderValue + "']")); 
       
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", GenderButton);
       

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("#fxb_d1379fba_5889_4831_a334_07b9d78d7568_Fields_c11a4935_eee4_48a2_8d54_6b7c1568ac61__Value_select_chosen")
    ));

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", countryDropdown);
    Thread.sleep(500); // wait for smooth scrolling

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", countryDropdown);

    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector(".chosen-search input")
    ));
    searchInput.sendKeys(Country_Sign);

    WebElement countryResult = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(".chosen-results li.active-result")
    ));
    countryResult.click();

    WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(
        By.id("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_c11a4935-eee4-48a2-8d54-6b7c1568ac61__Value_input")
    ));
    phoneInput.sendKeys(PhoneNumber + Keys.ENTER ); 
    
    //email 
    AppointmentForm.findElement
    (By.id("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_2e1e8cd7-6984-4dd8-ae42-60a340153cde__Value")).
    sendKeys(Email );
    
    String ID_value = "false"; 
    if(Emirates_Id) {
    	
    	ID_value = "true"; 
    }

    List<WebElement> ID_Buttons = AppointmentForm.findElements(By.xpath("//input[@data-sc-field-name='rdbEmirates']"));
    
    for(WebElement button : ID_Buttons ) {
    	
    	String Value = button.getDomAttribute("value"); 
    	   if (Value != null && Value.equals(ID_value)) {
               // Scroll into view
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

               // Optional: use JS click if normal click fails
               try {
                   button.click();
               } catch (ElementNotInteractableException e) {
                   System.out.println("Standard click failed, using JavaScript click...");
                   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
               }

               System.out.println("Clicked radio with value: " + Value);
               break;
           }
    }
    		
   
    //country 
    WebElement CountryDiv = AppointmentForm.findElement(By.id("fxb_d1379fba_5889_4831_a334_07b9d78d7568_Fields_41d924c5_1ada_4560_a73f_faf3fd8b07ea__Value_chosen")); 
    
    WebElement SelectCountryButton = CountryDiv.findElement(By.cssSelector(".chosen-single.chosen-default"));
    ((JavascriptExecutor) driver ).executeScript("arguments[0].click()",SelectCountryButton );
    
    CountryDiv.findElement(By.className("chosen-search-input")).sendKeys(Country + Keys.ENTER); 
     
    
    //first visit 
    
    String VisitValue = "false"; 
    if (FirstVisit) {
    	VisitValue = "true"; 
    	
    }
    
    List<WebElement> VisitTypeButtons = AppointmentForm.findElements(By.xpath("//input[@data-sc-field-name='rdbVisit']"));
    for (WebElement button : VisitTypeButtons) {
        String value = button.getDomAttribute("value");

        if (value != null && value.equals(VisitValue)) {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

            // Optional: use JS click if normal click fails
            try {
                button.click();
            } catch (ElementNotInteractableException e) {
                System.out.println("Standard click failed, using JavaScript click...");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            }

            System.out.println("Clicked radio with value: " + value);
            break;
        }
    	
    }
    
    //service 
    
    WebElement ServiceDiv = AppointmentForm.findElement
    		(By.id("fxb_d1379fba_5889_4831_a334_07b9d78d7568_Fields_b10c772d_c6a4_40ab_b0ed_c45f57a82c54__Value_chosen")); 
    
    WebElement SelectServiceButton = ServiceDiv.findElement(By.cssSelector(".chosen-single.chosen-default"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SelectServiceButton);
    Thread.sleep(500);
    ((JavascriptExecutor) driver ).executeScript("arguments[0].click()",SelectServiceButton );
    
    ServiceDiv.findElement(By.className("chosen-search-input")).sendKeys(Service + Keys.ENTER); 
    
    //why visiting 
    WebElement TextArea = AppointmentForm.findElement(By.id("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_898bae0e-53f5-4c7d-b25d-9fed3586f84b__Value")); 
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TextArea ); 
    Thread.sleep(500); 
    TextArea.sendKeys(WhyVisit + Keys.ENTER); 
    
    //Health Insurance - 
    
    String HaveHealthInsurance = "false"; 
    if(HealthInsurance) {
    	HaveHealthInsurance = "Health Insurance"; 
    }else {
    	
    	HaveHealthInsurance = "Self Payment"; 

    }
    
    
    List<WebElement> HealthInsuranceButtons = AppointmentForm.findElements(By.xpath("//input[@data-sc-field-name='rdbInsurance']")); 
    
    for (WebElement button : HealthInsuranceButtons) {
    	
    	 String value = button.getDomAttribute("value");

         if (value != null && value.equals(HaveHealthInsurance)) {
             // Scroll into view
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

             // Optional: use JS click if normal click fails
             try {
                 button.click();
             } catch (ElementNotInteractableException e) {
                 System.out.println("Standard click failed, using JavaScript click...");
                 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
             }

             System.out.println("Clicked radio with value: " + value);
             break;
         }
     	
    } 
    //Privacy Concerns 
    
    WebElement PrivacyButton = AppointmentForm.findElement(By.id("fxb_d1379fba-5889-4831-a334-07b9d78d7568_Fields_13ef172f-d53d-45db-b6c5-546c852f88b6__Value")); 
    
    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", PrivacyButton); 
    
    
    WebElement SubmitButton = AppointmentForm.findElement(By.xpath("//input[@value='Submit Information']")); 
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SubmitButton);  
    
    WebElement ThankYouDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ThankyouInfo"))); 
    Boolean ExpectedResult_003 = true; 
    Boolean ActualResult_003 = ThankYouDiv.findElement(By.tagName("p")).getText().toLowerCase().contains("successfully"); 
    
    Assert.assertEquals(ActualResult_003, ExpectedResult_003); 
    }// End of Test 
    
   
    @Test(priority = 6 , enabled = true)
    public void BMI_Calculator() throws InterruptedException {
    	
    	driver.get(URL);
    	WebElement HealthLibrary = driver.findElement(By.linkText("Health Library")); 
    	Actions action = new Actions(driver); 
    	action.moveToElement(HealthLibrary).perform(); 
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("BMI Calculator"))).click(); 
    	
    	WebElement StartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slide-button"))); 
    	// Scroll to center
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", StartButton);

    	// Small wait after scroll (optional)
    	Thread.sleep(500);

    	// Try standard click first
    	try {
    	    StartButton.click();
    	} catch (ElementClickInterceptedException e) {
    	    // Fallback: click with JavaScript
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", StartButton);
    	}
    	
    	WebElement CalForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("metric-form"))); 
    	WebElement HeightInput = CalForm.findElement(By.id("height_cm")); 
    	WebElement WeightInput = CalForm.findElement(By.id("weight_kg")); 
    	HeightInput.sendKeys(String.valueOf(Height_cm));
    	WeightInput.sendKeys(String.valueOf(Weight_kg));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("final-step"))).click();
    

    	WebElement span = driver.findElement(By.xpath("//span[contains(text(), 'Your BMI is')]"));

    	// Wait until the full text includes a number using JavaScript
    	wait.until(driver1 -> {
    	    JavascriptExecutor js = (JavascriptExecutor) driver1;
    	    String text = (String) js.executeScript("return arguments[0].innerText;", span);
    	    return text.matches("Your BMI is \\d+\\.\\d+");
    	});

    	double bmi= 0 ; 
    	String finalFullResult = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", span);
    	
    	Pattern pattern = Pattern.compile("(\\d+\\.\\d+)");
    	Matcher matcher = pattern.matcher(finalFullResult);

    	if (matcher.find()) {
    	    bmi = Double.parseDouble(matcher.group(1));
    	} 
    	
    	Assert.assertEquals(bmi, ExpectedResult_006); 
    	
} }